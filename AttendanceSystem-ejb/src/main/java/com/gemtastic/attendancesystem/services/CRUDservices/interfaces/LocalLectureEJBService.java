/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemtastic.attendancesystem.services.CRUDservices.interfaces;

import com.gemtastic.attendancesystem.services.interfaces.CRUDService;
import com.gemtastic.attendencesystem.enteties.Lectures;
import javax.ejb.Local;

/**
 *
 * @author Gemtastic
 */
@Local
public interface LocalLectureEJBService extends CRUDService<Lectures>{
    
}
