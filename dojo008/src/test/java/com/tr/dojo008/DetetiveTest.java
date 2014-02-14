package com.tr.dojo008;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DetetiveTest {

	Detetive detetive;

	@Before
	public void setUp() {
		detetive = new Detetive(1, 1, 1);
	}

	@Test
	public void testAcusar() {
		Assert.assertEquals(0, detetive.acusar(1, 1, 1));
	}

	@Test
	public void testeSuspeitoErrado() {

		Assert.assertEquals(1, detetive.acusar(2, 1, 1));
	}

	@Test
	public void testeLocalErrado() {

		Assert.assertEquals(2, detetive.acusar(1, 2, 1));
	}

	@Test
	public void testeLocalEArmaErrados() {
		Set<Integer> resultadosPossiveis = new HashSet<>();
		resultadosPossiveis.add(2);
		resultadosPossiveis.add(3);
		Assert.assertTrue(resultadosPossiveis.contains(detetive
				.acusar(1, 10, 4)));
	}

	@Test
	public void testeGerarNumeroAleatorioComPossibilidades() {
		Set<Integer> resultadosPossiveis = new HashSet<>();
		resultadosPossiveis.add(1);
		resultadosPossiveis.add(2);
		resultadosPossiveis.add(3);
		Assert.assertTrue(resultadosPossiveis.contains(detetive
				.gerarRespostaAleatoria(resultadosPossiveis)));
	}

	@Test
	public void testeGerarNumeroAleatorioCom2Possibilidades() {
		Set<Integer> resultadosPossiveis = new HashSet<>();
		resultadosPossiveis.add(2);
		resultadosPossiveis.add(3);
		Assert.assertTrue(resultadosPossiveis.contains(detetive
				.gerarRespostaAleatoria(resultadosPossiveis)));
	}
	
	@Test
	public void testeAcharMisterioAvancado() {
		Detetive detetive = new Detetive(5, 2, 3);
		
		List<Integer> resultadosMisterio = new ArrayList<>();
		resultadosMisterio.add(5);
		resultadosMisterio.add(2);
		resultadosMisterio.add(3);
		System.out.println("Teste 5, 2 3");
		Assert.assertEquals(resultadosMisterio, detetive.procurar());
	}
	
	@Test
	public void testeMaximoListas() {
		Detetive detetive = new Detetive(10, 10, 10);
		
		List<Integer> resultadosMisterio = new ArrayList<>();
		resultadosMisterio.add(10);
		resultadosMisterio.add(10);
		resultadosMisterio.add(10);
		System.out.println("Teste 10, 10, 10");
		Assert.assertEquals(resultadosMisterio, detetive.procurar());
	}
}

