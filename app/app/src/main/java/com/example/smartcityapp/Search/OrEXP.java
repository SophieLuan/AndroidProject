package com.example.smartcityapp.Search;

/**
 *   it is extended from the abstract class Exp.
 *   This class is used to represent the expression of or
 *   author: Zhizhao Sun (u7799455)
 */

import com.example.smartcityapp.loadData.DataActivity;

public class OrEXP extends EXP{
    private EXP term;
    private EXP exp;

    public OrEXP(EXP term, EXP exp) {
        this.term = term;
        this.exp = exp;
    }
    @Override
    public String show() {
        return term.show()+ "OR" + exp.show();
    }

    @Override
    public boolean evaluate(DataActivity activity) {
        return term.evaluate(activity)||exp.evaluate(activity);
    }
}
