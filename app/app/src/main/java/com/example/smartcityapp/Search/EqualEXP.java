package com.example.smartcityapp.Search;

/**
 *   it is extended from the abstract class Exp.
 *   This class is used to represent the expression of equal
 *   author: Zhizhao Sun (u7799455)
 */

import com.example.smartcityapp.loadData.DataActivity;

public class EqualEXP extends EXP{
    private CaeEXP category;
    private StrEXP words;

    public EqualEXP(CaeEXP category,StrEXP words){
        this.category=category;
        this.words=words;
    }

    @Override
    public String show() {
        return category.show()+"="+words.show();
    }

    @Override
    public boolean evaluate(DataActivity activity) {
        return  category.getCategory(activity).equals(words.getWord());
    }
}
