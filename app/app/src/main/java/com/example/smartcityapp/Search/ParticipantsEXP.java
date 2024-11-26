package com.example.smartcityapp.Search;

import com.example.smartcityapp.loadData.DataActivity;

/**
 *   it is extended from the abstract class CaeEXP.
 *   This class is used to represent the expression of participants category.
 *
 *   author: Zhizhao Sun (u7799455)
 */
public class ParticipantsEXP extends CaeEXP{


    public ParticipantsEXP() {
        super("participants");
    }

    @Override
    public boolean evaluate(DataActivity activity) {
        return String.valueOf(activity.getParticipants()).equalsIgnoreCase("participants");
    }

    @Override
    public String getCategory(DataActivity activity) {
        return String.valueOf(activity.getParticipants());
    }
}
