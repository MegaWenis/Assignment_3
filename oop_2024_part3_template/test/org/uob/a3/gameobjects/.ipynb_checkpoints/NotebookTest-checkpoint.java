package org.uob.a3.gameobjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class NotebookTest {

    private Notebook notebook;
    private Clue clue1;
    private Clue clue2;
    private Clue clue3;

    @BeforeEach
    void setUp() {
        // Initialize the Notebook
        notebook = new Notebook();

        // Initialize Clue objects
        clue1 = new Clue("clue1", "Letter", "A letter with strange markings.",
                         List.of("letter", "mysterious"), 5, "Look closely at the markings.");
        clue2 = new Clue("clue2", "Knife", "A knife covered in dried blood.",
                         List.of("knife", "blood"), 10, "Check the handle for fingerprints.");
        clue3 = new Clue("clue3", "Key", "A small key hidden under a tile.",
                         List.of("key", "hidden"), 7, "It might open something important.");
        
        // Initialize the clues list inside Notebook
        notebook.addClue(clue1);
        notebook.addClue(clue2);
    }

    @Test
    void testAddClue() {
        // Add a new clue
        notebook.addClue(clue3);

        // Verify the clue was added
        assertEquals(3, notebook.getClues().size(), "Notebook should contain 3 clues.");
        assertTrue(notebook.getClues().contains(clue3), "Clue3 should be in the notebook.");
    }

    @Test
    void testAddDuplicateClue() {
        // Try adding a duplicate clue
        notebook.addClue(clue1);

        // Ensure no duplicate clues are added
        assertEquals(2, notebook.getClues().size(), "Duplicate clues should not be added.");
    }

    @Test
    void testContainsAllCluesSuccess() {
        // Create a list of required clue names
        List<String> requiredClues = List.of("Letter", "Knife");

        // Verify that the notebook contains all required clues
        assertTrue(notebook.containsAll(requiredClues), "Notebook should contain all required clues.");
    }

    @Test
    void testContainsAllCluesFailure() {
        // Create a list of required clue names with one missing
        List<String> requiredClues = List.of("Letter", "Key");

        // Verify that the notebook does not contain all required clues
        assertFalse(notebook.containsAll(requiredClues), "Notebook should not contain all required clues.");
    }

    @Test
    void testGetClues() {
        List<Clue> clues = notebook.getClues();
        assertEquals(2, clues.size(), "Notebook should initially contain 2 clues.");
        assertTrue(clues.contains(clue1), "Notebook should contain Clue1.");
        assertTrue(clues.contains(clue2), "Notebook should contain Clue2.");
    }

    @Test
    void testToString() {
        // Assuming the superclass GameObject's toString is implemented
        String expectedString = "GameObject {id='notebook', name='Notebook', description='Notebook for your clues.'}";
        assertEquals(expectedString, notebook.toString(), "toString() should return the correct description.");
    }
}
