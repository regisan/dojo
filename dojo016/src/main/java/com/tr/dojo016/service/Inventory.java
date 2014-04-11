/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tr.dojo016.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.tr.dojo016.model.Guitar;
import com.tr.dojo016.model.GuitarSpec;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class Inventory {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Guitar> guitarEventSrc;

    public void register(Guitar guitar) throws Exception {
        log.info("Registering " + guitar.getSerialNumber());
        em.persist(guitar);
        guitarEventSrc.fire(guitar);
    }
    
    public void addGuitar(String serialNumber, Double price, GuitarSpec spec) throws Exception{
        Guitar guitar = new Guitar();
        guitar.setSerialNumber(serialNumber);
        guitar.setPrice(price);
        guitar.setSpec(spec);
        register(guitar);
    }
    
    public Guitar getGuitar(String serialNumber){
        Query query = em.createQuery("select g from Guitar g where g.serialNumber = :sn");
        query.setParameter("sn",serialNumber);
        return (Guitar) query.getSingleResult();
    }
    
    public List<Guitar> searchGuitar(GuitarSpec spec) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Guitar> criteria = cb.createQuery(Guitar.class);
        Root<Guitar> guitar = criteria.from(Guitar.class);
        Join<Guitar, GuitarSpec> join = guitar.join("spec", JoinType.INNER);
        List<Predicate> predicates = new ArrayList<Predicate>();
        
        if (spec.getModel() != null)
            predicates.add(cb.equal(join.get("model"), spec.getModel()));
        
        if (spec.getNumStrings() != null)
            predicates.add(cb.equal(join.get("numStrings"), spec.getNumStrings()));
        
        if (spec.getBuilder() != null)
            predicates.add(cb.equal(join.get("builder"), spec.getBuilder()));
        
        
        criteria.select(guitar).where(predicates.toArray(new Predicate[] {}));
        
        return em.createQuery(criteria).getResultList();
        
    }
}
