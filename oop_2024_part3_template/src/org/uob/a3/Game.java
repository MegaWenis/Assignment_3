package org.uob.a3;

import org.uob.a3.commands.*;
import org.uob.a3.gameobjects.*;
import org.uob.a3.parser.*;
import org.uob.a3.utils.*;

import java.util.Scanner;

/**
 * The main class for the Mystery Game application.
 *
 * <p>
 * The {@code Game} class manages the game's lifecycle, including loading the game state,
 * processing player input, and executing commands. It integrates the game state, parser,
 * and tokeniser components to create an interactive text-based game experience.
 * </p>
 */
public class Game {

    private static Scanner scanner;
    private static Tokeniser tokeniser;
    private static Parser parser;
    private static GameState gameState;

    public static void main(String[] args)
    {
        //set up the game then start the main gmae loop in start
        setup();
        start();
    }

    //Sets up the game by initializing the game state, scanner, parser, and tokeniser.
    public static void setup() {

        //CHANGE FILENAME LOCATION TO NEW ONE
        // assignment-3/oop_2024_part3_template/src/org/uob/a3/game.txt
        // /jupyter/work/bsi418/src/org/uob/a2/game.txt
        //As 3, Gitless/oop_2024_part3_template/src/org/uob/a3/game.txt
        String fileName = "/jupyter/work/As 3, Gitless/oop_2024_part3_template/src/org/uob/a3/game.txt";
        System.out.println("Attempting to load game state from: " + fileName);

        try {

            gameState = GameStateFileParser.parse(fileName);
            scanner = new Scanner(System.in);
            parser = new Parser();
            tokeniser= new Tokeniser();

            if (gameState != null && gameState.getMansion() != null) {
                //initialize the starting room
                Location startingLocation = gameState.getMansion().getCurrentLocation();
                if (startingLocation !=null) {
                    gameState.getMansion().setCurrentLocation(startingLocation.getId());
                    //succsesfully load first location

                //several posible errors
                } else {
                    System.err.println("Starting Location is not defined in the game state.");
                    System.exit(1);
                }
            } else {
                System.err.println("Failed to load or initialize game state.");
                System.exit(1);
            }

        } catch(Exception e) {
            System.err.println("Failed to load game state: " + e.getMessage());
            System.exit(1);
        }
    }


    public static void start()
    {
        boolean running = true;
        System.out.println("Welcome to Karlov Manor, your wife went missing here one week ago");
        System.out.println("You are Leon Kennedy\nTrained detective\nYou must find out what happened to her.");
        //main game loop
        while(running){
            System.out.println("-> ");
            String UserInput = scanner.nextLine();


            Command command;
            //take the input and parse into Command

            try{
                tokeniser.tokenise(UserInput);
                command =parser.parse(tokeniser.getTokens());
                turn(command);
            } catch(CommandErrorException error) {
                System.out.println(error.getMessage());}
        }
    }

    //handles each turn in the game
    public static void turn(Command command) {

        //score check
        if (gameState.getScore() <= 0){
            System.out.println("Your Score is 0, you lost!");
            System.exit(0);
        }

        //command executes
        if (command !=null&&gameState != null){
            System.out.println(command.execute(gameState));
            if (command.commandType==CommandType.QUIT) {
                System.exit(0);
            }
        } else{
            System.out.println("game state not initialised");
        }
    }
}

