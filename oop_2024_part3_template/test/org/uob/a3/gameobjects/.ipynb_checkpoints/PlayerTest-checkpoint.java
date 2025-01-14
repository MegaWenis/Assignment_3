package org.uob.a3.gameobjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class PlayerTest {

    private Player player;
    private Clue clue1;
    private Clue clue2;

    @BeforeEach
    void setUp() {
        // Initialize the Player object
        player = new Player("Detective");

        // Initialize Clue objects
        clue1 = new Clue("clue1", "Mysterious Letter", "A letter with strange markings.",
                         List.of("letter", "mysterious"), 5, "Look closely at the markings.");
        clue2 = new Clue("clue2", "Hidden Key", "A small key hidden under a tile.",
                         List.of("key", "hidden"), 7, "It might open something important.");
    }

    @Test
    void testPlayerInitialization() {
        assertEquals("Detective", player.getName(), "Player name should be initialized correctly.");
        assertNotNull(player.getNotebook(), "Player's notebook should not be null.");
        assertTrue(player.getNotebook().getClues().isEmpty(), "Player's notebook should initially be empty.");
    }

    @Test
    void testAddCluesToNotebook() {
        // Add clues to the player's notebook
        player.getNotebook().addClue(clue1);
        player.getNotebook().addClue(clue2);

        // Verify clues are added
        assertEquals(2, player.getNotebook().getClues().size(), "Notebook should contain 2 clues.");
        assertTrue(player.getNotebook().getClues().contains(clue1), "Notebook should contain Clue1.");
        assertTrue(player.getNotebook().getClues().contains(clue2), "Notebook should contain Clue2.");
    }

    @Test
    void testDuplicateCluesNotAdded() {
        // Add the same clue twice
        player.getNotebook().addClue(clue1);
        player.getNotebook().addClue(clue1);

        // Verify no duplicates are added
        assertEquals(1, player.getNotebook().getClues().size(), "Duplicate clues should not be added.");
    }

    @Test
    void testDefaultConstructor() {
        Player unnamedPlayer = new Player();

        assertNull(unnamedPlayer.getName(), "Player name should be null with default constructor.");
        assertNotNull(unnamedPlayer.getNotebook(), "Player's notebook should still be initialized.");
        assertTrue(unnamedPlayer.getNotebook().getClues().isEmpty(), "Notebook should be empty for default constructor.");
    }

    @Test
    void testToString() {
        // Add a clue to the notebook
        player.getNotebook().addClue(clue1);

        // Expected string output
        String expectedString = "Player Name: Detective\nNotebook:\n[" + clue1.toString() + "]";
        assertEquals(expectedString, player.toString(), "toString() should return the correct representation of the player.");
    }
}
