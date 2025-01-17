package org.uob.a3.parser;

import java.util.ArrayList;

import org.uob.a3.commands.*;

/**
 * The {@code Parser} class processes a list of tokens and converts them into {@code Command} objects
 * that can be executed by the game.
 *
 * <p>
 * The parser identifies the type of command from the tokens and creates the appropriate command object.
 * If the command is invalid or incomplete, a {@code CommandErrorException} is thrown.
 * </p>
 */
public class Parser {

    //empty constrctor
    public Parser(){};

    public Command parse(ArrayList<Token> tokens) throws CommandErrorException
    {
        CommandErrorException exception = new CommandErrorException();
        //give a command error if the tokens is empty
        if(tokens==null || tokens.isEmpty()){
            throw exception;
        }


        String typeOfCommand = tokens.get(0).getValue().toLowerCase();
        //testing whether tokens has more than one token
        String argument;
        if (tokens.size() > 1) {

            argument = tokens.get(1).getValue();
        } else {
            argument = "";}


        //checking the type of command and returning new command clas

        switch (typeOfCommand){
            case "analyze":  if(argument.isEmpty()){throw exception;}
                return new Analyze(argument);

            case "accuse": if(argument.isEmpty()){throw exception;}
                return new Accuse(argument);

            case "move": if(argument.isEmpty()){throw exception;}
                return new Move(argument);

            case "collect": if(argument.isEmpty()){throw exception;}
                return new Collect(argument);

            case "look":return new Look(argument);

            case "score":return new Score();

            case "quit": return new Quit();
            case "status":
                String topicStatus = tokens.get(1).getValue();
                return new Status(topicStatus);
            case "help":
                String topicHelp = tokens.get(1).getValue();
                return new Help(topicHelp);
            default:
                throw exception;
        }

    }
}

