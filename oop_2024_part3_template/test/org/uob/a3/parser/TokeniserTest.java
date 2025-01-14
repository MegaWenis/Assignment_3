package org.uob.a3.parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class TokeniserTest {

    private Tokeniser tokeniser;

    @BeforeEach
    void setUp() {
        tokeniser = new Tokeniser();
    }

    @Test
    void testSingleCommandTokens() {
        tokeniser.tokenise("move");
        ArrayList<Token> tokens = tokeniser.getTokens();

        assertEquals(2, tokens.size(), "There should be 2 tokens (MOVE and EOL).");
        assertEquals(TokenType.MOVE, tokens.get(0).getTokenType(), "First token should be MOVE.");
        assertEquals(TokenType.EOL, tokens.get(1).getTokenType(), "Second token should be EOL.");
    }

    @Test
    void testCommandWithArgument() {
        tokeniser.tokenise("move north");
        ArrayList<Token> tokens = tokeniser.getTokens();

        assertEquals(3, tokens.size(), "There should be 3 tokens (MOVE, VAR, EOL).");
        assertEquals(TokenType.MOVE, tokens.get(0).getTokenType(), "First token should be MOVE.");
        assertEquals(TokenType.VAR, tokens.get(1).getTokenType(), "Second token should be VAR.");
        assertEquals("north", tokens.get(1).getValue(), "VAR token should have value 'north'.");
        assertEquals(TokenType.EOL, tokens.get(2).getTokenType(), "Last token should be EOL.");
    }

    @Test
    void testMultipleCommands() {
        tokeniser.tokenise("look room accuse suspect");
        ArrayList<Token> tokens = tokeniser.getTokens();

        assertEquals(5, tokens.size(), "There should be 5 tokens (LOOK, VAR, ACCUSE, VAR, EOL).");
        assertEquals(TokenType.LOOK, tokens.get(0).getTokenType(), "First token should be LOOK.");
        assertEquals(TokenType.VAR, tokens.get(1).getTokenType(), "Second token should be VAR.");
        assertEquals("room", tokens.get(1).getValue(), "VAR token should have value 'room'.");
        assertEquals(TokenType.ACCUSE, tokens.get(2).getTokenType(), "Third token should be ACCUSE.");
        assertEquals("suspect", tokens.get(3).getValue(), "Fourth token (VAR) should have value 'suspect'.");
        assertEquals(TokenType.EOL, tokens.get(4).getTokenType(), "Last token should be EOL.");
    }

    @Test
    void testPrepositions() {
        tokeniser.tokenise("use key on chest");
        ArrayList<Token> tokens = tokeniser.getTokens();

        assertEquals(5, tokens.size(), "There should be 5 tokens (USE, VAR, PREPOSITION, VAR, EOL).");
        assertEquals(TokenType.USE, tokens.get(0).getTokenType(), "First token should be USE.");
        assertEquals("key", tokens.get(1).getValue(), "Second token (VAR) should have value 'key'.");
        assertEquals(TokenType.PREPOSITION, tokens.get(2).getTokenType(), "Third token should be PREPOSITION.");
        assertEquals("on", tokens.get(2).getValue(), "PREPOSITION token should have value 'on'.");
        assertEquals("chest", tokens.get(3).getValue(), "Fourth token (VAR) should have value 'chest'.");
        assertEquals(TokenType.EOL, tokens.get(4).getTokenType(), "Last token should be EOL.");
    }

    @Test
    void testUnknownWordsAsVAR() {
        tokeniser.tokenise("unlock secret-door");
        ArrayList<Token> tokens = tokeniser.getTokens();

        assertEquals(3, tokens.size(), "There should be 3 tokens (VAR, VAR, EOL).");
        assertEquals(TokenType.VAR, tokens.get(0).getTokenType(), "First token should be VAR.");
        assertEquals("unlock", tokens.get(0).getValue(), "First token value should be 'unlock'.");
        assertEquals(TokenType.VAR, tokens.get(1).getTokenType(), "Second token should be VAR.");
        assertEquals("secret-door", tokens.get(1).getValue(), "Second token value should be 'secret-door'.");
        assertEquals(TokenType.EOL, tokens.get(2).getTokenType(), "Last token should be EOL.");
    }

    @Test
    void testEmptyInput() {
        tokeniser.tokenise("");
        ArrayList<Token> tokens = tokeniser.getTokens();

        assertEquals(1, tokens.size(), "There should be 1 token (EOL) for empty input.");
        assertEquals(TokenType.EOL, tokens.get(0).getTokenType(), "The only token should be EOL.");
    }

    @Test
    void testSanitisedInput() {
        tokeniser.tokenise("   MOVE    NORTH   ");
        ArrayList<Token> tokens = tokeniser.getTokens();

        assertEquals(3, tokens.size(), "Whitespace should be sanitised, resulting in 3 tokens.");
        assertEquals(TokenType.MOVE, tokens.get(0).getTokenType(), "First token should be MOVE.");
        assertEquals(TokenType.VAR, tokens.get(1).getTokenType(), "Second token should be VAR.");
        assertEquals("north", tokens.get(1).getValue(), "VAR token should have value 'north'.");
        assertEquals(TokenType.EOL, tokens.get(2).getTokenType(), "Last token should be EOL.");
    }
}
