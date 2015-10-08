/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemtastic.attendancesystem.services;

import com.gemtastic.attendancesystem.services.CRUDservices.UserEJBService;
import com.gemtastic.attendancesystem.services.interfaces.LoginServices;
import com.gemtastic.attendencesystem.enteties.Users;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Gemtastic
 */
@Stateless
public class LoginService implements LoginServices{

    @EJB
    UserEJBService uEJB;
    
    @Override
    public boolean verify(String username, String password) {
        boolean success = false;
        
        Users user = uEJB.findByUser(username, password);
        
        if(user != null && user.getPassword() != null){
            success = BCrypt.checkpw(password, user.getPassword());
        }
        return success;
    }

    @Override
    public String hash(String password) {
        String salt = BCrypt.gensalt();
        String hashed = BCrypt.hashpw(password, salt);
        
        return hashed;
    }
    
}
