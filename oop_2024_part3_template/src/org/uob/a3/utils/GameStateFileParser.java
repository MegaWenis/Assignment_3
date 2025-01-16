package org.uob.a3.utils;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

import org.uob.a3.gameobjects.*;

/**
 * Utility class for parsing a game state from a file.
 *
 * <p>
 * This class reads a structured text file to create a {@code GameState} object,
 * including the player, map, locations, clues, features, and case resolution details.
 * </p>
 */
public class GameStateFileParser {

    /**
     * Parses a game state from the specified file.
     *
     * @param filename the name of the file to parse
     * @return the parsed {@code GameState} object
     */
    public static GameState parse(String filename) {
        GameState root = new GameState();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            root = parseGameState(br);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

    /**
     * Parses a string of raw keywords into a list of individual keywords.
     *
     * @param rawKeywords the raw string containing keywords, typically enclosed in brackets
     * @return a list of parsed keywords
     */
    public static List<String> parseKeywords(String rawKeywords) {
        // Strip the square brackets
        String trimmed = rawKeywords.replace("[", "").replace("]", "").trim();

        // Split by commas and populate the list
        String[] keywordsArray = trimmed.split(";");
        List<String> keywords = new ArrayList<>();

        for (String keyword : keywordsArray) {
            keywords.add(keyword.trim().replace("\"", "")); // Remove surrounding quotes
        }

        return keywords;
    }

    /**
     * Parses the game state from the given {@code BufferedReader}.
     *
     * @param br the {@code BufferedReader} for reading the file
     * @return the parsed {@code GameState} object
     * @throws IOException if an I/O error occurs
     */
    private static GameState parseGameState(BufferedReader br) throws IOException {
        GameState g = new GameState();
        Mansion mansion = new Mansion();
        g.setMansion(mansion);
        ArrayList<String> fileLines = new ArrayList<>();
        String line;
        // Read all lines from the BufferedReader into the fileLines list
        while ((line = br.readLine()) != null) {
            fileLines.add(line.trim());
        }

        Location currentLocation = null;
        ArrayList<Location> locations = new ArrayList<>();

        for (String entry : fileLines) {
            if (entry.startsWith("player")) {
                String[] parts = entry.split(",", 2);
                String name = parts[1];
                g.setPlayer(new Player(name));
            } else if (entry.startsWith("location")) {
                String[] parts = entry.split(",", 6);
                String id = parts[1];
                String name = parts[2];
                String description = parts[3];
                boolean isLocked = Boolean.parseBoolean(parts[4]);
                String requiredClueId = parts[5];

                currentLocation = new Location(id, name, description, isLocked, requiredClueId);
                locations.add(currentLocation);
            } else if (entry.startsWith("feature") && currentLocation != null) {
                String[] parts = entry.split(",", 4);
                String id = parts[1];
                String name = parts[2];
                String description = parts[3];
                currentLocation.addFeature(new Feature(id, name, description));
            } else if (entry.startsWith("clue") && currentLocation != null) {
                String[] parts = entry.split(",", 7);
                String id = parts[1];
                String name = parts[2];
                String description = parts[3];
                List<String> keywords = GameStateFileParser.parseKeywords(parts[4]);
                int relevance = Integer.parseInt(parts[5]);
                String hint = parts[6];

                Clue clue = new Clue(id, name, description, keywords, relevance, hint);
                currentLocation.addClue(clue);
            } else if (entry.startsWith("caseResolution") && currentLocation != null) {
                String[] parts = entry.split(",", 3);
                String solution = parts[2];
                CaseResolution caseResolution = new CaseResolution(GameStateFileParser.parseKeywords(parts[1]), solution);
                g.setCaseResolution(caseResolution);
            }
        }
        g.getMansion().setLocations(locations);
        g.getMansion().setCurrentLocation(locations.get(0).getId());

        return g;
    }
}
