/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemtastic.attendance;

import com.gemtastic.attendencesystem.enteties.Users;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Gemtastic
 */
@Stateless
@LocalBean
public class UserSession {
    
    @PersistenceContext
    EntityManager em;

    /**
     * 
     * @return List<Users>
     */
    public List<Users> retrieve() {
        Query query = em.createNamedQuery("Users.findAll");        
        return query.getResultList();
    }

    /**
     * 
     * @param user
     * @return Users
     */
    public Users update(Users user) {
        return em.merge(user);
    }
}
