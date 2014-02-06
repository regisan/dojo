package com.tr.dojo006;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PokerTest {
	
	Poker poker;

	@Before
	public void setUp() {
		poker = new Poker();
	}

	@Test
	public void testCartaMaior() {
		Carta carta1 = new Carta(5, "D"); 
		Carta carta2 = new Carta(14, "C"); 
		assertEquals(carta2, poker.getCartaMaior(carta1, carta2));
	}
	
	@Test
	public void testPar() {
		List<Carta> cartas = new ArrayList<Carta> ();
		cartas.add(new Carta(5, "D"));
		cartas.add(new Carta(5, "C"));
		Mao jogador1 = new Mao(cartas);
		assertTrue(jogador1.isPar());
	}

	@Test
	public void testNaoPar() {
		List<Carta> cartas = new ArrayList<Carta> ();
		cartas.add(new Carta(7, "D"));
		cartas.add(new Carta(11, "C"));
		Mao jogador1 = new Mao(cartas);
		assertFalse(jogador1.isPar());
	}

	@Test
	public void testTrinca() {
		List<Carta> cartas = new ArrayList<Carta> ();
		cartas.add(new Carta(5, "D"));
		cartas.add(new Carta(5, "C"));
		cartas.add(new Carta(5, "H"));
		Mao jogador1 = new Mao(cartas);
		assertTrue(jogador1.isTrinca());
	}

	@Test
	public void testNaoTrinca() {
		List<Carta> cartas = new ArrayList<Carta> ();
		cartas.add(new Carta(5, "D"));
		cartas.add(new Carta(8, "C"));
		cartas.add(new Carta(1, "H"));
		Mao jogador1 = new Mao(cartas);
		assertFalse(jogador1.isTrinca());
	}

	@Test
	public void testTresCartasComPar() {
		List<Carta> cartas = new ArrayList<Carta> ();
		cartas.add(new Carta(5, "D"));
		cartas.add(new Carta(5, "C"));
		cartas.add(new Carta(8, "H"));
		Mao jogador1 = new Mao(cartas);
		assertFalse(jogador1.isTrinca());
		assertTrue(jogador1.isPar());
	}

	@Test
	public void testTresCartasComParNoFim() {
		List<Carta> cartas = new ArrayList<Carta> ();
		cartas.add(new Carta(8, "C"));
		cartas.add(new Carta(5, "D"));
		cartas.add(new Carta(8, "H"));
		
		Mao jogador1 = new Mao(cartas);
		assertFalse(jogador1.isTrinca());
		assertTrue(jogador1.isPar());
	}
	
	@Test
	public void test4CartasComTrinca() {
		List<Carta> cartas = new ArrayList<Carta> ();
		cartas.add(new Carta(8, "C"));
		cartas.add(new Carta(5, "D"));
		cartas.add(new Carta(8, "H"));
		cartas.add(new Carta(8, "D"));
		
		Mao jogador1 = new Mao(cartas);
		assertTrue(jogador1.isTrinca());
		assertTrue(jogador1.isPar());
	}

	@Test
	public void test4CartasCom2Pares() {
		List<Carta> cartas = new ArrayList<Carta> ();
		cartas.add(new Carta(8, "C"));
		cartas.add(new Carta(5, "D"));
		cartas.add(new Carta(8, "H"));
		cartas.add(new Carta(5, "S"));
		
		Mao jogador1 = new Mao(cartas);
		assertTrue(jogador1.is2Par());
	}

	@Test
	public void test5CartasCom2Pares() {
		List<Carta> cartas = new ArrayList<Carta> ();
		cartas.add(new Carta(8, "C"));
		cartas.add(new Carta(5, "D"));
		cartas.add(new Carta(13, "H"));
		cartas.add(new Carta(8, "H"));
		cartas.add(new Carta(5, "S"));
		
		Mao jogador1 = new Mao(cartas);
		assertTrue(jogador1.is2Par());
	}

	@Test
	public void testSequencia() {
		List<Carta> cartas = new ArrayList<Carta> ();
		cartas.add(new Carta(8, "C"));
		cartas.add(new Carta(9, "D"));
		cartas.add(new Carta(10, "H"));
		cartas.add(new Carta(11, "H"));
		cartas.add(new Carta(12, "S"));
		
		Mao jogador1 = new Mao(cartas);
		assertTrue(jogador1.isSequencia());
	}
	
	@Test
	public void testSequenciaInvalida() {
		List<Carta> cartas = new ArrayList<Carta> ();
		cartas.add(new Carta(14, "C"));
		cartas.add(new Carta(9, "D"));
		cartas.add(new Carta(10, "H"));
		cartas.add(new Carta(11, "H"));
		cartas.add(new Carta(12, "S"));
		
		Mao jogador1 = new Mao(cartas);
		assertFalse(jogador1.isSequencia());
	}
	
	@Test
	public void testSequenciaValidaComAsNoInicio() {
		List<Carta> cartas = new ArrayList<Carta> ();
		cartas.add(new Carta(14, "C"));
		cartas.add(new Carta(2, "D"));
		cartas.add(new Carta(3, "H"));
		cartas.add(new Carta(4, "H"));
		cartas.add(new Carta(5, "S"));
		
		Mao jogador1 = new Mao(cartas);
		assertTrue(jogador1.isSequencia());
	}
	
	@Test
	public void testSequencia4Cinco1As() {
		List<Carta> cartas = new ArrayList<Carta> ();
		cartas.add(new Carta(14, "C"));
		cartas.add(new Carta(5, "D"));
		cartas.add(new Carta(5, "H"));
		cartas.add(new Carta(5, "C"));
		cartas.add(new Carta(5, "S"));
		
		Mao jogador1 = new Mao(cartas);
		assertFalse(jogador1.isSequencia());
	}

	@Test
	public void testFullHouse() {
		List<Carta> cartas = new ArrayList<Carta> ();
		cartas.add(new Carta(2, "C"));
		cartas.add(new Carta(2, "D"));
		cartas.add(new Carta(5, "H"));
		cartas.add(new Carta(5, "C"));
		cartas.add(new Carta(5, "S"));
		
		Mao jogador1 = new Mao(cartas);
		assertTrue(jogador1.isFullHouse());
	}

}
