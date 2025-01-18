package org.uob.a3.commands;

import org.uob.a3.gameobjects.*;

import java.util.ArrayList;

/**
 * Represents the "look" command, allowing the player to examine various elements of the game world.
 *
 * <p>
 * The look command can provide details about the current room, its features, and objects within it.
 * </p>
 */
public class Look extends Command {

    public Look (String target) {
        this.value = target;
        this.commandType = commandType.LOOK;
    }

    public String execute(GameState gameState) {

        String target = this.value;
        StringBuilder lookResult = new StringBuilder();
        Location currentLocation = gameState.getMansion().getCurrentLocation();
        String roomName =currentLocation.getName();

        //executing look depending on the target class
        switch (target.toLowerCase()) {

            case "map":
                lookResult.append(gameState.getMansion().displayMap());

            case "room":
                lookResult.append(currentLocation.getName());
                lookResult.append("\n Description: ");
                lookResult.append(gameState.getMansion().getCurrentLocation().getDescription());

                //appending all visible objects

                ArrayList<GameObject> allVisibleObjects = currentLocation.getAll();
                if (!allVisibleObjects.isEmpty()) {
                    lookResult.append("\nVisible Objects");
                    for (GameObject object : allVisibleObjects) {
                        lookResult.append("\n|").append(object.getName());

                    }
                } else {
                    lookResult.append("There aren't any visible objects here.");
                }
                break;

            case "features":

                ArrayList<Feature> features =currentLocation.getFeatures();

                //appending all visible features

                if (!features.isEmpty()){
                    lookResult.append("\nfeatures :");
                    for (Feature feature : features) {
                        lookResult.append(feature.getName()).append("|");
                    }
                } else{
                    lookResult.append("\nYou can't see anything of note.");
                }

                break;

            //<There is nothing named 'Nonexistent' to look at in this location.> but was: <You can't see anything of note about 'Nonexistent'.>
            default:
                //in case they ask for a specific object
                GameObject object = currentLocation.findObjectByName(target);
                if (object != null) {
                    lookResult.append(object.getDescription());
                } else {
                    lookResult.append("There is nothing named '").append(target).append("' to look at in this location.");
                }
                break;
        }


        return lookResult.toString();
    }
}
