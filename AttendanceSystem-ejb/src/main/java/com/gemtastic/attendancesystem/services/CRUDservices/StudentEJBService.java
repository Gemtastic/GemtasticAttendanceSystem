/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemtastic.attendancesystem.services.CRUDservices;

import com.gemtastic.attendancesystem.services.interfaces.CRUDService;
import com.gemtastic.attendencesystem.enteties.Students;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Service for CRUDing the Students object.
 * 
 * @author Gemtastic
 */
@Stateless
public class StudentEJBService implements CRUDService<Students> {

    @PersistenceContext
    private EntityManager em;

    /**
     * Finds all students in database and returns the results in a list.
     * 
     * @return List{@literal <}Students{@literal >}
     */
    @Override
    public List<Students> findAll() {
        TypedQuery<Students> query = em.createNamedQuery("Students.findAll", Students.class);
        List<Students> results = query.getResultList();
        return results;
    }

    /**
     * Finds one student and returns it or null if the student doesn't exist.
     * 
     * @param student
     * @return Students
     */
    @Override
    public Students readOne(Students student) {
        Students result = em.find(Students.class, student.getId());
        return result;
    }

    /**
     * Deletes the given student or throws exception.
     * 
     * @param student 
     */
    @Override
    public void delete(Students student) {
        em.remove(student);
    }

    /**
     * Updates or creates the given student depending on its existence 
     * in the database.
     * 
     * @param student
     * @return Students
     */
    @Override
    public Students upsert(Students student) {
        Students result = em.merge(student);
        return result;
    }
    
}
