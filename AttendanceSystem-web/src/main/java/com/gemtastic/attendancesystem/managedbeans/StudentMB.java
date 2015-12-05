/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemtastic.attendancesystem.managedbeans;

import com.gemtastic.attendancesystem.services.CRUDservices.StudentEJBService;
import com.gemtastic.attendencesystem.enteties.Students;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Gemtastic
 */
@ManagedBean(name = "student")
@RequestScoped
public class StudentMB {
    
    @EJB
    StudentEJBService sEJB;
    
    public Date regdate;
    public String firstname;
    public String lastname;
    public long socialSecurityNo;
    public String email;
    public int phone;
    private UploadedFile file;
    
    public Students s = new Students();
    
    public void onSubmit(ActionEvent e){

        s.setFirstname(firstname);
        s.setLastname(lastname);
        s.setSocSecNo(socialSecurityNo);
        s.setEmail(email);
        if(phone != 0){
            s.setPhone(phone);
        }
        s.setRegDate(new Date());
        s.setImages(file.getContents());
        sEJB.upsert(s);
    }

    public StudentMB() {
    }
    
    
    
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public long getSocialSecurityNo() {
        return socialSecurityNo;
    }

    public void setSocialSecurityNo(long socialSecurityNo) {
        this.socialSecurityNo = socialSecurityNo;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Students getStudent() {
        return s;
    }

    public void setStudent(Students student) {
        this.s = student;
    }
    
}
