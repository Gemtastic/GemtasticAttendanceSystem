/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemtastic.attendancesystem.services.interfaces;

import javax.ejb.Local;

/**
 *
 * @author Gemtastic
 */
@Local
public interface LoginServices {
    
    public boolean verify(String username, String password);
    
    public String hash(String password);
}
