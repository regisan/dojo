package com.tr.dojo002;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RoletaRomanaTest {

	RoletaRomana rr;

	@Before
	public void init() {
		rr = new RoletaRomana();
	}

	@Test
	public void testeComCincoSuicidas() {
		assertEquals(3, rr.roleta(5, 2, 1));
	}

	@Test
	public void testeComDoisSuicidas() {
		// n, k, i
		assertEquals(1, rr.roleta(2, 2, 1));
	}

	@Test
	public void testeComTresSuicidas() {
		assertEquals(3, rr.roleta(3, 2, 1));
	}
	
	@Test
	public void testeComCinquentaSuicidas() {
		assertEquals(14, rr.roleta(50, 3, 10));
	}

	@Test
	public void testeEncontrarPessoaInicial() {
		Pessoa roda = rr.iniciaPessoas(5);
		assertEquals(3, rr.encontrarPessoaInicial(3, roda).posicao);
	}

	@Test
	public void testeEncontrarPessoaPosicaoK2IniciaEm1() {
		Pessoa roda = rr.iniciaPessoas(5);
		assertEquals(2, rr.encontrarPessoaEmKPosicao(2, roda).posicao);
	}

	@Test
	public void testeEncontrarPessoaPosicaoK2IniciaEm3() {
		Pessoa roda = rr.iniciaPessoas(5);
		roda = rr.encontrarPessoaInicial(3, roda);
		assertEquals(4, rr.encontrarPessoaEmKPosicao(2, roda).posicao);
	}

	@Test
	public void testeProcuraProximoVivo() {
		Pessoa roda = rr.iniciaPessoas(5);
		roda.morrer();
		roda.pessoaEsquerda.morrer();
		assertEquals(3, rr.procurarProximoVivo(roda).posicao);
	}

	@Test
	public void testeGetNumeroSobreviventes() {
		Pessoa roda = rr.iniciaPessoas(5);
		roda.morrer();
		roda.pessoaEsquerda.morrer();
		assertEquals(3, rr.getNumeroSobreviventes(roda, 5));
	}
}
