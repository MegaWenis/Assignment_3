package org.uob.a3.commands;

import org.uob.a3.gameobjects.GameState;
import org.uob.a3.gameobjects.Location;
import org.uob.a3.gameobjects.Mansion;
import org.uob.a3.gameobjects.Player;
import org.uob.a3.gameobjects.Ghost;

public class Touch extends Command {
    public Touch(String Target) {
        this.commandType = CommandType.TOUCH;
        this.value = Target;
    }

    public String execute(GameState gameState) {
        //take input
        String target = value;
        Mansion mansion = gameState.getMansion();

        //gets ghost in this location
        Location currentLocation = mansion.getCurrentLocation();
        Ghost thisGhost = currentLocation.getGhost();

        if (thisGhost == null) {
            return "There is nothing here worth touching.";

        }

        //checking if typed blood
        if (target.equalsIgnoreCase("blood")||target.equalsIgnoreCase("bloodstain")) {
            return "You reached and touched the blood\nThe ghost: "+thisGhost.getName()+" appeared!\n"+"'"+thisGhost.getDescription()+"'";
        }
        else {
            return "It is only worth touching blood";
        }
    }
}

