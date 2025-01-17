package org.uob.a3.commands;

import org.uob.a3.gameobjects.*;

/**
 * Represents the help command, providing the player with instructions or information
 * about various topics related to the game.
 */
public class Help extends Command {

    public Help(String topic) {
        this.commandType = commandType.HELP;
        this.value = topic;
    }

    public String execute(GameState gameState) {
        if (value==null){
            return generalHelp();
        }
        else {
            return topicHelp();
        }
    }

    public String generalHelp() {
        return """
                Welcome to the game! Here are some commands you can use:
                
                - MOVE <location>: Move to a specified location eg ("move hallway").
                - COLLECT <clue>: Collect a clue and add it to your notebook.
                - LOOK: You can look room, look features, look exits or look a specific item
                - ANALYZE: Analyze a clue in your notebook for details (e.g., ’analyze clue_name’).
                - INSPECT: Inspect a feature in the current room (e.g., ’inspect feature_name’).
                - ACCUSE: Accuse a suspect to attempt to resolve the case (e.g., ’accuse suspect_name’).
                - STATUS: View your current status, notebook, and player.
                - HELP [topic]: Get help about a specific command or leave topic blank for general gameplay.
                - QUIT: Quit the game.
                
                Explore and gather items to progress :)
                Have fun exploring and good luck!
                """;
    }

    public String topicHelp() {
        String topic = this.value;

        switch (topic.toLowerCase()) {
            case "move":
                return "MOVE Command: Move in a specific location. Example: MOVE hallway.";
            case "collect":
                return "COLLECT Command: Collect a clue from the room if it is present and add it to your notebook. eg 'move Hallway'";
            case "analyze":
                return "ANALYZE Command: Look in detail at a specific feature in the room to discover details about it.";
            case "accuse":
                return "ACCUSE Command: Accuse a suspect once you are sure it is them, if correct you win the game. eg ('accuse Moriarty')";
            case "look":
                return "LOOK Command: Look around the current room and see what's available.";
            case "status":
                return "STATUS Command: View your current status, including notebook and player.";
            case "help":
                return "HELP Command: Get help about a specific command or general gameplay. Example: HELP move.";
            case "quit":
                return "QUIT Command: Exit the game. Example: QUIT.";
            default:
                return "Sorry, no help is available for the topic '" + topic + "'. Try HELP for general instructions.";
        }
    }


    @Override
    public String toString() {
        return "Command: HELP, Topic: " + (value != null?value : "General");
    }
}

