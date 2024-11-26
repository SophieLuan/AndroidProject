package com.example.smartcityapp.Search;

import com.example.smartcityapp.loadData.DataActivity;

/**
 *   it is extended from the abstract class CaeEXP.
 *   This class is used to represent the expression of type category.
 *
 *   author: Zhizhao Sun (u7799455)
 */

public class TypeEXP extends CaeEXP{
    public TypeEXP() {
        super("type");
    }

    @Override
    public boolean evaluate(DataActivity activity) {
        return activity.getType().equalsIgnoreCase("type");
    }

    @Override
    public String getCategory(DataActivity activity) {
        return activity.getType();
    }
}
