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
    public void convert60() {
        Romanos r = new Romanos();
        assertEquals("LX", r.convert(60));
    }
    
    @Test
    public void convert70() {
        Romanos r = new Romanos();
        assertEquals("LXX", r.convert(70));
    }
    
    @Test
    public void convert80() {
        Romanos r = new Romanos();
        assertEquals("LXXX", r.convert(80));
    }
    
    @Test
    public void convert600() {
        Romanos r = new Romanos();
        assertEquals("DC", r.convert(600));
    }
    
    @Test
    public void convert700() {
        Romanos r = new Romanos();
        assertEquals("DCC", r.convert(700));
    }
    
    @Test
    public void convert800() {
        Romanos r = new Romanos();
        assertEquals("DCCC", r.convert(800));
    }
    
    @Test
    public void convert25() {
        Romanos r = new Romanos();
        assertEquals("XXV", r.convert(25));
    }
    
    @Test
    public void convert250() {
        Romanos r = new Romanos();
        assertEquals("CCL", r.convert(250));
    }
    
    @Test
    public void convert255() {
        Romanos r = new Romanos();
        assertEquals("CCLV", r.convert(255));
    }
    
    @Test
    public void convert258() {
        Romanos r = new Romanos();
        assertEquals("CCLVIII", r.convert(258));
    }
    
    @Test
    public void convert838() {
        Romanos r = new Romanos();
        assertEquals("DCCCXXXVIII", r.convert(838));
    }
    
    @Test
    public void convert4() {
        Romanos r = new Romanos();
        assertEquals("IV", r.convert(4));
    }
    
    @Test
    public void convert9() {
        Romanos r = new Romanos();
        assertEquals("IX", r.convert(9));
    }
    
    @Test
    public void convert99() {
        Romanos r = new Romanos();
        assertEquals("XCIX", r.convert(99));
    }
    
    @Test
    public void convert999() {
        Romanos r = new Romanos();
        assertEquals("CMXCIX", r.convert(999));
    }
    
    @Test
    public void convert444() {
        Romanos r = new Romanos();
        assertEquals("CDXLIV", r.convert(444));
    }
    
}
