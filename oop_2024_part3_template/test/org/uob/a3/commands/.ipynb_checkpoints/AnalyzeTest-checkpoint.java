package org.uob.a3.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uob.a3.gameobjects.*;

import java.util.List;

class AnalyzeTest {

    private GameState gameState;
    private Player player;

    @BeforeEach
    void setUp() {
        // Initialize GameState and Player
        gameState = new GameState();
        player = new Player("Detective");

        // Add clues to the player's notebook
        player.getNotebook().addClue(new Clue("clue1", "Letter", "A letter with strange markings.",
                List.of("letter", "mysterious"), 5, "Look closely at the markings."));
        player.getNotebook().addClue(new Clue("clue2", "Key", "A small key hidden under a tile.",
                List.of("key", "hidden"), 7, "It might open something important."));
        gameState.setPlayer(player);
    }

    @Test
    void testAnalyzeValidClue() {
        // Analyze a valid clue
        Analyze analyze = new Analyze("Letter");
        String result = analyze.execute(gameState);

        // Verify output
        assertTrue(result.contains("Analyzing 'Letter':"), "Output should contain the clue name.");
        assertTrue(result.contains("A letter with strange markings."), "Output should contain the clue description.");
        assertTrue(result.contains("Keywords: letter, mysterious"), "Output should contain the clue keywords.");
        assertTrue(result.contains("Relevance: 5"), "Output should contain the clue relevance.");
        assertTrue(result.contains("Hint: Look closely at the markings."), "Output should contain the clue hint.");
    }

    @Test
    void testAnalyzeInvalidClue() {
        // Analyze an invalid clue
        Analyze analyze = new Analyze("Nonexistent");
        String result = analyze.execute(gameState);

        // Verify output
        assertEquals("You don't have any clue or item named 'Nonexistent' to analyze.", result,
                "Output should indicate the clue was not found.");
    }

    @Test
    void testAnalyzeEmptyInput() {
        // Analyze with empty input
        Analyze analyze = new Analyze("");
        String result = analyze.execute(gameState);

        // Verify output
        assertEquals("Analyze what? Please specify an item or clue to analyze.", result,
                "Output should prompt for a valid input.");
    }

    @Test
    void testAnalyzeCaseInsensitiveMatch() {
        // Analyze a clue with case-insensitive input
        Analyze analyze = new Analyze("letter");
        String result = analyze.execute(gameState);

        // Verify output
        assertTrue(result.contains("Analyzing 'Letter':"), "Output should match regardless of case.");
    }

}
