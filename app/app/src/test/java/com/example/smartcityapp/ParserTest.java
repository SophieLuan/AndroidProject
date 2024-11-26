package com.example.smartcityapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.smartcityapp.Search.EXP;
import com.example.smartcityapp.Search.Parser;
import com.example.smartcityapp.Search.Tokenizer;
import com.example.smartcityapp.loadData.DataActivity;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test an activity's type, participants, and date separately, in pairs, and in groups of three.
 * @author Zhizhao Sun(u7799455), Ziang Wang(u7748243)
 */

public class ParserTest {
    @Test(timeout=1000)
    public void testActivity(){
        String s = "type=social AND participants=2 AND date=1105";
        Tokenizer tokenizer = new Tokenizer(s);
        DataActivity activity=new DataActivity("sleep","social",2,"1111","1105");
        Parser parser = new Parser(tokenizer);
        EXP expression = parser.parseExp();
        assertEquals("type=socialANDparticipants=2ANDdate=1105",expression.show());
        assertTrue(expression.evaluate(activity));
    }
    @Test(timeout=1000)
    public void testInvalidInput(){
        String s = "type=social AND invalidInput=2 AND date=1105";
        Tokenizer tokenizer = new Tokenizer(s);
        DataActivity activity=new DataActivity("sleep","social",2,"1111","1105");
        Parser parser = new Parser(tokenizer);
        EXP expression = parser.parseExp();
        assertEquals("type=socialANDdate=1105",expression.show());
        assertTrue(expression.evaluate(activity));
    }



    @Test(timeout=1000)
    public void testOrMatch(){
        String s = "type=social OR type=relaxation";
        DataActivity activity1=new DataActivity("sleep","social",2,"1111","1105");
        DataActivity activity2=new DataActivity("sleep","relaxation",2,"1111","1105");
        List<DataActivity> list=new ArrayList<>();
        list.add(activity1);
        list.add(activity2);
        for(DataActivity a:list){
            Tokenizer tokenizer = new Tokenizer(s);
            Parser parser = new Parser(tokenizer);
            EXP expression = parser.parseExp();
            assertEquals("type=socialORtype=relaxation", expression.show());
            assertTrue(expression.evaluate(a));
        }
    }

    @Test(timeout=1000)
    public void testMeditateMatch(){
        String s = "type=relaxation AND participants=1 AND date=1103";
        Tokenizer tokenizer = new Tokenizer(s);
        DataActivity activity = new DataActivity("Meditate for five minutes", "relaxation", 1, "1554", "1103");
        Parser parser = new Parser(tokenizer);
        EXP expression = parser.parseExp();
        assertEquals("type=relaxationANDparticipants=1ANDdate=1103", expression.show());
        assertTrue(expression.evaluate(activity));
    }

    @Test(timeout=1000)
    public void testUninstallMatch(){
        String s = "type=busywork AND participants=1 AND date=1111";
        Tokenizer tokenizer = new Tokenizer(s);
        DataActivity activity = new DataActivity("Uninstall unused apps from your devices", "busywork", 1, "0808", "1111");
        Parser parser = new Parser(tokenizer);
        EXP expression = parser.parseExp();
        assertEquals("type=busyworkANDparticipants=1ANDdate=1111", expression.show());
        assertTrue(expression.evaluate(activity));
    }


    @Test(timeout=1000)
    public void testNotMatch(){
        String s = "type=social AND participants=2 AND date=1105";
        Tokenizer tokenizer = new Tokenizer(s);
        DataActivity activity=new DataActivity("sleep","busywork",2,"1111","1105");
        Parser parser = new Parser(tokenizer);
        EXP expression = parser.parseExp();
        assertEquals("type=socialANDparticipants=2ANDdate=1105",expression.show());
        assertFalse(expression.evaluate(activity));
    }

