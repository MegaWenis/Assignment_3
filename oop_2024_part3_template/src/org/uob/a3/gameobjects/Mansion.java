package org.uob.a3.gameobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

/**
 * Represents the game Mansion, which consists of a collection of locations and the current location the player is in.
 * The mansion allows for adding new locations, retrieving locations by name or ID, and managing the player's current location within the game world.
 */
public class Mansion {
    // Locations are stored with their ID's
    private final java.util.Map<String, Location> locations;
    private Location currentLocation;
    private final Set<String> discoveredLocations;

    //constructs empty mansion
    public Mansion() {
        this.locations = new HashMap<>();
        this.currentLocation = null;
        this.discoveredLocations = new HashSet<>();
    }

    //adds location to mansion
    public void addLocation(Location location) {
        locations.put(location.getId(), location);
    }

    //gets the location player is currently in
    public Location getCurrentLocation() {
        return currentLocation;
    }

    //retrieves location by name
    public Location getLocationByName(String name) {
        for (Location location : locations.values()) {
            if (location.getName().equals(name)) {
                return location;
            }
        }
        return null;
    }

    //retrieves all locations in mansion map
    public ArrayList<Location> getLocations() {
        return new ArrayList<>(locations.values());
    }

    //sets location based on location id
    public void setCurrentLocation(String locationId) {
        Location location = locations.get(locationId);
        if (location != null) {
            this.currentLocation = location;
            discoveredLocations.add(locationId);
        } else {
            System.out.println("Location with ID " + locationId + " not found.");
        }
    }

    //sets all the locations in mansion all at once. use when initialising game state
    public void setLocations(ArrayList<Location> locations) {
        for (Location location : locations) {
            addLocation(location);
        }
    }

    //returns string representation of mansion with all the locations
    @Override
    public String toString() {
        StringBuilder mansionDescription = new StringBuilder();
        mansionDescription.append("Mansion: ");
        for (Location location : locations.values()) {
            mansionDescription.append(location.toString()).append("\n");
        }
        return mansionDescription.toString();
    }
}
