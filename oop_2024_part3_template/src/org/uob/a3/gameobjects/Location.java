package org.uob.a3.gameobjects;

import java.util.ArrayList;

/**
 * Represents a location in the game, which is a type of GameObject.
 * Locations can have clues, features, and a locked state that may depend on specific clues for access.
 */

public class Location extends GameObject {
    //associated variables
    private final ArrayList<Clue> clues;
    private final ArrayList<Feature> features;
    private final boolean isLocked;
    private final  String requiredClueId;
    private Ghost ghost;


    //constructor
    public Location(String id, String name, String description, boolean isLocked, String requiredClueId) {
        super(id, name, description);
        this.clues = new ArrayList<>();
        this.features = new ArrayList<>();
        this.isLocked = isLocked;
        this.requiredClueId = requiredClueId;
        this.ghost = null;
    }


    //adding location characteristics
    public void addClue(Clue clue) {
        clues.add(clue);}

    public void addFeature(Feature feature) {
        features.add(feature);
    }

    public void addGhost(Ghost ghost) {
        this.ghost = ghost;
    }

    public Ghost getGhost(){
        return ghost;
    }

    //returns the clues in a given location
    public ArrayList<Clue> getClues(){
        return new ArrayList<>(clues);
    }

    //gets clue by id in location
    public Clue getClue(String id) {
        for (Clue clue : clues) {
            if (clue.getId().equals(id)) {
                return clue;}
        }
        return null;
    }

    //returns the clue with inputted name
    public Clue getClueByName(String name) {
        for (Clue clue: clues) {
            if (clue.getName().equalsIgnoreCase(name)) {
                return clue;
            }
        }
        return null;
    }
    //returns features in room
    public ArrayList<Feature> getFeatures() {
        return new ArrayList<>(features);
    }
    //returns specific feature by id
    public Feature getFeature(String id) {
        for (Feature feature : features) {
            if (feature.getId().equals(id)) {
                return feature;
            }
        }
        return null;
    }

    //returns feature with inputted name
    public Feature getFeatureByName(String name) {
        for (Feature feature:features) {
            if (feature.getName().equals(name)) {
                return feature;
            }
        }
        return null;
    }

    //self-explanatory
    public boolean hasClue(String clueName) {
        // Standardize clueName for comparison (case insensitive)
        clueName = clueName.trim().toLowerCase();

        for (Clue clue : clues) {
            String clueDisplayName = clue.getName().toLowerCase();

            // Check if the clue name contains the keyword (case-insensitive)
            if (clueDisplayName.contains(clueName)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasFeature(String name) {
        return getFeatureByName(name) != null;
    }

    public boolean isLocked() {
        return isLocked;
    }

    //returns all gameobjects in the room
    public ArrayList<GameObject> getAll() {
        ArrayList<GameObject> allObjects= new ArrayList<>();
        allObjects.addAll(clues);
        allObjects.addAll(features);
        return allObjects;
    }

    //returns a specific object by name
    public GameObject findObjectByName(String name) {
        for (GameObject object : getAll()) {
            if (object.getName().equalsIgnoreCase(name)) {
                return object;
            }
        }
        return null;
    }

    //returns all gameobjects in the location
    @Override
    public String toString() {
        StringBuilder locationDescription =new StringBuilder();
        locationDescription.append("Location: ").append(getName()).append("\n")
                .append("Description: ").append(getDescription()).append("\n")
                .append("Clues: ").append(clues.size()).append("\n")
                .append("Features: ").append(features.size()).append("\n")
                .append("Locked: ").append(isLocked ? "Yes":"No");
        return locationDescription.toString();
    }
}
