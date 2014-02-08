package com.tr.dojo007;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ContaLetrasTest {
	
	ContaLetras contaLetras;

	@Before
	public void setUp() {
		contaLetras = new ContaLetras();
	}
	
	
	@Test
	public void testUm() {
		assertEquals(2, contaLetras.contar(1));
	}
	
	@Test
	public void testDois() {
		assertEquals(6, contaLetras.contar(2));
	}

	@Test
	public void testNove() {
		assertEquals(37, contaLetras.contar(9));
	}

	@Test
	public void testDez(){
		assertEquals(40, contaLetras.contar(10));
	}
	
	@Test
	public void testOnze(){
		assertEquals(44, contaLetras.contar(11));
	}
	
	@Test
	public void testVinte(){
		assertEquals(105, contaLetras.contar(20));
	}
	
	@Test
	public void testVinteEUm(){
		assertEquals(113, contaLetras.contar(21));
	}

	@Test
	public void testVinteENove(){
		assertEquals(196, contaLetras.contar(29));
	}

	@Test
	public void testTrinta(){
		assertEquals(202, contaLetras.contar(30));
	}

	@Test
	public void testNoventaENove(){
		assertEquals(1038, contaLetras.contar(99));
	}

	@Test
	public void testCem(){
		assertEquals(1041, contaLetras.contar(100));
	}
	
	@Test
	public void testCentoEUm(){
		assertEquals(1049, contaLetras.contar(101));
	}
	
	@Test
	public void testCentoEquatro(){
		assertEquals(1081, contaLetras.contar(104));
	}
	
	@Test
	public void testCentoEnove(){
		assertEquals(1132, contaLetras.contar(109));
	}
	
	@Test
	public void testCentoEDez(){
		assertEquals(1141, contaLetras.contar(110));
	}
	
	@Test
    public void test111(){
        assertEquals(1151, contaLetras.contar(111));
    }
	
	@Test
    public void test112(){
        assertEquals(1161, contaLetras.contar(112));
    }
	
	@Test
    public void test119(){
        assertEquals(1255, contaLetras.contar(119));
    }
	
	@Test
    public void test120(){
        assertEquals(1266, contaLetras.contar(120));
    }
	
	@Test
    public void test121(){
        assertEquals(1280, contaLetras.contar(121));
    }

	@Test
	public void testDuzentosEDez(){
		assertEquals(2811, contaLetras.contar(210));
	}
	
	@Test
	public void testTrezentosEDez(){
		assertEquals(4759, contaLetras.contar(310));
	}
	
	@Test
	public void test999(){
		assertEquals(19669, contaLetras.contar(999));
	}
	
	@Test
	public void test1000(){
		assertEquals(19672, contaLetras.contar(1000));
	}
	
	@Test
	public void test300(){
		assertEquals(4619, contaLetras.contar(300));
	}
	
	@Test
	public void testDecompor1() {
	    assertEquals(1, contaLetras.decompor(1));
	}
	
	@Test
    public void testDecompor10() {
        assertEquals(10, contaLetras.decompor(10));
    }
	
	@Test
    public void testDecompor19() {
        assertEquals(19, contaLetras.decompor(19));
    }
	
	@Test
    public void testDecompor20() {
        assertEquals(20, contaLetras.decompor(20));
    }
	
	@Test
    public void testDecompor25() {
        assertEquals(20, contaLetras.decompor(25));
    }
	
	@Test
    public void testDecompor100() {
        assertEquals(100, contaLetras.decompor(100));
    }
	
	@Test
    public void testDecompor101() {
        assertEquals(100, contaLetras.decompor(101));
    }
	
	@Test
    public void testDecompor115() {
        assertEquals(100, contaLetras.decompor(115));
    }
	
	@Test
    public void testDecompor999() {
        assertEquals(900, contaLetras.decompor(999));
    }
	
	@Test
    public void testDecompor1000() {
        assertEquals(1000, contaLetras.decompor(1000));
    }
}