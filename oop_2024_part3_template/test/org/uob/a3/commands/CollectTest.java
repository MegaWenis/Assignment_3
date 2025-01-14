package org.uob.a3.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uob.a3.gameobjects.*;

import java.util.List;

class CollectTest {

    private GameState gameState;
    private Player player;
    private Location library;
    private Clue clue;

    @BeforeEach
    void setUp() {
        // Initialize GameState and Player
        gameState = new GameState();
        player = new Player("Detective");
        gameState.setPlayer(player);

        // Initialize Location and Clue
        library = new Location("loc1", "Library", "A dusty library filled with books.", false, null);
        clue = new Clue("clue1", "Mysterious Letter", "A letter with strange markings.",
                List.of("letter", "mysterious"), 5, "Look closely at the markings.");

        // Add the clue to the location and set the current location
        library.addClue(clue);
        gameState.getMansion().addLocation(library);
        gameState.getMansion().setCurrentLocation("loc1");
    }

    @Test
    void testCollectValidKeyword() {
        // Collect a clue using a valid keyword
        Collect collect = new Collect("letter");
        String result = collect.execute(gameState);

        // Verify the clue was collected
        assertEquals("You collected the clue 'Mysterious Letter' and added it to your notebook.", result,
                "Collecting a valid clue using a keyword should return a success message.");
        assertTrue(player.getNotebook().getClues().contains(clue), "The clue should be added to the player's notebook.");
    }

    @Test
    void testCollectInvalidKeyword() {
        // Attempt to collect a clue using an invalid keyword
        Collect collect = new Collect("invalid");
        String result = collect.execute(gameState);

        // Verify the output
        assertEquals("There is no clue matching 'invalid' in this location.", result,
                "Using an invalid keyword should return an error message.");
    }

    @Test
    void testCollectAlreadyOwnedClue() {
        // Add the clue to the player's notebook first
        player.getNotebook().addClue(clue);

        // Attempt to collect the same clue again
        Collect collect = new Collect("letter");
        String result = collect.execute(gameState);

        // Verify the output
        assertEquals("You already have the clue 'Mysterious Letter' in your notebook.", result,
                "Trying to collect an already owned clue should return an appropriate message.");
    }

    @Test
    void testCollectWithEmptyInput() {
        // Attempt to collect with no input
        Collect collect = new Collect("");
        String result = collect.execute(gameState);

        // Verify the output
        assertEquals("Collect what? Please specify a keyword or name.", result,
                "Empty input should prompt the player to specify a keyword or name.");
    }
}
