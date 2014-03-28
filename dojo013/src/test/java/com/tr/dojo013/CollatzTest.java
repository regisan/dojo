package com.tr.dojo013;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CollatzTest {
    
    private Collatz c;
    
    @Before
    public void setUp() {
        c = new Collatz();
    }
    
    @Test
    public void testaPar() {
        assertTrue(c.isPar(2));
    }
    
    @Test
    public void testaProximo2() {
        assertEquals(1, c.calcularProximo(2));
    }
    
    @Test
    public void testaProximo1() {
        assertEquals(4, c.calcularProximo(1));
    }
    
    @Test
    public void testaProximo3() {
        assertEquals(10, c.calcularProximo(3));
    }

    @Test
    public void testaTamanhoSequencia2() {
        assertEquals(2, c.getTamanhoSequencia(2));
    }
    
    @Test
    public void testaTamanhoSequencia1() {
        assertEquals(4, c.getTamanhoSequencia(1));
    }
    
    @Test
    public void testaTamanhoSequencia3() {
        assertEquals(8, c.getTamanhoSequencia(3));
    }
    
    @Test
    public void testaTamanhoSequencia7() {
        assertEquals(17, c.getTamanhoSequencia(7));
    }
    
    @Test
    public void testaTamanhoSequencia13() {
        assertEquals(10, c.getTamanhoSequencia(13));
    }
    
    @Test
    public void testGetMaiorSequencia1E2() {
        assertEquals(1, c.getMaiorSequencia(1, 2));
    }

    @Test
    public void testGetMaiorSequencia1E13() {
        assertEquals(9, c.getMaiorSequencia(1, 13));
    }

    @Test
    public void testGetMaiorSequencia1E1000000() {
        assertEquals(626331, c.getMaiorSequencia(1, 1000000));
    }
    
    @Test
    public void testaTamanhoSequencia626331() {
        assertEquals(509, c.getTamanhoSequencia(626331));
    }

}
