package com.example.smartcityapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import com.example.smartcityapp.Search.Token;
import com.example.smartcityapp.Search.Tokenizer;

import org.junit.Test;


/**
 * Test different types of tokens: CAE,EQUAL,AND,OR,STR.
 * @author Zhizhao Sun(u7799455), Ziang Wang(u7748243)
 */

public class TokenizerTest {
    @Test(timeout=1000)
    public void testAnd(){
        Tokenizer tokenizer=new Tokenizer("AND");
        assertEquals("wrong token type", Token.Type.AND, tokenizer.current().getType());
    }
    @Test(timeout=1000)
    public void testEqual(){
        Tokenizer tokenizer=new Tokenizer("=");
        assertEquals("wrong token type", Token.Type.EQUAL, tokenizer.current().getType());
    }
    @Test(timeout=1000)
    public void testOr(){
        Tokenizer tokenizer=new Tokenizer("Or");
        assertEquals("wrong token type", Token.Type.OR, tokenizer.current().getType());
    }
    @Test(timeout=1000)
    public void testCae(){
        Tokenizer tokenizer=new Tokenizer("Type");
        assertEquals("wrong token type", Token.Type.CAE, tokenizer.current().getType());
    }

    @Test(timeout=1000)
    public void testStr(){
        Tokenizer tokenizer=new Tokenizer("social");
        assertEquals("wrong token type", Token.Type.STR, tokenizer.current().getType());
    }

    @Test(timeout=1000)
    public void testType(){
        String s = "type=social";
        Tokenizer tokenizer = new Tokenizer(s);

        assertEquals(Token.Type.CAE, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.EQUAL,tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.STR,tokenizer.current().getType());
    }
    @Test(timeout=1000)
    public void testExceptionToken() {
        // Test a series of non-identifiable tokens
        assertThrows(StackOverflowError.class, () -> {
           Tokenizer tokenizer = new Tokenizer("(1+2.5)/2");
            int i = -1;
            while (i++ < "(1+2.5)/2".length()) {
                tokenizer.next();
            }
        });
    }

    @Test(timeout=1000)
    public void testTokenizeEmptyInput(){
        // Define an empty input string
        String input = "";

        // Create a tokenizer instance with the empty input
        Tokenizer tokenizer = new Tokenizer(input);

        // Assert that the tokenizer does not have any tokens
        assertFalse(tokenizer.hasNext());
    }


    @Test(timeout=1000)
    public void testTokenizeSimpleExpression() {
        String s = "type=social AND participants=2";
        Tokenizer tokenizer = new Tokenizer(s);

        assertEquals(Token.Type.CAE, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.EQUAL, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.STR, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.AND, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.CAE, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.EQUAL, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.STR, tokenizer.current().getType());
    }

    @Test(timeout=1000)
    public void testTokenizeComplexExpression() {
        String s = "type=social AND participants=2 OR date=1105";
        Tokenizer tokenizer = new Tokenizer(s);

        assertEquals(Token.Type.CAE, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.EQUAL, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.STR, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.AND, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.CAE, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.EQUAL, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.STR, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.OR, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.CAE, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.EQUAL, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.STR, tokenizer.current().getType());
    }


    @Test(timeout=1000)
    public void testTokenizeWithSpaces() {
        String s = "  type  =  social   AND   participants =  2";
        Tokenizer tokenizer = new Tokenizer(s);

        assertEquals(Token.Type.CAE, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.EQUAL, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.STR, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.AND, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.CAE, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.EQUAL, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.STR, tokenizer.current().getType());;
    }

    @Test(timeout=1000)
    public void testCaseInsensitive() {
        Tokenizer tokenizer = new Tokenizer("aND or");
        assertEquals(Token.Type.AND, tokenizer.current().getType());
        tokenizer.next();
        assertEquals(Token.Type.OR, tokenizer.current().getType());
    }

}
