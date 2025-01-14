package org.uob.a3.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uob.a3.gameobjects.*;

import java.util.List;

class LookTest {

    private GameState gameState;
    private Player player;
    private Location library;
    private Feature bookshelf;
    private Feature table;
    private Clue ancientTome;

    @BeforeEach
    void setUp() {
        // Initialize GameState and Player
        gameState = new GameState();
        player = new Player("Detective");
        gameState.setPlayer(player);

        // Initialize Location, Features, and Clue
        library = new Location("loc1", "Library", "A dusty library filled with books.", false, null);
        bookshelf = new Feature("feat1", "Bookshelf", "An old bookshelf covered in cobwebs.");
        table = new Feature("feat2", "Table", "A sturdy wooden table with scratches.");
        ancientTome = new Clue("clue1", "Ancient Tome", "An old book with mysterious runes.",
                List.of("book", "ancient"), 7, "This might contain a hidden spell.");

        // Add the features and clue to the location
        library.addFeature(bookshelf);
        library.addFeature(table);
        library.addClue(ancientTome);
        gameState.getMansion().addLocation(library);
        gameState.getMansion().setCurrentLocation("loc1");
    }

    @Test
    void testLookAtRoom() {
        // Look at the current room
        Look look = new Look("");
        String result = look.execute(gameState);

        // Verify the output includes the room description and its contents
        assertTrue(result.contains("A dusty library filled with books."), "Output should include the room description.");
        assertTrue(result.contains("An old bookshelf covered in cobwebs."), "Output should include the bookshelf description.");
        assertTrue(result.contains("A sturdy wooden table with scratches."), "Output should include the table description.");
        assertTrue(result.contains("An old book with mysterious runes."), "Output should include the clue description.");
    }

    @Test
    void testLookAtFeatures() {
        // Look at the features in the room
        Look look = new Look("features");
        String result = look.execute(gameState);

        // Verify the output includes the features in the room
        assertTrue(result.contains("You also see:"), "Output should indicate the player is looking at features.");
        assertTrue(result.contains("An old bookshelf covered in cobwebs."), "Output should include the bookshelf description.");
        assertTrue(result.contains("A sturdy wooden table with scratches."), "Output should include the table description.");
    }

    @Test
    void testLookAtInvalidTarget() {
        // Look at an invalid target
        Look look = new Look("Nonexistent");
        String result = look.execute(gameState);

        // Verify the output indicates the target was not found
        assertEquals("There is nothing named 'Nonexistent' to look at in this location.", result,
                "Output should indicate the target was not found.");
    }

    @Test
    void testLookAtSpecificFeature() {
        // Look at a specific feature
        Look look = new Look("Bookshelf");
        String result = look.execute(gameState);
        // Verify the output includes the specific feature's description
        assertTrue(result.contains("An old bookshelf covered in cobwebs."), "Output should include the bookshelf description.");
    }

    @Test
    void testLookAtSpecificClue() {
        // Look at a specific clue
        Look look = new Look("Ancient Tome");
        String result = look.execute(gameState);

        // Verify the output includes the specific clue's description
        assertTrue(result.contains("An old book with mysterious runes."), "Output should include the clue description.");
    }
}
