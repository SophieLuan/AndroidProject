package com.example.smartcityapp.Search;
 /*
    Create a unique identifier for each activity to be used for AVL tree searches.

    busywork:        bus
    education:       edu
    music:           mus
    social:          soc
    charity:         cha
    diy:             diy
    relaxation:      rel
    recreational:    rec
    cooking:         coo

    Give each activity an unique id.
    The first three letters represent the type of activity;
    the fourth represents the number of participants;
    the fifth to eighth represent the month and day;
    and the last four digits represent the time.

    author: Zhizhao Sun (u7799455)
     */

public class CreateUniqueID {

    public static String createID(String type, int participants,String date,String time) {
        StringBuilder sb = new StringBuilder();
        sb.append(type.substring(0, 3).toLowerCase());// add the type
        sb.append(participants);// add the participants
        sb.append(date);// add the date
        sb.append(time);// add the time
        return sb.toString();

    }

}
