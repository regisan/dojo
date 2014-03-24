package com.tr.dojo012;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LookAndSaySequenceTest {

    private LookAndSaySequence seq;
    
    @Before
    public void setUp() {
        seq = new LookAndSaySequence(1);
           
    }
    
    @Test
    public void testSay1() {
        assertEquals("11", seq.say("1"));
    }
    
    @Test
    public void testSay11() {
        assertEquals("21", seq.say("11"));
    }
    
    @Test
    public void testSay111() {
        assertEquals("31", seq.say("111"));
    }
    
    @Test
    public void testSay1211() {
        assertEquals("111221", seq.say("1211"));
    }
    
    @Test
    public void testSay111221() {
        assertEquals("312211", seq.say("111221"));
    }
    
    @Test
    public void testSum() {
        assertEquals(2, seq.sum(1));
    }
    
    @Test
    public void testSum2() {
        assertEquals(3, seq.sum(2));
    }
    
    @Test
    public void testSum3() {
        assertEquals(5, seq.sum(3));
    }
    
    @Test
    public void testSum4() {
        assertEquals(8, seq.sum(4));
    }
    
    @Test
    public void testSum5() {
        assertEquals(10, seq.sum(5));
    }
    
    @Test
    public void testSumStartingIn2() {
        seq = new LookAndSaySequence(2);        
        assertEquals(15, seq.sum(5));
    }
    
    @Test(expected = InvalidNumberException.class)
    public void testInvalidStartNumber() {
        seq = new LookAndSaySequence(0);        
    }
    
    @Test
    public void testSum50() {
        assertEquals(1970964, seq.sum(50));
    }
    
}
