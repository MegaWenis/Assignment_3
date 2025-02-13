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
        this.commandType = CommandType.ANALYZE;
    }

    public String execute(GameState gameState) {
        Notebook notebook = gameState.getPlayer().getNotebook();

        if (value == null || value.trim().isEmpty()){
            return "Analyze what? Please specify an item or clue to analyze.";
        }

        for (Clue clue :notebook.getClues()) {
            if (clue.getName().equalsIgnoreCase(value.trim())) {
                System.out.println(clue.getHint());
                return "Clue {id='" + clue.getId() + "', name='" + clue.getName() + "', description='" + clue.getDescription() +
                        "', keywords=" + clue.getKeywords() + ", relevance=" + clue.getRelevance() + "}";
            }
        }

        return "You don't have any clue or item named '"+ value.trim() + "' to analyze.";
    }
}