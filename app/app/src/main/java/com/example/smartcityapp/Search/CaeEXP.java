package com.example.smartcityapp.Search;
import com.example.smartcityapp.loadData.DataActivity;

/**
 *   it is extended from the abstract class Exp.
 *   This class is used to represent the expression of category.
 *   the category includes type, participants, date.
 *
 *   author: Zhizhao Sun  (u7799455)
 */

public abstract class CaeEXP extends EXP{
    private String category;

    public CaeEXP(String category) {
        this.category = category;
    }

    @Override
    public String show() {
        return category;
    }

    @Override
    public abstract boolean evaluate(DataActivity activity);


    /**
     * get the category
     * @param activity
     * @return one of three, type, participants, date.
     */
    public abstract String getCategory(DataActivity activity);
}
