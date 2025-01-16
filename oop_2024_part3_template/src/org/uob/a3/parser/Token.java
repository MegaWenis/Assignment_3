package org.uob.a3.parser;

/**
 * Represents a token in the parsing process, consisting of a {@code TokenType} and an optional value.
 *
 * <p>
 * Tokens are used to represent the smallest units of meaning in the command input,
 * such as keywords or variables.
 * </p>
 */
public class Token {

    //specified value and type
    private final TokenType tokenType;
    private final String value;


    //2 constructors depending on whether it has a value or not
    public Token(TokenType tokenType, String value)
    {
        this.tokenType= tokenType;
        this.value = value != null ? value : "";


    }

    public Token(TokenType tokenType) {
        this.tokenType = tokenType;
        this.value = tokenType.name().toLowerCase();
    }

    public TokenType getTokenType() {return tokenType;}

    public String getValue() {return value;}
}

