package org.uob.a3.gameobjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GameStateTest {

    private GameState gameState;
    private Mansion mansion;
    private Player player;
    private List<Clue> collectedClues;
    private CaseResolution caseResolution;

    private Clue clue1;
    private Clue clue2;

    @BeforeEach
    void setUp() {
        // Initialize Mansion and Player objects
        mansion = new Mansion();
        player = new Player("Detective");

        // Initialize Clue objects
        clue1 = new Clue("clue1", "Mysterious Letter", "A letter with strange markings.",
                         List.of("letter", "mysterious"), 5, "Look closely at the markings.");
        clue2 = new Clue("clue2", "Bloodstained Knife", "A knife covered in dried blood.",
                         List.of("knife", "blood"), 10, "Check the handle for fingerprints.");

        // Initialize a list of collected clues and CaseResolution
        collectedClues = new ArrayList<>();
        caseResolution = new CaseResolution(List.of("clue1", "clue2"), "Solved");

        // Initialize GameState with provided objects
        gameState = new GameState(mansion, player, collectedClues, caseResolution);
    }

    @Test
    void testDefaultConstructor() {
        GameState defaultState = new GameState();
        assertNotNull(defaultState.getMansion(), "Default mansion should not be null.");
        assertNotNull(defaultState.getPlayer(), "Default player should not be null.");
    }

    @Test
    void testGetAndSetMansion() {
        assertEquals(mansion, gameState.getMansion(), "Mansion should match the initialized value.");
        
        Mansion newMansion = new Mansion();
        gameState.setMansion(newMansion);
        assertEquals(newMansion, gameState.getMansion(), "Mansion should be updated.");
    }

    @Test
    void testGetAndSetPlayer() {
        assertEquals(player, gameState.getPlayer(), "Player should match the initialized value.");
        
        Player newPlayer = new Player("New Detective");
        gameState.setPlayer(newPlayer);
        assertEquals(newPlayer, gameState.getPlayer(), "Player should be updated.");
    }

    @Test
    void testGetAndSetCaseResolution() {
        assertEquals(caseResolution, gameState.getCaseResolution(), "Case resolution should match the initialized value.");

        CaseResolution newCaseResolution = new CaseResolution(List.of("clue3"), "Unsolved");
        gameState.setCaseResolution(newCaseResolution);
        assertEquals(newCaseResolution, gameState.getCaseResolution(), "Case resolution should be updated.");
    }

    @Test
    void testToString() {
        String expectedString = "GameState {mansion=" + mansion.toString() +
                                ", player=" + player.toString() +
                                ", collectedClues=" + collectedClues.toString() +
                                ", caseResolution=" + caseResolution.toString() + "}";
        assertEquals(expectedString, gameState.toString(), "toString() should return the correct representation.");
    }
}
