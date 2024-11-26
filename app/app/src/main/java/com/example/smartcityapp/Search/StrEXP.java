package com.example.smartcityapp.Search;

/**
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of String.
 * Both numbers and words are strings
 * author: Zhizhao Sun (u7799455)
 */

import com.example.smartcityapp.loadData.DataActivity;

public class StrEXP extends EXP{
    private String word;
    public StrEXP(String word) {
        this.word = word;
    }
    @Override
    public String show() {
        return word;
    }

    @Override
    public boolean evaluate(DataActivity activity) {
        throw  new Token.IllegalTokenException("null");
    }

    public String getWord(){
        return word;
    }


}