    @Test(timeout=1000)
    public void testGreetTypeNotMatch(){
        String s = "type=relaxation AND participants=1 AND date=1208";
        Tokenizer tokenizer = new Tokenizer(s);
        DataActivity activity = new DataActivity("Learn to greet someone in a new language", "education", 1, "1855", "1208");
        Parser parser = new Parser(tokenizer);
        EXP expression = parser.parseExp();
        assertEquals("type=relaxationANDparticipants=1ANDdate=1208", expression.show());
        assertFalse(expression.evaluate(activity));
    }

    @Test(timeout=1000)
    public void testGreetParticipantsNotMatch(){
        String s = "type=relaxation AND participants=1 AND date=1208";
        Tokenizer tokenizer = new Tokenizer(s);
        DataActivity activity = new DataActivity("Learn to greet someone in a new language", "relaxation", 2, "1855", "1208");
        Parser parser = new Parser(tokenizer);
        EXP expression = parser.parseExp();
        assertEquals("type=relaxationANDparticipants=1ANDdate=1208", expression.show());
        assertFalse(expression.evaluate(activity));
    }

    @Test(timeout=1000)
    public void testGreetDateNotMatch(){
        String s = "type=relaxation AND participants=1 AND date=1208";
        Tokenizer tokenizer = new Tokenizer(s);
        DataActivity activity = new DataActivity("Learn to greet someone in a new language", "relaxation", 1, "1855", "1288");
        Parser parser = new Parser(tokenizer);
        EXP expression = parser.parseExp();
        assertEquals("type=relaxationANDparticipants=1ANDdate=1208", expression.show());
        assertFalse(expression.evaluate(activity));
    }

    @Test(timeout=1000)
    public void testGreetTypeAndParticipantsNotMatch(){
        String s = "type=relaxation AND participants=1 AND date=1208";
        Tokenizer tokenizer = new Tokenizer(s);
        DataActivity activity = new DataActivity("Learn to greet someone in a new language", "education", 2, "1855", "1208");
        Parser parser = new Parser(tokenizer);
        EXP expression = parser.parseExp();
        assertEquals("type=relaxationANDparticipants=1ANDdate=1208", expression.show());
        assertFalse(expression.evaluate(activity));
    }

    @Test(timeout=1000)
    public void testGreetTypeAndDateNotMatch(){
        String s = "type=relaxation AND participants=1 AND date=1208";
        Tokenizer tokenizer = new Tokenizer(s);
        DataActivity activity = new DataActivity("Learn to greet someone in a new language", "education", 1, "1855", "1288");
        Parser parser = new Parser(tokenizer);
        EXP expression = parser.parseExp();
        assertEquals("type=relaxationANDparticipants=1ANDdate=1208", expression.show());
        assertFalse(expression.evaluate(activity));
    }

    @Test(timeout=1000)
    public void testGreetParticipantsAndDateNotMatch(){
        String s = "type=relaxation AND participants=1 AND date=1208";
        Tokenizer tokenizer = new Tokenizer(s);
        DataActivity activity = new DataActivity("Learn to greet someone in a new language", "relaxation", 2, "1855", "1288");
        Parser parser = new Parser(tokenizer);
        EXP expression = parser.parseExp();
        assertEquals("type=relaxationANDparticipants=1ANDdate=1208", expression.show());
        assertFalse(expression.evaluate(activity));
    }

    @Test(timeout=1000)
    public void testGreetTypeAndParticipantsAndDateNotMatch(){
        String s = "type=relaxation AND participants=1 AND date=1208";
        Tokenizer tokenizer = new Tokenizer(s);
        DataActivity activity = new DataActivity("Learn to greet someone in a new language", "education", 2, "1855", "1288");
        Parser parser = new Parser(tokenizer);
        EXP expression = parser.parseExp();
        assertEquals("type=relaxationANDparticipants=1ANDdate=1208", expression.show());
        assertFalse(expression.evaluate(activity));
    }
    
}
