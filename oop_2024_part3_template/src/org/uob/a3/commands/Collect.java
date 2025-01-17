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

    public Collect(String clue){
        this.commandType = CommandType.COLLECT;
        this.value = clue;
    }

    public String execute(GameState gamestate) {
        Location currentLocation = gamestate.getMansion().getCurrentLocation();
        String clueName = this.value;
        Player player = gamestate.getPlayer();


        //Collecting a valid clue using a keyword should return a success message.
        // ==> expected: <You collected the clue 'Mysterious Letter' and added it to your notebook.>
        // but was: <You added letter to your notebook.>

        if (currentLocation.hasClue(clueName) || !player.getNotebook().hasClue(clueName)) {
            Clue clue = currentLocation.getClueByName(clueName);
            player.getNotebook().addClue(clue);
            return "You collected the clue '" + clue.getName() + "' and added it to your notebook.";
        }

        return "That clue is not present";
    }

}