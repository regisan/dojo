package com.tr.dojo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PrincipalTest {

    Principal p;
    
    @Before
    public void setUp() {
        p = new Principal();
    }
    
    @Test
    public void testLigar1() {
        Corredor c = new Corredor(1);
        assertEquals("[on]", p.ligar(c));
    }
    
    @Test
    public void testLigar2() {
        Corredor c = new Corredor(2);
        assertEquals("[on, off]", p.ligar(c));
    }
    
    @Test
    public void testLigar3() {
        Corredor c = new Corredor(3);
        assertEquals("[on, off, off]", p.ligar(c));
    }
    
    @Test
    public void testLigar4() {
        Corredor c = new Corredor(4);
        assertEquals("[on, off, off, on]", p.ligar(c));
    }
}
