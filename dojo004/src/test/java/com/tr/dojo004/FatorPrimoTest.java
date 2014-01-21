package com.tr.dojo004;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FatorPrimoTest {
	
	FatorPrimo fp;
	
	@Before
	public void setUp() {
		fp = new FatorPrimo();
	}
	
	@Test
	public void testCalcularFatores1() {
		List<Integer> fatores = new ArrayList<>();
		fatores.add(1);
		assertEquals(fatores, fp.calcularFatores(1));
	}
	
	@Test
	public void testCalcularFatores4() {
		List<Integer> fatores = new ArrayList<>();
		fatores.add(2);
		fatores.add(2);
		assertEquals(fatores, fp.calcularFatores(4));
	}
	
	@Test
	public void testCalcularProximoPrimo() {
		assertEquals(2, fp.calcularProximoPrimo(1));
		assertEquals(3, fp.calcularProximoPrimo(2));
		assertEquals(5, fp.calcularProximoPrimo(3));
		assertEquals(5, fp.calcularProximoPrimo(4));
		assertEquals(7, fp.calcularProximoPrimo(5));
		assertEquals(11, fp.calcularProximoPrimo(8));
		assertEquals(11, fp.calcularProximoPrimo(9));
		assertEquals(13, fp.calcularProximoPrimo(11));
		assertEquals(23, fp.calcularProximoPrimo(20));
	}
	
	@Test
	public void testCalcularFatores12() {
		List<Integer> fatores = new ArrayList<>();
		fatores.add(2);
		fatores.add(2);
		fatores.add(3);
		assertEquals(fatores, fp.calcularFatores(12));
	}

	@Test
	public void testCalcularFatores100() {
		List<Integer> fatores = new ArrayList<>();
		fatores.add(2);
		fatores.add(2);
		fatores.add(5);
		fatores.add(5);
		assertEquals(fatores, fp.calcularFatores(100));
	}

	@Test
	public void testCalcularFatores276() {
		List<Integer> fatores = new ArrayList<>();
		fatores.add(2);
		fatores.add(2);
		fatores.add(3);
		fatores.add(23);
		assertEquals(fatores, fp.calcularFatores(276));
	}
	
	@Test
	public void testCalcularFatores1000() {
		List<Integer> fatores = new ArrayList<>();
		fatores.add(2);
		fatores.add(2);
		fatores.add(2);
		fatores.add(5);
		fatores.add(5);
		fatores.add(5);
		assertEquals(fatores, fp.calcularFatores(1000));
	}
	
	@Test
	public void testCalcularFatores1234567() {
		List<Integer> fatores = new ArrayList<>();
		fatores.add(127);
		fatores.add(9721);
		assertEquals(fatores, fp.calcularFatores(1234567));
	}

}
