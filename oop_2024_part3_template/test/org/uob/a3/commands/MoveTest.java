package org.uob.a3.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uob.a3.gameobjects.*;

class MoveTest {

    private GameState gameState;
    private Location library;
    private Location hallway;

    @BeforeEach
    void setUp() {
        // Initialize GameState
        gameState = new GameState();

        // Initialize Locations
        library = new Location("loc1", "Library", "A dusty library filled with books.", false, null);
        hallway = new Location("loc2", "Hallway", "A dimly lit hallway.", false, null);

        // Add locations to the Mansion
        gameState.getMansion().addLocation(library);
        gameState.getMansion().addLocation(hallway);

        // Set initial current location
        gameState.getMansion().setCurrentLocation(library.getId());
    }

    @Test
    void testMoveToValidLocation() {
        // Move to a valid location
        Move move = new Move("Hallway");
        String result = move.execute(gameState);

        // Verify the output
        assertEquals("You move to the Hallway.\nA dimly lit hallway.", result,
                "Moving to a valid location should return its name and description.");

        // Verify the current location is updated
        assertEquals(hallway, gameState.getMansion().getCurrentLocation(),
                "The player's current location should be updated to the Hallway.");
    }

    @Test
    void testMoveToInvalidLocation() {
        // Attempt to move to a nonexistent location
        Move move = new Move("Kitchen");
        String result = move.execute(gameState);

        // Verify the output
        assertEquals("There is no location named 'Kitchen'.", result,
                "Trying to move to an invalid location should return an error message.");

        // Verify the current location remains unchanged
        assertEquals(library, gameState.getMansion().getCurrentLocation(),
                "The player's current location should not change.");
    }

    @Test
    void testMoveWithEmptyInput() {
        // Attempt to move with no input
        Move move = new Move("");
        String result = move.execute(gameState);

        // Verify the output
        assertEquals("Move where? Please specify a location.", result,
                "Empty input should prompt the player to specify a location.");

        // Verify the current location remains unchanged
        assertEquals(library, gameState.getMansion().getCurrentLocation(),
                "The player's current location should not change.");
    }

    @Test
    void testMoveCaseInsensitiveLocation() {
        // Move to a valid location with different casing
        Move move = new Move("hallway");
        String result = move.execute(gameState);

        // Verify the output
        assertEquals("You move to the Hallway.\nA dimly lit hallway.", result,
                "Location names should be case-insensitive.");

        // Verify the current location is updated
        assertEquals(hallway, gameState.getMansion().getCurrentLocation(),
                "The player's current location should be updated to the Hallway.");
    }
}
