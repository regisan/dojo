package com.tr.dojo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnagramaTest {
    
    private Anagrama anagrama;
    
    @Before
    public void setup(){
        anagrama = new Anagrama();
    }
    
    @Test
    public void testOi() {
       Assert.assertEquals("oi;io;",anagrama.gera("oi")); 
    }

    @Test
    public void testWeb() {
       Assert.assertEquals("web;wbe;ewb;ebw;bwe;bew;",anagrama.gera("web")); 
    }
   
    @Test
    public void testBiro() {
       Assert.assertEquals("biro;bior;brio;broi;boir;bori;"+
                           "ibro;ibor;irbo;irob;iobr;iorb;"+
                           "rbio;rboi;ribo;riob;roib;robi;"+
                           "obir;obri;oibr;oirb;orbi;orib;",anagrama.gera("biro")); 
    }
    

}
