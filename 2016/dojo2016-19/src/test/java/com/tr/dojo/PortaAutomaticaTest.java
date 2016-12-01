package com.tr.dojo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PortaAutomaticaTest {
    
    PortaAutomatica pa;
    
    @Before
    public void setUp() {
        pa = new PortaAutomatica();
    }

    @Test
    public void test() {
        
        //"[YYYY-mm-dd H:i:s]"
        
        String[] entrada = {"[2016-12-01 11:31:00]",
                "[2016-12-01 11:31:00]"};
        
        assertEquals(2, pa.analisarRegistros(entrada));
        
    }
    
    @Test
    public void testUmaHoraInvalida() {
        
        //"[YYYY-mm-dd H:i:s]"
        
        String[] entrada = {"[2016-12-01 11:31:00]",
                "[2016-12-01 17:00:00]"};
        
        assertEquals(1, pa.analisarRegistros(entrada));
        
    }
    
    @Test
    public void testUmMinutoInvalido() {
        
        //"[YYYY-mm-dd H:i:s]"
        
        String[] entrada = {"[2016-12-01 11:31:00]",
                "[2016-12-01 16:30:00]"};
        
        assertEquals(1, pa.analisarRegistros(entrada));
        
    }
    @Test
    public void testUmMinutoInvalido2() {
        
        //"[YYYY-mm-dd H:i:s]"
        
        String[] entrada = {"[2016-12-01 11:31:00]",
                "[2016-12-01 09:30:00]"};
        
        assertEquals(1, pa.analisarRegistros(entrada));
        
    }

    @Test
    public void testSegundoInvalido() {
        
        //"[YYYY-mm-dd H:i:s]"
        
        String[] entrada = {"[2016-12-01 16:00:30]",
                "[2016-12-01 09:30:00]"};
        
        assertEquals(0, pa.analisarRegistros(entrada));
        
    }

    @Test
    public void testMaisEntradas() {
        
        //"[YYYY-mm-dd H:i:s]"
        
        String[] entrada = {"[2016-12-01 16:00:01]",
                "[Erro de abertura]",
                "[2016-12-01 12:30:00]"};
        
        assertEquals(1, pa.analisarRegistros(entrada));
        
    }
    
    @Test
    public void testValidaData() {
        
        //"[YYYY-mm-dd H:i:s]"
        
        String entrada ="[2016-12-01 16:00:01]";
        
        assertTrue(pa.isValida(entrada));
        
    }
    
    @Test
    public void testValidaDataErro() {
        
        //"[YYYY-mm-dd H:i:s]"
        
        String entrada ="Weberton";
        
        assertFalse(pa.isValida(entrada));
        
    }

    
    @Test
    public void testQuebra() {
        
        //"[YYYY-mm-dd H:i:s]"
        
        String[] entrada = {"[2016-12-01 16:00:01]",
                "[Erro 102030 de abertura 2010]",
                "[2016-12-01 12:30:00]"};
        
        assertEquals(1, pa.analisarRegistros(entrada));
        
    }
    
}
