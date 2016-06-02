package com.tr.dojo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NumerosFelizesTest {

    NumerosFelizes nf;

    @Before
    public void init() {
        nf = new NumerosFelizes();
    }

    @Test
    public void testNumeroFeliz1() {
        assertTrue(nf.isHappy(1));
    }

    @Test
    public void testNumeroFeliz2() {
        assertFalse(nf.isHappy(2));
    }

    @Test
    public void testNumeroFeliz7() {
        assertTrue(nf.isHappy(7));
    }

    @Test
    public void testNumeroFeliz10() {
        assertTrue(nf.isHappy(10));
    }

    @Test
    public void testNumeroFeliz666() {
        assertFalse(nf.isHappy(666));
    }

    @Test
    public void testSomaQuadrados() {
        assertEquals(49, nf.somaQuadrados(7));
        assertEquals(4, nf.somaQuadrados(2));
        assertEquals(9, nf.somaQuadrados(3));
        assertEquals(1, nf.somaQuadrados(10));
    }
}
