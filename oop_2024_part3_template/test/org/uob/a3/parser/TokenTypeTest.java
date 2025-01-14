package org.uob.a3.parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TokenTypeTest {

    @Test
    void testTokenTypeExistence() {
        // Check all TokenTypes exist
        assertNotNull(TokenType.ACCUSE, "TokenType ACCUSE should exist.");
        assertNotNull(TokenType.ANALYZE, "TokenType ANALYZE should exist.");
        assertNotNull(TokenType.COLLECT, "TokenType COLLECT should exist.");
        assertNotNull(TokenType.DROP, "TokenType DROP should exist.");
        assertNotNull(TokenType.EOL, "TokenType EOL should exist.");
        assertNotNull(TokenType.ERROR, "TokenType ERROR should exist.");
        assertNotNull(TokenType.HELP, "TokenType HELP should exist.");
        assertNotNull(TokenType.INSPECT, "TokenType INSPECT should exist.");
        assertNotNull(TokenType.LOOK, "TokenType LOOK should exist.");
        assertNotNull(TokenType.MOVE, "TokenType MOVE should exist.");
        assertNotNull(TokenType.PREPOSITION, "TokenType PREPOSITION should exist.");
        assertNotNull(TokenType.QUIT, "TokenType QUIT should exist.");
        assertNotNull(TokenType.STATUS, "TokenType STATUS should exist.");
        assertNotNull(TokenType.USE, "TokenType USE should exist.");
        assertNotNull(TokenType.VAR, "TokenType VAR should exist.");
    }

    @Test
    void testTokenTypeCount() {
        // Ensure all TokenTypes are present
        TokenType[] types = TokenType.values();
        assertEquals(15, types.length, "There should be exactly 16 TokenTypes.");
    }

    @Test
    void testTokenTypeToString() {
        // Verify that toString returns the correct names
        assertEquals("ACCUSE", TokenType.ACCUSE.toString(), "TokenType ACCUSE should return 'ACCUSE'.");
        assertEquals("ANALYZE", TokenType.ANALYZE.toString(), "TokenType ANALYZE should return 'ANALYZE'.");
        assertEquals("COLLECT", TokenType.COLLECT.toString(), "TokenType COLLECT should return 'COLLECT'.");
        assertEquals("DROP", TokenType.DROP.toString(), "TokenType DROP should return 'DROP'.");
        assertEquals("EOL", TokenType.EOL.toString(), "TokenType EOL should return 'EOL'.");
        assertEquals("ERROR", TokenType.ERROR.toString(), "TokenType ERROR should return 'ERROR'.");
        assertEquals("HELP", TokenType.HELP.toString(), "TokenType HELP should return 'HELP'.");
        assertEquals("INSPECT", TokenType.INSPECT.toString(), "TokenType INSPECT should return 'INSPECT'.");
        assertEquals("LOOK", TokenType.LOOK.toString(), "TokenType LOOK should return 'LOOK'.");
        assertEquals("MOVE", TokenType.MOVE.toString(), "TokenType MOVE should return 'MOVE'.");
        assertEquals("PREPOSITION", TokenType.PREPOSITION.toString(), "TokenType PREPOSITION should return 'PREPOSITION'.");
        assertEquals("QUIT", TokenType.QUIT.toString(), "TokenType QUIT should return 'QUIT'.");
        assertEquals("STATUS", TokenType.STATUS.toString(), "TokenType STATUS should return 'STATUS'.");
        assertEquals("USE", TokenType.USE.toString(), "TokenType USE should return 'USE'.");
        assertEquals("VAR", TokenType.VAR.toString(), "TokenType VAR should return 'VAR'.");
    }
}
