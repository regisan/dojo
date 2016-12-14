package com.tr.dojo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LivrariaTest {
    
    Livraria liv;
    int livros[] = new int[7];

    @Before
    public void setUp() {
        liv = new Livraria();
    }
    
    @Test
    public void desconto1Livro() {
        
        livros[0] = 1;
        assertEquals(42.0, liv.calcular(livros), 0.1);
    }
    
    @Test
    public void desconto2Livros() {
        livros[0] = 2;
        assertEquals(84.0, liv.calcular(livros), 0.1);
    }

    @Test
    public void desconto2LivrosDistintos() {
        livros[0] = 1;
        livros[1] = 1;
        assertEquals(79.8, liv.calcular(livros), 0.1);
    }
    
    @Test
    public void desconto3LivrosDistintos() {
        livros[0] = 1;
        livros[1] = 1;
        livros[2] = 1;
        assertEquals(113.4, liv.calcular(livros), 0.1);
    }
    
    @Test
    public void desconto4LivrosDistintos() {
        livros[0] = 1;
        livros[1] = 1;
        livros[2] = 1;
        livros[3] = 1;
        assertEquals(142.8, liv.calcular(livros), 0.1);
    }
    
    @Test
    public void desconto5LivrosDistintos() {
        livros[0] = 1;
        livros[1] = 1;
        livros[2] = 1;
        livros[3] = 1;
        livros[6] = 1;
        assertEquals(168, liv.calcular(livros), 0.1);
    }
    
    @Test
    public void desconto3Livros2Iguais(){
        livros[0] = 2;
        livros[1] = 1;
        assertEquals(121.8, liv.calcular(livros), 0.1);
    }
    
    @Test
    public void desconto4Livros3Iguais(){
        livros[0] = 3;
        livros[1] = 1;
        assertEquals(163.8, liv.calcular(livros), 0.1);
    }
    
    @Test
    public void descontoProblema() {
        livros[0] = 2;
        livros[1] = 2;
        
        assertEquals(159.6, liv.calcular(livros), 0.1);
    }
}
