package org.uob.a3.gameobjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class GameObjectTest {

    @Test
    public void testGameObjectInitialization() {
        GameObject obj = new GameObject("clue1", "Mysterious Key", "A key with strange engravings.") {
        };

        assertEquals("clue1", obj.getId());
        assertEquals("Mysterious Key", obj.getName());
        assertEquals("A key with strange engravings.", obj.getDescription());
    }

    @Test
    public void testSettersAndGetters() {
        GameObject obj = new GameObject("clue1", "Key", "A simple key.") {
        };

        obj.setName("Golden Key");
        obj.setDescription("A shiny golden key.");

        assertEquals("Golden Key", obj.getName());
        assertEquals("A shiny golden key.", obj.getDescription());
    }
}
