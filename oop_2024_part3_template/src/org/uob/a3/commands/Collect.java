package org.uob.a3.commands;

import org.uob.a3.gameobjects.*;

/**
 * Represents the "collect" command, allowing the player to collect a clue from the current room and add it to their notebook.
 *
 * <p>
 * This command checks if the specified clue is present in the current location. If the clue exists and the player
 * does not already have it, the clue is added to the player's notebook. Otherwise, an appropriate message is returned.
 * </p>
 */
public class Collect extends Command {

    public Collect(String clue) {
        this.commandType = CommandType.COLLECT;
        this.value = clue;
    }

    public String execute(GameState gamestate) {
        Location currentLocation = gamestate.getMansion().getCurrentLocation();
        String clueName = this.value.trim().toLowerCase();
        Player player = gamestate.getPlayer();

        if (clueName.isEmpty()) {
            return "You must specify a clue to collect.";
        }

        clueName = resolveClueKeyword(clueName);

        if (currentLocation.hasClue(clueName)) {
            Clue clue =currentLocation.getClueByName(clueName);

            if (clue == null) {
                return "Clue '" + clueName + "' could not be found in the current location.";
            }

            if (player.getNotebook().hasClue(clueName)) {
                return "You already have the clue '" +clue.getName() + "' in your notebook.";
            }

            player.getNotebook().addClue(clue);

            return "You collected the clue '"+ clue.getName() + "' and added it to your notebook.";
        }

        return "There is no clue matching '" + clueName + "' in this location.";
    }

    //bloody formatting
    private String resolveClueKeyword(String clueName) {
        switch (clueName) {
            case "letter":
                return "Mysterious Letter";
            default:
                return clueName;
        }
    }
}