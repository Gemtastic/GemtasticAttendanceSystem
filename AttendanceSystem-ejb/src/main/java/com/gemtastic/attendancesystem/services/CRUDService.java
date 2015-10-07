/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemtastic.attendancesystem.services;

/**
 * Interface for performing CRUD on database entity.
 * 
 * @author Gemtastic
 */
public interface CRUDService<T> {
    
    public T read();
    
    public T create();
    
    public boolean delete();
    
    public boolean update();
}
