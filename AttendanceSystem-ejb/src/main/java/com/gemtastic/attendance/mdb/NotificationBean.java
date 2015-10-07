/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemtastic.attendance.mdb;

import com.gemtastic.attendencesystem.enteties.Users;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author Gemtastic
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/NotificationQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class NotificationBean implements MessageListener {
    
    public NotificationBean() {
    }
    
    @Override
    public void onMessage(Message message){    
        try {        
            Object msgObj = ((ObjectMessage)message).getObject();        
            if (msgObj != null) {            
                Users customer = (Users)msgObj;            
                System.out.println("Customer with the following details has been updated:");            
                StringBuilder sb = new StringBuilder();            
                sb.append("Customer ID=");            
                sb.append(customer.getId());            
                sb.append(", ");            
                sb.append("Name=");            
                sb.append(customer.getUsername());            
                sb.append(", ");            
                sb.append("Email=");            
                sb.append(customer.getEmail());            
                System.out.println(sb.toString());        
            }    
        } catch (JMSException ex) {        
            Logger.getLogger(NotificationBean.class.getName()).log(Level.SEVERE, null, ex);    
        }
    }
    
    
}
