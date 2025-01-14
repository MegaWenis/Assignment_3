package org.uob.a3.gameobjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CaseResolutionTest {

    private CaseResolution caseResolution;
    private Player player;

    private Clue clue1;
    private Clue clue2;

    @BeforeEach
    void setUp() {
        // Create Clue objects
        clue1 = new Clue("c1", "Clue1", "A mysterious note", List.of("note", "mysterious"), 5, "Think carefully about what it says.");
        clue2 = new Clue("c2", "Clue2", "A dusty key", List.of("key", "dusty"), 8, "It unlocks something important.");

        // Create CaseResolution object with required clues and a solution
        List<String> requiredClues = List.of(clue1.getName(), clue2.getName());
        caseResolution = new CaseResolution(requiredClues, "The ghost");

        // Set up a Player with an empty notebook
        player = new Player("Detective");
    }

    @Test
    void testAttemptResolutionSuccess() {
        // Add required clues to the player's notebook
        player.getNotebook().addClue(clue1);
        player.getNotebook().addClue(clue2);

        // Attempt resolution with correct solution
        boolean result = caseResolution.attemptResolution(player, "the ghost");

        // Assertions
        assertTrue(result, "The case should resolve successfully when clues and solution match.");
    }

    @Test
    void testAttemptResolutionFailsDueToMissingClues() {
        // Add only one clue to the player's notebook
        player.getNotebook().addClue(clue1);

        // Attempt resolution with correct solution
        boolean result = caseResolution.attemptResolution(player, "the ghost");

        // Assertions
        assertFalse(result, "The case should not resolve if all required clues are not collected.");
    }

    @Test
    void testAttemptResolutionFailsDueToWrongSolution() {
        // Add required clues to the player's notebook
        player.getNotebook().addClue(clue1);
        player.getNotebook().addClue(clue2);

        // Attempt resolution with an incorrect solution
        boolean result = caseResolution.attemptResolution(player, "The treasure is in the basement");

        // Assertions
        assertFalse(result, "The case should not resolve if the solution is incorrect.");
    }

    @Test
    void testGetSolution() {
        assertEquals("The ghost", caseResolution.getSolution(),
                "The getSolution method should return the correct solution.");
    }

    @Test
    void testGetRequiredClues() {
        List<String> expectedClues = List.of("Clue1", "Clue2");
        assertEquals(expectedClues, caseResolution.getRequiredClues(),
                "The getRequiredClues method should return the correct list of clue names.");
    }

    @Test
    void testClueToString() {
        String expectedClue1String = "Clue {id='c1', name='Clue1', description='A mysterious note', keywords=[note, mysterious], relevance=5}";
        assertEquals(expectedClue1String, clue1.toString(),
                "The toString method should return the correct string representation of the clue.");
    }
}
