package com.example.smartcityapp.Search;

import com.example.smartcityapp.loadData.DataActivity;

/**
 *   it is extended from the abstract class Exp.
 *   This class is used to represent the expression of null
 *   If the input string is not syntactically valid, then return the NullEXP,
 *   and the invalid field is skipped directly to execute the valid part and output the result.
 *
 *   author: Zhizhao Sun (u7799455)
 */
public class NullEXP extends EXP{
    @Override
    public String show() {
        return "";
    }

    @Override
    public boolean evaluate(DataActivity activity) {
        return true;
    }
}
