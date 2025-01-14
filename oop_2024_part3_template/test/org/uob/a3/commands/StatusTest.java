package org.uob.a3.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uob.a3.gameobjects.*;

import java.util.List;

class StatusTest {

    private GameState gameState;
    private Player player;

    @BeforeEach
    void setUp() {
        // Initialize GameState and Player
        gameState = new GameState();
        player = new Player("Detective");
        gameState.setPlayer(player);

        // Add clues to the player's notebook for testing
        player.getNotebook().addClue(new Clue("clue1", "Mysterious Letter", "A letter with strange markings.",
                List.of("letter", "mysterious"), 5, "Look closely at the markings."));
        player.getNotebook().addClue(new Clue("clue2", "Hidden Key", "A small key hidden under a tile.",
                List.of("key", "hidden"), 7, "It might open something important."));
    }

    @Test
    void testStatusNotebook() {
        // Status command for "notebook"
        Status status = new Status("notebook");
        String result = status.execute(gameState);

        // Verify the output includes all clues in the notebook
        assertTrue(result.contains("You have the following clues:"), "Output should include notebook heading.");
        assertTrue(result.contains("Mysterious Letter"), "Output should include 'Mysterious Letter'.");
        assertTrue(result.contains("Hidden Key"), "Output should include 'Hidden Key'.");
    }

    @Test
    void testStatusInvalidTopic() {
        // Status command with an invalid topic
        Status status = new Status("invalid");
        String result = status.execute(gameState);

        // Verify the output handles invalid topics gracefully
        assertEquals("Invalid status topic: invalid.", result,
                "Output should indicate the topic is invalid.");
    }

    @Test
    void testStatusEmptyTopic() {
        // Status command with an empty topic
        Status status = new Status("");
        String result = status.execute(gameState);

        // Verify the output prompts for a valid topic
        assertEquals("Status what? Please specify a valid topic.", result,
                "Empty input should prompt the player for a valid topic.");
    }

    @Test
    void testStatusPlayer() {
        // Status command for "player"
        Status status = new Status("player");
        String result = status.execute(gameState);

        // Verify the output includes the player's name and general details
        assertTrue(result.contains("Detective"), "Output should include the player's name.");
        assertTrue(result.contains("Notebook"), "Output should include details about the notebook.");
    }
}
