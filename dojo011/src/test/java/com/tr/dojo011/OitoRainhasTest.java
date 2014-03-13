package com.tr.dojo011;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OitoRainhasTest {

    private OitoRainhas or;

    @Before
    public void setUp() {

    }

    @Test
    public void testValidarLinha() {
        or = new OitoRainhas(4);
        assertTrue(or.validarHorizontal(0));
    }

    @Test
    public void testValidarColuna() {
        or = new OitoRainhas(4);
        assertTrue(or.validarHorizontal(0));
    }

    @Test
    public void testValidarDiagonalDireita() {
        or = new OitoRainhas(4);
        assertTrue(or.validarDiagonalDireita(0, 0));
    }
    
    @Test
    public void testValidarDiagonalEsquerda() {
        or = new OitoRainhas(4);
        assertTrue(or.validarDiagonalEsquerda(0, 0));
    }

    @Test
    public void testPosicionarRainha() {
        or = new OitoRainhas(4);
        assertTrue(or.posicionarRainha(3, 1));
    }

    @Test
    public void testPosicionar2RainhasFalse() {
        or = new OitoRainhas(4);
        or.posicionarRainha(3, 1);
        assertFalse(or.posicionarRainha(2, 0));
    }

    @Test
    public void testPosicionar2RainhasTrue() {
        or = new OitoRainhas(4);
        or.posicionarRainha(0, 1);
        assertTrue(or.posicionarRainha(1, 3));
    }

    @Test
    public void testPosicionar3RainhasTrue() {
        or = new OitoRainhas(4);
        or.posicionarRainha(1, 0);
        or.posicionarRainha(3, 1);
        assertTrue(or.posicionarRainha(0, 2));
    }

    @Test
    public void testPosicionar3RainhasFalse() {
        or = new OitoRainhas(4);
        or.posicionarRainha(1, 0);
        or.posicionarRainha(3, 1);
        assertFalse(or.posicionarRainha(0, 1));
    }

    @Test
    public void testPosicionar4RainhasFalse() {
        or = new OitoRainhas(4);
        or.posicionarRainha(1, 0);
        or.posicionarRainha(3, 1);
        or.posicionarRainha(0, 2);
        assertFalse(or.posicionarRainha(3, 1));
    }

    @Test
    public void testPosicionar4RainhasTrue() {
        or = new OitoRainhas(4);
        or.posicionarRainha(1, 0);
        or.posicionarRainha(3, 1);
        or.posicionarRainha(0, 2);
        assertTrue(or.posicionarRainha(2, 3));
    }

    @Test
    public void testPreencherTabuleiro() {
        assertTrue(or.preencherTabuleiro());
    }
}
