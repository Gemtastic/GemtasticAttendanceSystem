/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemtastic.attendancesystem.services.CRUDservices;

import com.gemtastic.attendancesystem.services.interfaces.CRUDService;
import com.gemtastic.attendencesystem.enteties.Courses;
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
public class CourseEJBService implements CRUDService<Courses>{

    @PersistenceContext(unitName = "com.gemtastic_AttendanceSystem-ejb_ejb_1.0.1PU")
    private EntityManager em;
    
    /**
     * Finds one course by id and returns it or null if the course doesn't exist.
     * 
     * @param course
     * @return course
     */
    @Override
    public Courses readOne(Courses course) {
        Courses result = em.find(Courses.class, course.getId());
        return result;
    }

    /**
     * Finds all courses in database and returns the results in a list.
     * 
     * @return List{@literal <}Courses{@literal >}
     */
    @Override
    public List<Courses> findAll() {
        TypedQuery<Courses> result = em.createNamedQuery("Courses.findAll", Courses.class);
        return result.getResultList();
    }

    /**
     * Deletes the given course or throws an exception.
     * 
     * @param course 
     */
    @Override
    public void delete(Courses course) {
        em.remove(course);
    }

    /**
     * Updates or inserts the given course depending on its existence
     * in the database.
     * 
     * @param course
     * @return Courses
     */
    @Override
    public Courses upsert(Courses course) {
        Courses result = em.merge(course);
        return result;
    }
    
}
