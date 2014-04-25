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
    Inventory inventory;

    @Inject
    Logger log;
    
    @Test
    public void testAddGuitar() throws Exception {
        Guitar newGuitar = new Guitar();
        newGuitar.setSerialNumber("001");
        newGuitar.setPrice(3000.0);
        
        GuitarSpec spec = new GuitarSpec();
        spec.setModel("Les Paul");
        spec.setNumStrings(6);
        spec.setBuilder(Builder.FENDER);
        spec.setType(Type.ELETRICA);
        spec.setTopWood(Wood.CEDRO);
        spec.setBackWood(Wood.CEDRO);
        
        newGuitar.setSpec(spec);
        
        inventory.register(newGuitar);
        
        assertNotNull(newGuitar.getId());
        assertNotNull(spec.getId());
        log.info(newGuitar.getSerialNumber() + " was persisted with id " + newGuitar.getId());
    }
    
    @Test
    public void testInventory() throws Exception {
        
        GuitarSpec spec = new GuitarSpec();
        spec.setModel("Les Paul");
        spec.setNumStrings(6);
        spec.setBuilder(Builder.WARMICK);
        spec.setType(Type.ACUSTICA);
        spec.setTopWood(Wood.PEROBA);
        spec.setBackWood(Wood.CEDRO);
        
        inventory.addGuitar("002", 4005.65, spec);
        
        assertNotNull(spec.getId());
        log.info("Spec was persisted with id " + spec.getId());
    }
    
    @Test
    public void testGetGuitar() throws Exception {
        
        GuitarSpec spec = new GuitarSpec();
        spec.setModel("Les Paul");
        spec.setNumStrings(6);
        spec.setBuilder(Builder.GIBSON);
        spec.setType(Type.ACUSTICA);
        spec.setTopWood(Wood.PEROBA);
        spec.setBackWood(Wood.CEDRO);
        
        inventory.addGuitar("003", 4005.65, spec);

        assertNotNull(inventory.getGuitar("003"));         
    }    
    
    @Test
    public void testSearchGuitar() throws Exception {
        
        GuitarSpec spec = new GuitarSpec();
        spec.setModel("Rosewood");
        spec.setNumStrings(6);
        spec.setBuilder(Builder.GIBSON);
        spec.setType(Type.ACUSTICA);
        spec.setTopWood(Wood.PEROBA);
        spec.setBackWood(Wood.CEDRO);
        
        inventory.addGuitar("004", 4205.65, spec);

        assertTrue(inventory.searchGuitar(spec).size() == 1);
    }
    
    @Test
    public void testSearchGuitar2() throws Exception {
        
        GuitarSpec spec = new GuitarSpec();
        spec.setModel("Les Paul");
        spec.setNumStrings(6);
        spec.setType(Type.ELETRICA);
        
        inventory.addGuitar("005", 6865.65, spec);

        assertTrue(inventory.searchGuitar(spec).size() >= 1);
    }
    
    @Test
    public void testSearchNoGuitar() throws Exception {
        
        GuitarSpec spec = new GuitarSpec();
        spec.setModel("Stratocaster");
        
        assertTrue(inventory.searchGuitar(spec).size() == 0);
    }
    
    @Test
    public void testSearchGuitarGibson() throws Exception {
        
        GuitarSpec spec = new GuitarSpec();
        spec.setBuilder(Builder.GIBSON);
        
        assertTrue(inventory.searchGuitar(spec).size() > 0);
    }
    
    @Test
    public void testSearchGuitarWood() throws Exception {

        GuitarSpec spec = new GuitarSpec();
        spec.setModel("SG");
        spec.setBuilder(Builder.GIBSON);
        spec.setBackWood(Wood.CEDRO);
        spec.setTopWood(Wood.CEDRO);
        spec.setNumStrings(6);
        
        inventory.addGuitar("006", 3000.0, spec);
        
        assertTrue(inventory.searchGuitar(spec).size() > 0);
    }
    
}
