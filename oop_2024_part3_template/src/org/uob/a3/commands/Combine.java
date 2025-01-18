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
            String item1 = items[0].trim();
            String item2 = items[1].trim();


            return "You combined the " +item1+" with " +item2+ "into";


        } else {
            return "Invalid input. Please provide two items separated by a comma.";
        }


    }

}