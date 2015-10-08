/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemtastic.attendancesystem.managedbeans;

import com.gemtastic.attendancesystem.services.CRUDservices.LectureEJBService;
import com.gemtastic.attendencesystem.enteties.Lectures;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Gemtastic
 */
@ManagedBean(name="lecture")
public class LectureMB {
    
    @EJB
    private LectureEJBService lEJB;
    
    private List<Lectures> lectures = lEJB.findAll();
    
    public Lectures lecture = new Lectures();
    
    public List<Lectures> findLecturesByDate(SelectEvent event) {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate lD = LocalDate.parse(date.format(event.getObject()));
        List<Lectures> lectures = lEJB.findByDate(lD);
        return lectures;
    }
    
    public List<Lectures> findLecturesByCourse(){
        return lEJB.findByCourseName(lecture.getCourse());
    }
}
