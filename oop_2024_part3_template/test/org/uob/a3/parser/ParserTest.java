package org.uob.a3.parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uob.a3.commands.*;

import java.util.ArrayList;

class ParserTest {

    private Parser parser;
    private ArrayList<Token> tokens;

    @BeforeEach
    void setUp() {
        parser = new Parser();
        tokens = new ArrayList<>();
    }

    @Test
    void testMoveCommand() throws CommandErrorException {
        tokens.add(new Token(TokenType.MOVE));
        tokens.add(new Token(TokenType.VAR, "north"));

        Command command = parser.parse(tokens);
        assertEquals(CommandType.MOVE, command.commandType, "CommandType should be MOVE.");
        assertEquals("north", command.value, "Command value should be 'north'.");
    }

    @Test
    void testCollectCommand() throws CommandErrorException {
        tokens.add(new Token(TokenType.COLLECT));
        tokens.add(new Token(TokenType.VAR, "lamp"));

        Command command = parser.parse(tokens);
        assertEquals(CommandType.COLLECT, command.commandType, "CommandType should be COLLECT.");
        assertEquals("lamp", command.value, "Command value should be 'lamp'.");
    }

    @Test
    void testAccuseCommand() throws CommandErrorException {
        tokens.add(new Token(TokenType.ACCUSE));
        tokens.add(new Token(TokenType.VAR, "suspect"));

        Command command = parser.parse(tokens);
        assertEquals(CommandType.ACCUSE, command.commandType, "CommandType should be ACCUSE.");
        assertEquals("suspect", command.value, "Command value should be 'suspect'.");
    }

    @Test
    void testAnalyzeCommand() throws CommandErrorException {
        tokens.add(new Token(TokenType.ANALYZE));
        tokens.add(new Token(TokenType.VAR, "knife"));

        Command command = parser.parse(tokens);
        assertEquals(CommandType.ANALYZE, command.commandType, "CommandType should be ANALYZE.");
        assertEquals("knife", command.value, "Command value should be 'knife'.");
    }

    @Test
    void testStatusCommand() throws CommandErrorException {
        tokens.add(new Token(TokenType.STATUS));
        tokens.add(new Token(TokenType.VAR, "inventory"));

        Command command = parser.parse(tokens);
        assertEquals(CommandType.STATUS, command.commandType, "CommandType should be STATUS.");
        assertEquals("inventory", command.value, "Command value should be 'inventory'.");
    }

    @Test
    void testLookCommand() throws CommandErrorException {
        tokens.add(new Token(TokenType.LOOK));
        tokens.add(new Token(TokenType.VAR, "room"));

        Command command = parser.parse(tokens);
        assertEquals(CommandType.LOOK, command.commandType, "CommandType should be LOOK.");
        assertEquals("room", command.value, "Command value should be 'room'.");
    }

    @Test
    void testQuitCommand() throws CommandErrorException {
        tokens.add(new Token(TokenType.QUIT));

        Command command = parser.parse(tokens);
        assertEquals(CommandType.QUIT, command.commandType, "CommandType should be QUIT.");
        assertNull(command.value, "Command value for QUIT should be null.");
    }

    @Test
    void testInvalidCommandThrowsException() {
        tokens.add(new Token(TokenType.VAR, "nonsense"));

        assertThrows(CommandErrorException.class, () -> parser.parse(tokens),
                "Invalid commands should throw CommandErrorException.");
    }

    @Test
    void testMissingArgumentThrowsException() {
        tokens.add(new Token(TokenType.MOVE));
        tokens.add(new Token(TokenType.PREPOSITION, "on"));

        assertThrows(CommandErrorException.class, () -> parser.parse(tokens),
                "Commands missing a required argument should throw CommandErrorException.");
    }
}
