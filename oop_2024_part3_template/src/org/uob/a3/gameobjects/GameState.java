package org.uob.a3.gameobjects;

import java.util.ArrayList;
import java.util.List;

    /*
    Represents the current state of the detective game,
    including the mansion, player, clues, and case resolution.
      The game state contains all necessary information about the game's progress,
      such as the player's status, the state of the game map, collected clues, and case resolution details.
    */


public class GameState {

    //fields
    private Mansion mansion;
    private Player player;
    private List<Clue> collectedClues;
    private CaseResolution caseResolution;

    //blank gamestate
    public GameState() {
        this.mansion = null;
        this.player = null;
        this.collectedClues = new ArrayList<>();
        this.caseResolution =null;
    }

    //well-defined gamestate
    public GameState(Mansion mansion, Player player,List<Clue> collectedClues, CaseResolution caseResolution) {
        this.mansion = mansion != null ?mansion: new Mansion(); // Ensure Mansion is not null
        this.player= player;
        this.collectedClues =new ArrayList<>(collectedClues);
        this.caseResolution = caseResolution;
    }


    //getters and setters
    public Mansion getMansion() {return mansion;}

    public void setMansion(Mansion mansion) {
        this.mansion = mansion;
    }

    public Player getPlayer() {return player;}

    public void setPlayer(Player player) {this.player = player;}

    public List<Clue> getCollectedClues() {return new ArrayList<>(collectedClues);}


    //adding clue to list
    public void addClue(Clue clue) {
        collectedClues.add(clue);
    }


    //set and get case resolution
    public CaseResolution getCaseResolution() {
        return caseResolution;
    }

    public void setCaseResolution(CaseResolution caseResolution) {
        this.caseResolution = caseResolution;
    }


    //to String
    @Override
    public String toString() {
        StringBuilder gameStateDescription = new StringBuilder();
        gameStateDescription.append("GameState:\n");

        gameStateDescription.append("Mansion:\n").append(mansion.toString()).append("\n");

        gameStateDescription.append("Player:\n").append(player.toString()).append("\n");


        gameStateDescription.append("Collected Clues:\n");
        for (Clue clue : collectedClues) {
            gameStateDescription.append(clue.toString()).append("\n");
        }

        gameStateDescription.append("Case Resolution:\n").append(caseResolution.toString()).append("\n");


        return gameStateDescription.toString();
    }
}
