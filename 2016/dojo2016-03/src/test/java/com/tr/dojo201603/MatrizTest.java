package com.tr.dojo201603;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MatrizTest {

    Matriz mat;
    
    @Before
    public void init(){
        
        mat = new Matriz();
    }
    
    @Test
    public void matriz2x2() {
        int [][] matriz = {{1,2},{4,3}};
        
        assertArrayEquals(matriz, mat.espiral(2, 2));
               
    }

    @Test
    public void matriz2x3() {
        int [][] matriz = {{1,2,3},{6,5,4}};
        
        assertArrayEquals(matriz, mat.espiral(2, 3));
               
    }
    
    @Test
    public void matriz3x2() {
        int [][] matriz = {{1,2},{6,3},{5,4}};
        
        assertArrayEquals(matriz, mat.espiral(3, 2));
               
    }
    
    @Test
    public void matriz3x3() {
        int [][] matriz = {{1,2,3},{8,9,4},{7,6,5}};
        
        assertArrayEquals(matriz, mat.espiral(3, 3));
               
    }
    
    @Test
    public void matriz4x3() {
        int [][] matriz = {{1,2,3},{10,11,4},{9,12,5}, {8,7,6}};
        
        assertArrayEquals(matriz, mat.espiral(4, 3));
               
    }
    
    @Test
    public void matriz6x5() {
        int [][] matriz = {
                { 1, 2, 3, 4, 5},
                {18,19,20,21, 6},
                {17,28,29,22, 7},
                {16,27,30,23, 8},
                {15,26,25,24, 9},
                {14,13,12,11,10}};
        
        assertArrayEquals(matriz, mat.espiral(6, 5));
               
    }
}
