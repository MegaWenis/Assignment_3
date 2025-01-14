package org.uob.a3.parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TokenTest {

    @Test
    void testTokenWithValue() {
        // Create a Token with a value
        Token token = new Token(TokenType.COLLECT, "key");

        // Verify TokenType and Value
        assertEquals(TokenType.COLLECT, token.getTokenType(), "TokenType should be COLLECT.");
        assertEquals("key", token.getValue(), "Token value should be 'key'.");
    }

    @Test
    void testTokenWithoutValue() {
        // Create a Token without a value
        Token token = new Token(TokenType.QUIT);

        // Verify TokenType and Value
        assertEquals(TokenType.QUIT, token.getTokenType(), "TokenType should be QUIT.");
        assertNull(token.getValue(), "Token value should be null.");
    }

    @Test
    void testMultipleTokens() {
        // Create multiple Tokens and verify
        Token token1 = new Token(TokenType.MOVE, "north");
        Token token2 = new Token(TokenType.LOOK, "room");
        Token token3 = new Token(TokenType.PREPOSITION, "on");

        assertEquals(TokenType.MOVE, token1.getTokenType(), "Token1 type should be MOVE.");
        assertEquals("north", token1.getValue(), "Token1 value should be 'north'.");

        assertEquals(TokenType.LOOK, token2.getTokenType(), "Token2 type should be LOOK.");
        assertEquals("room", token2.getValue(), "Token2 value should be 'room'.");

        assertEquals(TokenType.PREPOSITION, token3.getTokenType(), "Token3 type should be PREPOSITION.");
        assertEquals("on", token3.getValue(), "Token3 value should be 'on'.");
    }

    @Test
    void testTokenEquality() {
        // Create two identical Tokens
        Token token1 = new Token(TokenType.COLLECT, "lamp");
        Token token2 = new Token(TokenType.COLLECT, "lamp");
    
        // Verify equality
        assertEquals(token1.getTokenType(), token2.getTokenType(), "Token types should be equal.");
        assertEquals(token1.getValue(), token2.getValue(), "Token values should be equal.");
    }

}
