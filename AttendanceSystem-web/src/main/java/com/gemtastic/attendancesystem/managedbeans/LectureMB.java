/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemtastic.attendancesystem.managedbeans;

import com.gemtastic.attendancesystem.services.CRUDservices.LectureEJBService;
import com.gemtastic.attendencesystem.enteties.Courses;
import com.gemtastic.attendencesystem.enteties.Employees;
import com.gemtastic.attendencesystem.enteties.Lectures;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Gemtastic
 */
@ManagedBean(name="lecture")
public class LectureMB {
    
    public String name;
    public long id;
    public Courses course;
    public Date date;
    public Date startTime;
    public Date stopTime;
    public Employees teacher;
    
    public void onCreate() {
        Lectures l = new Lectures();
        l.setCourse(course);
        l.setDate(date);
        l.setStart(startTime);
        l.setStop(stopTime);
    }
    
    
    @EJB
    private LectureEJBService lEJB;
    
    public List<Lectures> lectures = lEJB.findAll();
    public List<Lectures> attendance = 
//    
//    public Lectures lecture = new Lectures();
//    
//    public List<Lectures> findLecturesByDate(SelectEvent event) {
//        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
//        LocalDate lD = LocalDate.parse(date.format(event.getObject()));
//        List<Lectures> lectures = lEJB.findByDate(lD);
//        return lectures;
//    }
//    
//    public List<Lectures> findLecturesByCourse(){
//        return lEJB.findByCourseName(lecture.getCourse());
//    }
}
