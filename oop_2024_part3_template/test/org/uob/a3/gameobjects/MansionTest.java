package org.uob.a3.gameobjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MansionTest {

    private Mansion mansion;
    private Location location1;
    private Location location2;

    @BeforeEach
    void setUp() {
        // Initialize the Mansion object
        mansion = new Mansion();

        // Create Location objects
        location1 = new Location("loc1", "Grand Hall", "A vast, ornate hall with towering columns.", false, null);
        location2 = new Location("loc2", "Dining Room", "A room with a long table set for a feast.", true, "clue1");
    }

    @Test
    void testAddLocation() {
        mansion.addLocation(location1);
        mansion.addLocation(location2);

        // Use the toString to verify locations are added
        String expectedOutput = "Mansion:\n" +
                                location1.toString() + "\n" +
                                location2.toString() + "\n";
        assertEquals(expectedOutput, mansion.toString(), "Mansion should include all added locations.");
    }

    @Test
    void testSetCurrentLocationById() {
        // Add locations to the mansion
        mansion.addLocation(location1);
        mansion.addLocation(location2);

        // Set the current location
        mansion.setCurrentLocation("loc2");

        assertEquals(location2, mansion.getCurrentLocation(), "Current location should be set to location2.");
    }

    @Test
    void testSetCurrentLocationInvalidId() {
        // Add locations
        mansion.addLocation(location1);
        mansion.addLocation(location2);

        // Try setting an invalid location ID
        mansion.setCurrentLocation("invalidId");

        assertNull(mansion.getCurrentLocation(), "Current location should remain null if ID does not match.");
    }

    @Test
    void testSetLocations() {
        // Create a list of locations
        ArrayList<Location> newLocations = new ArrayList<>();
        newLocations.add(location1);
        newLocations.add(location2);

        // Set the locations
        mansion.setLocations(newLocations);

        // Verify the toString output
        String expectedOutput = "Mansion:\n" +
                                location1.toString() + "\n" +
                                location2.toString() + "\n";
        assertEquals(expectedOutput, mansion.toString(), "Mansion should reflect the updated list of locations.");
    }

    @Test
    void testToString() {
        // Add locations
        mansion.addLocation(location1);
        mansion.addLocation(location2);

        // Expected string output
        String expectedOutput = "Mansion:\n" +
                                location1.toString() + "\n" +
                                location2.toString() + "\n";
        assertEquals(expectedOutput, mansion.toString(), "toString() should return the correct representation of the mansion.");
    }
}
