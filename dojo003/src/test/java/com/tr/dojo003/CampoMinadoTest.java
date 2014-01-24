package com.tr.dojo003;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CampoMinadoTest {

	private CampoMinado campoMinado;

	@Before
	public void setUp() {
		campoMinado = new CampoMinado();
	}

	@Test
	public void testResolverCampoMinado1x2() {
		List<Coordenada> coordenadas = new ArrayList<>();
		coordenadas.add(new Coordenada(0,0));
		
		int[][] matriz = campoMinado.resolverCampoMinado(1,2, coordenadas);
		int[][] matrizResult = new int[1][2];
		matrizResult[0][0] = -1;
		matrizResult[0][1] = 1;
		assertArrayEquals(matrizResult, matriz);
	}
	
	@Test
	public void testResolverCampoMinado2x2Com1Bomba() {
		List<Coordenada> coordenadas = new ArrayList<>();
		coordenadas.add(new Coordenada(0,0));
		
		int[][] matriz = campoMinado.resolverCampoMinado(2,2, coordenadas);
		int[][] matrizResult = new int[2][2];
		matrizResult[0][0] = -1;
		matrizResult[0][1] = 1;
		matrizResult[1][0] = 1;
		matrizResult[1][1] = 1;
		assertArrayEquals(matrizResult, matriz);
	}
	
	@Test
	public void testResolverCampoMinado2x2Com2Bombas() {
		List<Coordenada> coordenadas = new ArrayList<>();
		coordenadas.add(new Coordenada(0,0));
		coordenadas.add(new Coordenada(1,1));
		
		int[][] matriz = campoMinado.resolverCampoMinado(2,2, coordenadas);
		int[][] matrizResult = new int[2][2];
		matrizResult[0][0] = -1;
		matrizResult[0][1] = 2;
		matrizResult[1][0] = 2;
		matrizResult[1][1] = -1;
		assertArrayEquals(matrizResult, matriz);
	}

	@Test
	public void testResolverCampoMinado3x3Com2Bombas() {
		List<Coordenada> coordenadas = new ArrayList<>();
		coordenadas.add(new Coordenada(0,0));
		coordenadas.add(new Coordenada(1,0));
		
		int[][] matriz = campoMinado.resolverCampoMinado(3,3, coordenadas);
		int[][] matrizResult = new int[3][3];
		matrizResult[0][0] = -1;
		matrizResult[0][1] = 2;
		matrizResult[0][2] = 0;
		matrizResult[1][0] = -1;
		matrizResult[1][1] = 2;
		matrizResult[1][2] = 0;
		matrizResult[2][0] = 1;
		matrizResult[2][1] = 1;
		matrizResult[2][2] = 0;
		assertArrayEquals(matrizResult, matriz);
	}

	@Test
	public void testIsForaDoRange() {
		Coordenada c = new Coordenada(-1,0);
		Assert.assertTrue(c.isForaDoRange(1,1));
	
	}

	@Test
	public void testRecebeMatrizPrinta() {
		List<Coordenada> coordenadas = new ArrayList<>();
		coordenadas.add(new Coordenada(0,0));
		
		int[][] matriz = campoMinado.resolverCampoMinado(1,2, coordenadas);
		String imprimeMatriz = campoMinado.imprimeMatriz(matriz,1,2);
		assertEquals("* 1 \n", imprimeMatriz);
		
	}

}
