package org.uob.a3.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uob.a3.gameobjects.GameState;

class HelpTest {

    private GameState gameState;

    @BeforeEach
    void setUp() {
        // Initialize GameState (not used in Help, but required for the method signature)
        gameState = new GameState();
    }

    @Test
    void testGeneralHelp() {
        // Create a Help command with no specific topic
        Help help = new Help(null);

        // Execute the command and verify output
        String result = help.execute(gameState);

        // Verify the output includes descriptions for key commands
        assertTrue(result.contains("MOVE"), "General help should include 'MOVE'.");
        assertTrue(result.contains("LOOK"), "General help should include 'LOOK'.");
        assertTrue(result.contains("COLLECT"), "General help should include 'COLLECT'.");
        assertTrue(result.contains("ANALYZE"), "General help should include 'ANALYZE'.");
        assertTrue(result.contains("INSPECT"), "General help should include 'INSPECT'.");
        assertTrue(result.contains("ACCUSE"), "General help should include 'ACCUSE'.");
        assertTrue(result.contains("STATUS"), "General help should include 'STATUS'.");
        assertTrue(result.contains("HELP"), "General help should include 'HELP'.");
        assertTrue(result.contains("QUIT"), "General help should include 'QUIT'.");
    }

    @Test
    void testSpecificHelpMove() {
        // Create a Help command for the "move" topic
        Help help = new Help("move");

        // Execute the command and verify output
        String result = help.execute(gameState);
        assertTrue(result.contains("MOVE Command:"), "Specific help for 'move' should start with 'MOVE Command:'.");
        assertTrue(result.contains("move north"), "Specific help for 'move' should include an example.");
    }

    @Test
    void testSpecificHelpCollect() {
        // Create a Help command for the "collect" topic
        Help help = new Help("collect");

        // Execute the command and verify output
        String result = help.execute(gameState);
        assertTrue(result.contains("COLLECT Command:"), "Specific help for 'collect' should start with 'COLLECT Command:'.");
        assertTrue(result.contains("collect clue_name"), "Specific help for 'collect' should include an example.");
    }

    @Test
    void testSpecificHelpAccuse() {
        // Create a Help command for the "accuse" topic
        Help help = new Help("accuse");

        // Execute the command and verify output
        String result = help.execute(gameState);
        assertTrue(result.contains("ACCUSE Command:"), "Specific help for 'accuse' should start with 'ACCUSE Command:'.");
        assertTrue(result.contains("accuse suspect_name"), "Specific help for 'accuse' should include an example.");
    }

    @Test
    void testSpecificHelpInvalidTopic() {
        // Create a Help command for an invalid topic
        Help help = new Help("unknown");

        // Execute the command and verify output
        String result = help.execute(gameState);
        assertTrue(result.contains("No help available for the topic: unknown"), 
                "Help for an invalid topic should indicate no help is available.");
    }

    @Test
    void testCaseInsensitiveSpecificHelp() {
        // Create a Help command with a mixed-case topic
        Help help = new Help("MoVe");

        // Execute the command and verify output
        String result = help.execute(gameState);
        assertTrue(result.contains("MOVE Command:"), "Specific help should be case-insensitive.");
    }
}
