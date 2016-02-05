package com.gemtastic.attendancesystem.managedbeans;

import com.gemtastic.attendancesystem.services.CRUDservices.LectureEJBService;
import com.gemtastic.attendancesystem.services.CRUDservices.StudentEJBService;
import com.gemtastic.attendencesystem.enteties.Courses;
import com.gemtastic.attendencesystem.enteties.Employees;
import com.gemtastic.attendencesystem.enteties.Lectures;
import com.gemtastic.attendencesystem.enteties.Students;
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
    
    public int id;
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
        lEJB.upsert(l);
    }
    
    
    @EJB
    private LectureEJBService lEJB;
    
    @EJB
    private StudentEJBService sEJB;
    
    public List<Lectures> lectures = lEJB.findAll();
    public List<Lectures> attendance;
    
    public List<Students> getStudentList(){
        Lectures lecture = new Lectures();
        lecture.setId(id);
        Lectures l = lEJB.readOne(lecture);
        return l.getStudentsList();
    }
    
    public Lectures getLectureById(int id){
        Lectures lecture = new Lectures();
        lecture.setId(id);
        Lectures l = lEJB.readOne(lecture);
        return l;
    }
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
