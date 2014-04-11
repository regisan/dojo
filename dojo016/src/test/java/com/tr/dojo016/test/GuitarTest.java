package com.tr.dojo016.test;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tr.dojo016.model.Builder;
import com.tr.dojo016.model.Guitar;
import com.tr.dojo016.model.GuitarSpec;
import com.tr.dojo016.model.Type;
import com.tr.dojo016.model.Wood;
import com.tr.dojo016.service.Inventory;
import com.tr.dojo016.util.Resources;

@RunWith(Arquillian.class)
public class GuitarTest {

    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "guitar.war")
                .addClasses(Guitar.class, Inventory.class, GuitarSpec.class, Builder.class, Type.class, Wood.class, Resources.class)
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                // Deploy our test datasource
                .addAsWebInfResource("test-ds.xml");
    }
    
    @Inject
    Inventory guitarRegistration;

    @Inject
    Logger log;
    
    @Test
    public void testAddGuitar() throws Exception {
        Guitar newGuitar = new Guitar();
        newGuitar.setSerialNumber("001");
        newGuitar.setPrice(3000.0);
        
        GuitarSpec spec = new GuitarSpec();
        spec.setModel("LesPaul");
        spec.setNumStrings(6);
        spec.setBuilder(Builder.FENDER);
        spec.setType(Type.ELETRICA);
        spec.setTopWood(Wood.CEDRO);
        spec.setBackWood(Wood.CEDRO);
        
        newGuitar.setSpec(spec);
        
        guitarRegistration.register(newGuitar);
        
        assertNotNull(newGuitar.getId());
        assertNotNull(spec.getId());
        log.info(newGuitar.getSerialNumber() + " was persisted with id " + newGuitar.getId());
    }
    
    @Test
    public void testInventory() throws Exception {
        
        GuitarSpec spec = new GuitarSpec();
        spec.setModel("LesPaul");
        spec.setNumStrings(4);
        spec.setBuilder(Builder.WARMICK);
        spec.setType(Type.ACUSTICA);
        spec.setTopWood(Wood.PEROBA);
        spec.setBackWood(Wood.CEDRO);
        
        guitarRegistration.addGuitar("002", 4005.65, spec);
        
        assertNotNull(spec.getId());
        log.info("Spec was persisted with id " + spec.getId());
    }
    
    @Test
    public void testGetGuitar() throws Exception {
        
        GuitarSpec spec = new GuitarSpec();
        spec.setModel("Cherry");
        spec.setNumStrings(4);
        spec.setBuilder(Builder.GIBSON);
        spec.setType(Type.ACUSTICA);
        spec.setTopWood(Wood.PEROBA);
        spec.setBackWood(Wood.CEDRO);
        
        guitarRegistration.addGuitar("003", 4005.65, spec);

        assertNotNull(guitarRegistration.getGuitar("003"));         
    }    
    
    @Test
    public void testSearchGuitar() throws Exception {
        
        GuitarSpec spec = new GuitarSpec();
        spec.setModel("Cherry");
        spec.setNumStrings(4);
        spec.setBuilder(Builder.GIBSON);
        spec.setType(Type.ACUSTICA);
        spec.setTopWood(Wood.PEROBA);
        spec.setBackWood(Wood.CEDRO);
        
        guitarRegistration.addGuitar("004", 4205.65, spec);

        assertTrue(guitarRegistration.searchGuitar(spec).size() == 1);
    }
    
}
