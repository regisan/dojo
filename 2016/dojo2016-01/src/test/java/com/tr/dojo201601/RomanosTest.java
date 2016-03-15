package com.tr.dojo201601;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanosTest {

    @Test
    public void convert1() {
        Romanos r = new Romanos();
        assertEquals("I", r.convert(1));
    }
    
    @Test
    public void convert5() {
        Romanos r = new Romanos();
        assertEquals("V", r.convert(5));
    }
    
    @Test
    public void convert10() {
        Romanos r = new Romanos();
        assertEquals("X", r.convert(10));
    }
    
    @Test
    public void convert50() {
        Romanos r = new Romanos();
        assertEquals("L", r.convert(50));
    }
    
    @Test
    public void convert100() {
        Romanos r = new Romanos();
        assertEquals("C", r.convert(100));
    }
    
    @Test
    public void convert500() {
        Romanos r = new Romanos();
        assertEquals("D", r.convert(500));
    }
    
    
    @Test
    public void convert1000() {
        Romanos r = new Romanos();
        assertEquals("M", r.convert(1000));
    }    
    
    @Test
    public void convert2() {
        Romanos r = new Romanos();
        assertEquals("II", r.convert(2));
    }

    @Test
    public void convert3() {
        Romanos r = new Romanos();
        assertEquals("III", r.convert(3));
    }

    @Test
    public void convert20() {
        Romanos r = new Romanos();
        assertEquals("XX", r.convert(20));
    }

    @Test
    public void convert30() {
        Romanos r = new Romanos();
        assertEquals("XXX", r.convert(30));
    }
    
    @Test
    public void convert200() {
        Romanos r = new Romanos();
        assertEquals("CC", r.convert(200));
    }
    
    @Test
    public void convert300() {
        Romanos r = new Romanos();
        assertEquals("CCC", r.convert(300));
    }
    
    @Test
    public void convert6() {
        Romanos r = new Romanos();
        assertEquals("VI", r.convert(6));
    }
    
    @Test
    public void convert7() {
        Romanos r = new Romanos();
        assertEquals("VII", r.convert(7));
    }
    
    @Test
    public void convert8() {
        Romanos r = new Romanos();
        assertEquals("VIII", r.convert(8));
    }
    
    @Test
    public void convert25() {
        Romanos r = new Romanos();
        assertEquals("XXV", r.convert(25));
    }
    
}
