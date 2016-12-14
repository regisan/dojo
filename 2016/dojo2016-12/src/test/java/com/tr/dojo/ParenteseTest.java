package com.tr.dojo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParenteseTest {

    Parentese p = new Parentese();
    
    @Test
    public void testTrueAndTrue() {
        assertEquals(1, p.avaliar("true and true"));
    }

    @Test
    public void testTrueOrTrue() {
        assertEquals(1, p.avaliar("true or true"));
    }
    
    @Test
    public void testTrueOrFalse() {
        assertEquals(1, p.avaliar("true or false"));
    }
    
    @Test
    public void testFalseOrFalse() {
        assertEquals(0, p.avaliar("false and false"));
    }
    
    @Test
    public void testFalseAndFalseOrTrue() {
        assertEquals(1, p.avaliar("false and false or true"));
    }

    @Test
    public void testTrueOrFalseAndTrue() {
        assertTrue(true || false && true);
        assertEquals(1, p.avaliar("true or false and true"));
    }
}
