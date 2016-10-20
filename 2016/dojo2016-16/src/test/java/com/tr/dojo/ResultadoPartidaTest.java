package com.tr.dojo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResultadoPartidaTest {
         
    @Test
    public void testClassificado() {
       Partida partida = new Partida("Juventude",2,"Sao Paulo", 1);
       Partida partida2 = new Partida("Sao Paulo", 0, "Juventude", 0);

       ResultadoPartida resultado = new ResultadoPartida(partida, partida2);
       
        assertEquals("Juventude", resultado.analisar());
    }
    
    @Test
    public void testClassificadoPenalti() {
       Partida partida = new Partida("A",0,"B", 0);
       Partida partida2 = new Partida("B", 0, "A", 0);

       ResultadoPartida resultado = new ResultadoPartida(partida, partida2);
       
        assertEquals("Penalti", resultado.analisar());
    }
    
    @Test
    public void testClassificadoGolFora() {
       Partida partida = new Partida("A",0,"B", 0);
       Partida partida2 = new Partida("B", 1, "A", 1);

       ResultadoPartida resultado = new ResultadoPartida(partida, partida2);
       
        assertEquals("A", resultado.analisar());
    }
    
    @Test
    public void testClassificadoPalmares() {
       Partida partida = new Partida("Gremio",2,"Palmeiras", 1);
       Partida partida2 = new Partida("Palmeiras", 1, "Gremio", 1);

       ResultadoPartida resultado = new ResultadoPartida(partida, partida2);
       
        assertEquals("Gremio", resultado.analisar());
    }
    
    @Test
    public void testClassificadoCruzeiro() {
       Partida partida = new Partida("Curica",2,"Cruzeiro", 1);
       Partida partida2 = new Partida("Cruzeiro", 4, "Curica", 2);

       ResultadoPartida resultado = new ResultadoPartida(partida, partida2);
       
        assertEquals("Cruzeiro", resultado.analisar());
    }
    
    @Test
    public void testClassificadoCuricaComAjudaDoJuiz() {
       Partida partida = new Partida("Curica",2,"Cruzeiro", 1);
       Partida partida2 = new Partida("Cruzeiro", 3, "Curica", 2);

       ResultadoPartida resultado = new ResultadoPartida(partida, partida2);
       
        assertEquals("Curica", resultado.analisar());
    }

    @Test
    public void testClassificadoPenaltiComGols() {
       Partida partida = new Partida("A",3,"B", 1);
       Partida partida2 = new Partida("B", 3, "A", 1);

       ResultadoPartida resultado = new ResultadoPartida(partida, partida2);
       
        assertEquals("Penalti", resultado.analisar());
    }
    
    @Test
    public void testClassificadoInter() {
       Partida partida = new Partida("Santos", 2,"Inter", 1);
       Partida partida2 = new Partida("Inter", 2, "Santos", 0);

       ResultadoPartida resultado = new ResultadoPartida(partida, partida2);
       
        assertEquals("Inter", resultado.analisar());
    }
}
