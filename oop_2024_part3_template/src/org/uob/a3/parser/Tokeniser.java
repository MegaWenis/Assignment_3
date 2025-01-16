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

    //key objects
    private final ArrayList<Token> tokens;

    public Tokeniser() {
        this.tokens = new ArrayList<>();
    }

    public void tokenise(String s) {
        tokens.clear();
        String sanitisedInput = sanitise(s);
        String[] words = sanitisedInput.split(" ");

        for (String word : words) {
            TokenType tokenType = TokenType.VAR;
            switch (word) {
                case "move":
                    tokenType = TokenType.MOVE;
                    break;
                case "Collect":
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
                case "analyze":
                    tokenType = TokenType.ANALYZE;
                    break;
                case "inspect":
                    tokenType = TokenType.INSPECT;
                    break;
                case "accuse":
                    tokenType = TokenType.ACCUSE;
                    break;

            }
            tokens.add(new Token(tokenType, word));
        }
    }

    public String sanitise(String s) {
        if (s == null) {
            return "";
        }
        return s.toLowerCase().trim();
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }
}

