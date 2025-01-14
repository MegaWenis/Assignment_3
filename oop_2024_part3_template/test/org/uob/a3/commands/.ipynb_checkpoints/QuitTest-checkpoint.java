package org.uob.a3.commands;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uob.a3.gameobjects.*;

class QuitTest {

    private GameState gameState;
    private Player player;

    @BeforeEach
    void setUp() {
        // Initialize GameState and Player
        gameState = new GameState();
        player = new Player("Detective");
        gameState.setPlayer(player);

        // Add some details to the player for testing
        player.getNotebook().addClue(new Clue("clue1", "Mysterious Letter", "A letter with strange markings.",
                List.of("letter", "mysterious"), 5, "Look closely at the markings."));
    }

    @Test
    void testQuitCommand() {
        // Create a Quit command
        Quit quit = new Quit();

        // Execute the command
        String result = quit.execute(gameState);

        // Verify the output includes the game-over message and player's details
        assertTrue(result.contains("Game over: Your current status is:"), "Output should contain the game-over message.");
        assertTrue(result.contains("Detective"), "Output should include the player's name.");
        assertTrue(result.contains("Mysterious Letter"), "Output should include details from the player's notebook.");
    }
}
