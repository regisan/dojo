package com.tr.dojo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MiojoTest {
	
	Miojo miojo;

	@Before
	public void setUp() {
		miojo = new Miojo();
	}

	@Test
	public void testPadrao() {
		assertEquals(10, miojo.calcula(3, 5, 7));
	}

	@Test
	public void test14() {
		assertEquals(14, miojo.calcula(4, 5, 7));
	}
	
	@Test
	public void teste21() {
		assertEquals(21, miojo.calcula(3, 6, 7));
	}
	
	@Test
	public void testeerro() {
		assertEquals(9999, miojo.calcula(3, 6, 8));
	}
	
	@Test
	public void teste7() {
		assertEquals(7, miojo.calcula(2, 5, 7));
	}
	
	@Test
	public void testeerro2() {
		assertEquals(9999, miojo.calcula(2, 5, 5));
	}
}
