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
    
//    @Test
//    public void matriz3x3() {
//        int [][] matriz = {{1,2,3},{8,9,4},{7,6,5}};
//        
//        assertArrayEquals(matriz, mat.espiral(3, 3));
//               
//    }
}
