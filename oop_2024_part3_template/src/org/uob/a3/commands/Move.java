package org.uob.a3.commands;

import org.uob.a3.gameobjects.*;

/**
 * Represents the "move" command, allowing the player to navigate to a different room in the game world.
 *
 * <p>
 * The move command checks if the specified location corresponds to an availablelocation.
 * If a matching lcoation is found, the player's location is updated to this location.
 * </p>
 */

public class Move extends Command {

    //contructor
    public Move(String location) {
        this.value = location;
        this.commandType = commandType.MOVE;

    }

    public String execute(GameState gameState) {

        if (value== null || value.isEmpty()) {
            return "Move where? Please specify a location.";
        }

        Mansion mansion = gameState.getMansion();
        String targetLocationName = value.trim();
        Location targetLocation = null;

       //fund the location
        for (Location location :mansion.getLocations()) {
            if (location.getName().equalsIgnoreCase(targetLocationName)) {
                targetLocation = location;
                break;
            }
        }


        if (targetLocation == null) {
            return"There is no location named '" + targetLocationName + "'.";
        }

        //if a clue is needed to enter the location
        if (targetLocation.getRequiredClueId() != null) {
            String neededClueId = targetLocation.getRequiredClueId();
            Clue neededClue =gameState.getPlayer().getNotebook().getClueById(neededClueId);

            if (neededClue != null) {
                //update current location
                mansion.setCurrentLocation(targetLocation.getId());
                gameState.reduceScore();
                return "You move to the " + targetLocation.getName()+ " using " + neededClue.getName() + ".\n"
                        + targetLocation.getDescription();
            } else {
                return "You need the clue '" + neededClueId +"' to enter the " + targetLocation.getName() + ".";
            }
        }


        mansion.setCurrentLocation(targetLocation.getId());
        gameState.reduceScore();
        return "You move to the " + targetLocation.getName() +".\n" + targetLocation.getDescription();
    }


}

