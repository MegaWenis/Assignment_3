package org.uob.a3.commands;
import org.uob.a3.gameobjects.*;


public class Combine extends Command {
    public Combine(String items) {
        this.commandType = CommandType.COMBINE;
        this.value = items;
    }

    public String execute(GameState gameState) {
        System.out.println("Raw input value: " + value);

        String[] items = value.split(",");
        if (items.length == 2) {
            Notebook notebook = gameState.getPlayer().getNotebook();
            String item1 = items[0].trim();
            String item2 = items[1].trim();

            System.out.println("Parsed item1: " + item1);
            System.out.println("Parsed item2: " + item2);

            Clue clue1 = notebook.getClueByName(item1);
            Clue clue2 = notebook.getClueByName(item2);

            if (clue1 == null || clue2 == null) {
                return "One or both clues were not found in your notebook.";
            }

            if (notebook.hasClue(item1) && notebook.hasClue(item2)) {
                if (clue1.getHint().equalsIgnoreCase(clue2.getHint())) {
                    Clue newClue = gameState.getMansion().getLocationByName("store").getClue(clue1.getHint());
                    notebook.addClue(newClue);
                    return "You combined the " + item1 + " with " + item2 + " into " + newClue.getName();
                } else {
                    return "These items do not combine.";
                }
            } else {
                return "You don't have these clues.";
            }
        } else {
            return "Invalid input. Please provide two items separated by a comma.";
        }
    }

}