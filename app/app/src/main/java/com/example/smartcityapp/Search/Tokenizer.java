package com.example.smartcityapp.Search;

/**
 * Tokenization, within the context of this lab, is the process of splitting a string into
 * small units called, 'Tokens', to be passed onto the Parser.
 *
 * author: Zhizhao Sun (u7799455)
 */

public class Tokenizer {
    private String buffer;
    private Token currentToken;
    public Tokenizer(String text) {
        buffer = text;
        next();
    }
    public void next() {
        buffer = buffer.trim();
        if (buffer.isEmpty()) {
            currentToken = null;
            return;
        }
        try{
            if(buffer.toUpperCase().startsWith("AND")){
                currentToken = new Token("AND", Token.Type.AND);
            }else if(buffer.toUpperCase().startsWith("OR")){
                currentToken = new Token("OR", Token.Type.OR);
            }else if(buffer.charAt(0)=='='){
                currentToken = new Token("=", Token.Type.EQUAL);
            }else {
                int pos=0;
                StringBuilder sb=new StringBuilder();
                while (pos < buffer.length()&&(Character.isDigit(buffer.charAt(pos))||Character.isLetter(buffer.charAt(pos)))){
                    sb.append(buffer.charAt(pos));
                    pos++;
                }
                String s=sb.toString();
                if(s.equalsIgnoreCase("type")||s.equalsIgnoreCase("participants")
                        ||s.equalsIgnoreCase("date")){
                    currentToken = new Token(s, Token.Type.CAE);
                }else if(s.matches("[a-zA-Z]+|\\d+")){
                    //Regular expression: The string contains only numbers or letters
                    currentToken = new Token(s, Token.Type.STR);
                }else {
                    throw new Token.IllegalTokenException("not any token type");
                }
            }
            int tokenLen = currentToken.getToken().length();
            buffer = buffer.substring(tokenLen);
        }catch (Exception e){
            next();
        }


    }
    public Token current() {
        return currentToken;
    }
    public boolean hasNext() {
        return currentToken != null;
    }

}
