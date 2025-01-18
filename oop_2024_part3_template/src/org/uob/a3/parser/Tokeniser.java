package org.uob.a3.parser;

import java.util.ArrayList;

/**
 * The {@code Tokeniser} class is responsible for converting a string input into a list of tokens
 * that can be parsed into commands by the game.
 *
 * <p>
 * The tokeniser identifies keywords, variables, and special symbols, assigning each a {@code TokenType}.
 * It ensures that input commands are broken down into manageable components for further processing.
 * </p>
 */
public class Tokeniser {

    private final ArrayList<Token> tokens;

    public Tokeniser() {
        this.tokens = new ArrayList<>();
    }

    public void tokenise(String s) {
        tokens.clear();
        String sanitisedInput = sanitise(s);
        String[] words = sanitisedInput.split(" ");

        for (String word : words) {
            if (word.isEmpty()) {
                continue; //pass over empty string
            }

            TokenType tokenType = TokenType.VAR;//default

            switch (word) {
                case "move":
                    tokenType = TokenType.MOVE;
                    break;
                case "collect":
                    tokenType = TokenType.COLLECT;
                    break;
                case "quit":
                    tokenType = TokenType.QUIT;
                    break;
                case "status":
                    tokenType = TokenType.STATUS;
                    break;
                case "look":
                    tokenType = TokenType.LOOK;
                    break;
                case "touch":
                    tokenType = TokenType.TOUCH;
                    break;
                case "analyze":
                    tokenType = TokenType.ANALYZE;
                    break;
                case "inspect":
                    tokenType = TokenType.INSPECT;
                    break;
                case "accuse":
                    tokenType = TokenType.ACCUSE;
                    break;
                case "use": //add alter
                    tokenType = TokenType.USE;
                    break;
            }

            tokens.add(new Token(tokenType, word));
        }

        //end of line
        tokens.add(new Token(TokenType.EOL, ""));
    }
    public String sanitise(String s){
        if (s == null) {
            return "";
        }
        //remove spaces
        return s.toLowerCase().trim().replaceAll("\\s+", " ");
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }
}