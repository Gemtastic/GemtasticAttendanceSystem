/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemtastic.attendancesystem.sessionbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Gemtastic
 */
@SessionScoped
@ManagedBean(name="login")
public class loginbean {
    private boolean loggedIn;
    
    public void logIn(boolean logIn){
        loggedIn = logIn;
    }
    
    public boolean isLoggedIn() {
        return loggedIn;
    }
}
