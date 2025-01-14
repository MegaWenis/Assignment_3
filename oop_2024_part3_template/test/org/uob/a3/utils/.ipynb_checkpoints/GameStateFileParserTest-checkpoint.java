import org.junit.jupiter.api.Test;
import org.uob.a3.utils.GameStateFileParser;
import org.uob.a3.gameobjects.*;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameStateFileParserTest {

    @Test
    public void testParseGameState() throws Exception {
        // Mock game state data
        String mockData = """
            location,loc1,Room1,A dimly lit room,false,none
            player,Detective
            clue,clue1,Key,A rusty key with strange engravings.,[journal;library;meeting],5,The meeting happened at 11 PM. Time is key.
            caseResolution,[clue1;clue2],Librarian
            """;

        // Write mock data to a temporary file
        File tempFile = File.createTempFile("mockGameState", ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write(mockData);
        }

        // Use the public parse method
        GameState state = GameStateFileParser.parse(tempFile.getAbsolutePath());

        // Verify the parsed game state
        assertNotNull(state);

        // Verify the mansion (location)
        Mansion mansion = state.getMansion();
        assertNotNull(mansion);
        assertEquals("Room1", mansion.getCurrentLocation().getName());
        assertEquals("loc1", mansion.getCurrentLocation().getId());
        assertEquals("A dimly lit room", mansion.getCurrentLocation().getDescription());

        // Verify the player
        Player player = state.getPlayer();
        assertNotNull(player);
        assertEquals("Detective", player.getName());
        assertNotNull(player.getNotebook());

        // Verify clues
        List<Clue> clues = state.getMansion().getCurrentLocation().getClues();
        assertNotNull(clues);
        assertEquals(1, clues.size());
        Clue clue = clues.get(0);
        assertEquals("clue1", clue.getId());
        assertEquals("Key", clue.getName());
        assertEquals("A rusty key with strange engravings.", clue.getDescription());

        // Verify case resolution
        List<String> requiredClues = new ArrayList<String>();
        requiredClues.add("clue1");
        requiredClues.add("clue2");
        CaseResolution caseResolution = state.getCaseResolution();
        assertNotNull(caseResolution);
        assertEquals("Librarian", caseResolution.getSolution());
        assertEquals(requiredClues, caseResolution.getRequiredClues());
        assertEquals(false, caseResolution.attemptResolution(player, "Solved")); //At this point player cannot solve the case yet.

        // Clean up the temporary file
        tempFile.deleteOnExit();
    }
}
