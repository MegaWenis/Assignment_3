package org.uob.a3.commands;

import org.uob.a3.gameobjects.*;

/**
 * Represents the "analyze" command, allowing the player to analyze clues for further insights.
 *
 * <p>
 * The analyze command examines a specified clue or item in the player's notebook and provides
 * detailed information, including descriptions, keywords, relevance, and hints.
 * </p>
 */
public class Analyze extends Command {

    public Analyze(String topic) {
        this.value = topic;
        this.commandType =commandType.ANALYZE;
    }


    public String execute(GameState gameState) {
        Notebook notebook= gameState.getPlayer().getNotebook();

        for (Clue clue : notebook.getClues()) {
            if (clue.getName().equalsIgnoreCase(value)) {
                return "Analyzing clue: " + clue.getName()+ "\n"+
                        "Description: " +clue.getDescription() +"\n" +
                        "Keywords: "+ clue.getKeywords()+ "\n" +
                        "Relevance: " + clue.getRelevance() +"\n" +
                        "Hint: " + clue.getHint();
            }
        }

        return "The clue or item named '" + value + "' was not found in your notebook. Please check the name and try again.";
    }

    @Override
    public String toString() {
        return"Command[type: 'analyze', target: '" + value + "']";
    }
}
