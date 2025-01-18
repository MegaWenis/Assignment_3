package org.uob.a3.commands;
import org.uob.a3.gameobjects.*;


public class Combine extends Command {
    public Combine(String items) {
        this.commandType = CommandType.COMBINE;
        this.value = items;
    }

    public String execute(GameState gameState) {

        String itemsComma = value;
        String[] items = itemsComma.substring(8).split(",");



        if (items.length == 2) {
            Notebook notebook = gameState.getPlayer().getNotebook();
            String item1 = items[0].trim();
            Clue clue1 = notebook.getClueByName(item1);
            String item2 = items[1].trim();
            Clue clue2 = notebook.getClueByName(item2);
            System.out.println(item1+" "+item2);
            System.out.println(clue2.getHint()+" "+clue1.getHint());
            System.out.println(clue2.getName()+" "+clue1.getName());

            if (notebook.hasClue(item1)&&notebook.hasClue(item2)) {
                if (clue1.getHint().equalsIgnoreCase(clue2.getHint())) {
                    Clue newClue = gameState.getMansion().getLocationByName("store").getClue(clue1.getHint());
                    notebook.addClue(newClue);
                    return "You combined the " + item1 + " with " + item2 + " into " + newClue.getName();
                } else {
                    return "these items do not combine.";
                }
            } return "you dont have these clues.";

        } else {
            return "Invalid input. Please provide two items separated by a comma.";
        }


    }

}