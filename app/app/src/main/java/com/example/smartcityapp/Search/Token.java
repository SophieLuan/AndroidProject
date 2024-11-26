package com.example.smartcityapp.Search;

/**
 * Token class to save extracted token from tokenizer.
 * Each token has its surface form saved in {@code token}
 * and type saved in {@code type} which is one of the predefined type in Type enum.
 *
 * author: Zhizhao Sun (u7799455)
 */

public class Token {
    public enum Type{
        /*Token class to save extracted token from tokenizer.
         * The following are the different types of tokens:
         *  CAE: type, participants, date;
         *  EQUAL: = ;
         *  AND:AND ;
         *  OR: OR ;
         *  STR: string  or  integer.
         */
        CAE,EQUAL,AND,OR,STR
    }
    private final String token;
    private final Type type;

    public Token(String token, Type type) {
        this.token = token;
        this.type = type;
    }
    public static class IllegalTokenException extends IllegalArgumentException {
        public IllegalTokenException(String errorMessage) {
            super(errorMessage);
        }
    }

    public String getToken() {
        return token;
    }

    public Type getType() {
        return type;
    }
    @Override
    public String toString() {
        if(type == Type.CAE){
            return "CAR(" + token + ")";
        }else if(type == Type.STR){
            return "STR(" + token + ")";
        }else {
            return type + "";
        }
    }

}
