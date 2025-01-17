package org.uob.a3.commands;

import org.uob.a3.gameobjects.*;

import java.util.stream.Collectors;

/**
 * Represents the "status" command, allowing the player to retrieve information
 * about their inventory, specific items, or their overall status.
 *
 * <p>
 * The status command can display a list of items in the player's inventory,
 * provide details about a specific item, or show the player's general status.
 * </p>
 */

public class Status extends Command {

    public Status(String topic) {
        this.value = topic;
        this.commandType = CommandType.STATUS;}

    public String execute(GameState gameState){
        String topic = value;

        if (topic == null || topic.isEmpty()){
            return "Status what? Please specify a valid topic.";
        }

        switch (topic.toLowerCase()) {
            case "notebook":
                return "Notebook status:\n" +gameState.getPlayer().getNotebook().toString();

            case "player":
                return "Player status:\n" + gameState.getPlayer().toString();

            case "map": return "Map status:\n" + gameState.getMansion().toString();

            default:
                return "Invalid status topic: " + topic + ".";
        }
    }
}


