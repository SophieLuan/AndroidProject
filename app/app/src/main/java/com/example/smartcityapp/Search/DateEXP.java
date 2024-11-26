package com.example.smartcityapp.Search;

import com.example.smartcityapp.loadData.DataActivity;

/**
 *   it is extended from the abstract class CaeEXP.
 *   This class is used to represent the expression of date category.
 *
 *   author: Zhizhao Sun (u7799455)
 */
public class DateEXP extends CaeEXP{
    public DateEXP() {
        super("date");
    }

    @Override
    public boolean evaluate(DataActivity activity) {
        return String.valueOf(activity.getDate()).equalsIgnoreCase("date");
    }

    @Override
    public String getCategory(DataActivity activity) {
        return String.valueOf(activity.getDate());
    }
}
