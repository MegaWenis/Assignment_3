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

        if (value==""||value==null) {
            return "Move where? Please specify a location.";
        }

        Mansion mansion = gameState.getMansion();
        String targetLocationName = value;
        Location targetLocation = null;

        //check for location and ignore cases
        for (Location location :mansion.getLocations()) {
            if (location.getName().equalsIgnoreCase(targetLocationName)) {
                targetLocation = location;
                break;
            }
        }

        if (targetLocation !=null) {
            String targetLocationID = targetLocation.getId();
            mansion.setCurrentLocation(targetLocationID);
            //expect :
            //You move to the Hallway.
            //A dimly lit hallway.
            gameState.reduceScore();
            return "You move to the " + targetLocation.getName() + ".\n" + targetLocation.getDescription();
        } else {
            //expected: <There is no location named 'Kitchen'.>
            return "There is no location named '" + targetLocationName + "'.";
        }
    }

}

