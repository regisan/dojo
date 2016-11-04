package com.tr.dojo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ContandoLetrasTest {
	
	ContandoLetras contando;
	
	@Before
	public void setUp() {
		contando = new ContandoLetras();
	}

	@Test
	public void contaUm() {
		assertEquals(2, contando.contar(1));
	}
	
	@Test
	public void contaDois() {
		assertEquals(6, contando.contar(2));
	}
	
	@Test
	public void contaTres() {
		assertEquals(10, contando.contar(3));
	}

	@Test
	public void contaQuatro() {
		assertEquals(16, contando.contar(4));
	}

	@Test
	public void contaCinco() {
		assertEquals(21, contando.contar(5));
	}

	@Test
	public void contaOnze() {
		assertEquals(44, contando.contar(11));
	}

	@Test
	public void contaVinte() {
		assertEquals(104, contando.contar(20));
	}
	
	@Test
	public void contaVinteeUm() {
		assertEquals(112, contando.contar(21));
	}
	@Test
	public void contaVinteeNove() {
		assertEquals(195, contando.contar(29));
	}
	@Test
	public void contaTrintaeUm() {
		assertEquals(210, contando.contar(31));
	}
}
