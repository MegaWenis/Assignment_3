package org.uob.a3.gameobjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ClueTest {

    private Clue clue;

    @BeforeEach
    void setUp() {
        // Initialize a Clue object before each test
        clue = new Clue("clue1", "Mysterious Letter", "A letter with strange markings.",
                        List.of("letter", "mysterious"), 5, "Look closely at the markings.");
    }

    @Test
    void testClueConstructor() {
        assertNotNull(clue, "Clue object should be created successfully.");
        assertEquals("clue1", clue.getId(), "Clue ID should match the provided value.");
        assertEquals("Mysterious Letter", clue.getName(), "Clue name should match the provided value.");
        assertEquals("A letter with strange markings.", clue.getDescription(),
                "Clue description should match the provided value.");
    }

    @Test
    void testGetName() {
        assertEquals("Mysterious Letter", clue.getName(),
                "getName() should return the correct clue name.");
    }

    @Test
    void testGetDescription() {
        assertEquals("A letter with strange markings.", clue.getDescription(),
                "getDescription() should return the correct clue description.");
    }

    @Test
    void testKeywords() {
        List<String> expectedKeywords = List.of("letter", "mysterious");
        assertEquals(expectedKeywords, clue.keywords,
                "Keywords should match the provided list.");
    }

    @Test
    void testRelevance() {
        assertEquals(5, clue.relevance, "Relevance should match the provided value.");
    }

    @Test
    void testHint() {
        assertEquals("Look closely at the markings.", clue.hint,
                "Hint should match the provided value.");
    }

    @Test
    void testToString() {
        String expectedString = "Clue {id='clue1', name='Mysterious Letter', " +
                                "description='A letter with strange markings.', " +
                                "keywords=[letter, mysterious], relevance=5}";
        assertEquals(expectedString, clue.toString(), "toString() should return the correct representation.");
    }
}
