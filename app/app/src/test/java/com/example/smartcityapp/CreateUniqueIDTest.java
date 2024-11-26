package com.example.smartcityapp;

import static org.junit.Assert.assertEquals;

import com.example.smartcityapp.Search.CreateUniqueID;
import com.example.smartcityapp.loadData.DataActivity;

import org.junit.Test;

public class CreateUniqueIDTest {
    @Test(timeout=1000)
    public void testId(){
        DataActivity activity=new DataActivity("catch up with friends","social",2,"1523","1120");
        String s=CreateUniqueID.createID(activity.getType(),activity.getParticipants(),activity.getDate(),activity.getTime());
        assertEquals("soc211201523",s);
    }
}
