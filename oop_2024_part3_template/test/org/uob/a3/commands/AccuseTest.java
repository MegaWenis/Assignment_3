package org.uob.a3.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uob.a3.gameobjects.*;

import java.util.List;

class AccuseTest {

    private GameState gameState;
    private CaseResolution caseResolution;

    @BeforeEach
    void setUp() {
        // Initialize GameState and CaseResolution
        caseResolution = new CaseResolution(List.of("Mysterious Letter", "Hidden Key"), "Dr. Moriarty");
        gameState = new GameState();
        gameState.setCaseResolution(caseResolution);

        // Add clues to the player's notebook
        Player player = new Player("Detective");
        player.getNotebook().addClue(new Clue("clue1", "Mysterious Letter", "A letter with strange markings.",
                List.of("letter", "mysterious"), 5, "Look closely at the markings."));
        player.getNotebook().addClue(new Clue("clue2", "Hidden Key", "A small key hidden under a tile.",
                List.of("key", "hidden"), 7, "It might open something important."));
        gameState.setPlayer(player);
    }

    @Test
    void testAccuseCorrectSuspect() {
        // Create Accuse command with the correct suspect
        Accuse accuse = new Accuse("Dr. Moriarty");

        // Execute the command and verify the outcome
        String result = accuse.execute(gameState);

        assertEquals("Congratulations! You correctly accused Dr. Moriarty and solved the case!", result,
                "Accusing the correct suspect should return a success message.");
        assertTrue(caseResolution.isResolved(), "The case should be marked as resolved.");
    }

    @Test
    void testAccuseIncorrectSuspect() {
        // Create Accuse command with an incorrect suspect
        Accuse accuse = new Accuse("Ms. Peacock");

        // Execute the command and verify the outcome
        String result = accuse.execute(gameState);
        assertEquals("Your accusation of Ms. Peacock was incorrect. The case remains unsolved.", result,
                "Accusing the wrong suspect should return a failure message.");
        assertFalse(caseResolution.isResolved(), "The case should not be marked as resolved.");
    }

    @Test
    void testAccusePartialMatch() {
        // Create Accuse command with a partial match
        Accuse accuse = new Accuse("Moriarty");

        // Execute the command and verify the outcome
        String result = accuse.execute(gameState);
        assertEquals("Congratulations! You correctly accused Moriarty and solved the case!", result,
                "Partial matches should succeed if the suspect name is contained.");
        assertTrue(caseResolution.isResolved(), "The case should be marked as resolved.");
    }

}
