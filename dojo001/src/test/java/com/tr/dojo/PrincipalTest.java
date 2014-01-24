package com.tr.dojo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class PrincipalTest {
	
	Principal p;
	
	@Before
	public void init() {
		p = new Principal();
	}

	@Test
	public void testConverte1() {
		assertEquals("2", p.converte("A"));
	}
	
	@Test
	public void testConverte2() {
		assertEquals("3", p.converte("D"));
	}
	
	@Test
	public void testConverteMistura1() {		
		assertEquals("23", p.converte("AD"));
	}
	
	@Test
	public void testConverteMistura2() {
		assertEquals("2_22", p.converte("AB"));
	}
	
	@Test
	public void testConverteMistura3() {
		assertEquals("2_22_222", p.converte("ABC"));
	}
	
	@Test
	public void testConverteMisturaFinal() {
		assertEquals("77773367_7773302_222337777_777766606660366656667889999_9999555337777", p.converte("SEMPRE ACESSO O DOJOPUZZLES"));
	}
	
	@Test
	public void testConverteMisturaFinalComMinuscula() {
		assertEquals("77773367_7773302_222337777_777766606660366656667889999_9999555337777", p.converte("sempre acesso o dojopuzzles"));
	}
	
	public void testPausaComPausa() {
		assertEquals("_", p.pausa("2","22"));
	}
	
	public void testPausaSemPausa() {
		assertEquals("", p.pausa("2","3"));
	}
}
