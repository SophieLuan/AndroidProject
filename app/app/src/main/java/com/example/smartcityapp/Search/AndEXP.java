package com.example.smartcityapp.Search;

import com.example.smartcityapp.loadData.DataActivity;

/**
 * it is extended from the abstract class Exp.
 * This class is used to represent the expression of addition
 * author: Zhizhao Sun  (u7799455)
 */

public class AndEXP extends EXP{
    private EXP term;
    private EXP exp;

    public AndEXP(EXP term, EXP exp) {
        this.term = term;
        this.exp = exp;
    }
    @Override
    public String show() {
        return term.show()+ "AND" + exp.show();
    }

    @Override
    public boolean evaluate(DataActivity activity) {
        return term.evaluate(activity)&&exp.evaluate(activity);
    }
}
