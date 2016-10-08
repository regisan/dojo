package com.tr.dojo;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tr.dojo.ProdutoEscalar;
import com.tr.dojo.VetoresTamanhosDiferentesException;

public class ProdutoEscalarTest 
{
    ProdutoEscalar pe = new ProdutoEscalar();
    
    @Test
    public void calcularVetorUnitario() {        int[] a = {2};
        int[] b = {3};
        
        assertEquals(6, pe.calcular(a, b));

    }
    
    @Test
    public void calcularVetorTamanho2() {
        int[] a = {2, 3};
        int[] b = {3, 3};
        
        assertEquals(15, pe.calcular(a, b));

    }
    
    @Test
    public void calcularVetorTamanho3() {
        int[] a = {1, 1, 1};
        int[] b = {1, 1, 1};
        
        assertEquals(3, pe.calcular(a, b));

    }
    
    @Test
    public void calcularVetorTamanho4() {
        int[] a = {1, 2, 3, 4};
        int[] b = {5, 6, 7, 8};
        
        assertEquals(70, pe.calcular(a, b));

    }
    
    @Test
    public void calcularVetorTamanho5() {
        int[] a = {1, 2, 3, 4, 0};
        int[] b = {5, 6, 7, 0, 9};
        
        assertEquals(38, pe.calcular(a, b));

    }
    
    @Test(expected=VetoresTamanhosDiferentesException.class)
    public void calcularVetorTamanhosDiferentes() {
        int[] a = {1, 2, 3, 4, 0};
        int[] b = {5};
        
        pe.calcular(a, b);

    }
}
