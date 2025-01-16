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
        this.commandType = commandType.STATUS;
    }


    public String execute(GameState gameState) {
        String topic = value;

        //status can target: notebook, player, map

        switch (topic.toLowerCase()){
            case "notebook":
                return gameState.getPlayer().getNotebook().toString();

            case "player":
                return "Player status:\n" + gameState.getPlayer().toString();

            case "map" :
                return gameState.getMansion().toString();

            default: return "Please type 'status' followed by a keyword: 'notebook', 'player', 'map'";
        }
    }

}

