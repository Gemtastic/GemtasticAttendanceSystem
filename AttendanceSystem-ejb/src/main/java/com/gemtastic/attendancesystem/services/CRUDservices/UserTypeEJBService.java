/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemtastic.attendancesystem.services.CRUDservices;

import com.gemtastic.attendancesystem.services.CRUDservices.interfaces.LocalUserTypeEJBService;
import com.gemtastic.attendencesystem.enteties.UserTypes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gemtastic
 */
@Stateless
public class UserTypeEJBService implements LocalUserTypeEJBService {

    @PersistenceContext
    EntityManager em;
    
    /**
     * Finds one type based on id and returns it or null.
     * 
     * @param type
     * @return UserTypes
     */
    @Override
    public UserTypes readOne(UserTypes type) {
        UserTypes result = em.find(UserTypes.class, type.getId());
        return result;
    }

    /**
     * Finds and returns all types as a list.
     * 
     * @return List{@literal <}UserTypes{@literal >} 
     */
    @Override
    public List<UserTypes> findAll() {
        TypedQuery<UserTypes> query = em.createNamedQuery("UserTypes.findAll", UserTypes.class);
        return query.getResultList();
    }

    /**
     * Deletes the given type or throws an exception.
     * 
     * @param type 
     */
    @Override
    public void delete(UserTypes type) {
        em.remove(type);
    }

    /**
     * Updates or inserts the given type depending on its existence 
     * in the database.
     * 
     * @param type
     * @return UserTypes
     */
    @Override
    public UserTypes upsert(UserTypes type) {
        UserTypes result = em.merge(type);
        return result;
    }
    
}
