/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemtastic.attendancesystem.services.CRUDservices;

import com.gemtastic.attendancesystem.services.interfaces.CRUDService;
import com.gemtastic.attendencesystem.enteties.Employees;
import com.gemtastic.attendencesystem.enteties.Position;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gemtastic
 */
@Stateless
@LocalBean
public class PositionEJBService implements CRUDService<Position>{

    @PersistenceContext
    private EntityManager em;
    
    /**
     * Finds the given position and returns it or null.
     * 
     * @param position
     * @return Position
     */
    @Override
    public Position readOne(Position position) {
        Position result = em.find(Position.class, position);
        return result;
    }

    /**
     * Finds and returns all positions as a list.
     * 
     * @return List{@literal <}Position{@literal >}
     */
    @Override
    public List<Position> findAll() {
        TypedQuery<Position> query = em.createNamedQuery("Position.findAll", Position.class);
        return query.getResultList();
    }

    /**
     * Removes the given position or throws an exception.
     * 
     * @param position 
     */
    @Override
    public void delete(Position position) {
        em.remove(position);
    }

    /**
     * Updates or inserts the given position depending on its existence 
     * in the database.
     * 
     * @param position
     * @return 
     */
    @Override
    public Position upsert(Position position) {
        Position result = em.merge(position);
        return result;
    }
    
}
