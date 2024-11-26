package com.example.smartcityapp.Search;

import com.example.smartcityapp.loadData.DataActivity;

/**
 * Abstract class Exp to represent expressions
 * author: Zhizhao Sun (u7799455)
 */

public abstract class EXP {
    /*
    design pattern: factory + Composite + Interpreter
     */
    public abstract String show();

    /**
     * to determine each data which could meet the search condition
     * @param activity
     * @return
     */
    public abstract boolean evaluate(DataActivity activity);
}
