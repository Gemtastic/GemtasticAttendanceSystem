/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemtastic.attendencesystem.enteties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gemtastic
 */
@Entity
@Table(name = "lectures")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lectures.findAll", query = "SELECT l FROM Lectures l"),
    @NamedQuery(name = "Lectures.findById", query = "SELECT l FROM Lectures l WHERE l.id = :id"),
    @NamedQuery(name = "Lectures.findByDate", query = "SELECT l FROM Lectures l WHERE l.date = :date"),
    @NamedQuery(name = "Lectures.findByStart", query = "SELECT l FROM Lectures l WHERE l.start = :start"),
    @NamedQuery(name = "Lectures.findByStop", query = "SELECT l FROM Lectures l WHERE l.stop = :stop")})
public class Lectures implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start")
    @Temporal(TemporalType.TIME)
    private Date start;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stop")
    @Temporal(TemporalType.TIME)
    private Date stop;
    @JoinTable(name = "attendance", joinColumns = {
        @JoinColumn(name = "lecture", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "student", referencedColumnName = "id")})
    @ManyToMany
    private List<Students> studentsList;
    @JoinColumn(name = "course", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Courses course;

    public Lectures() {
    }

    public Lectures(Integer id) {
        this.id = id;
    }

    public Lectures(Integer id, Date date, Date start, Date stop) {
        this.id = id;
        this.date = date;
        this.start = start;
        this.stop = stop;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getStop() {
        return stop;
    }

    public void setStop(Date stop) {
        this.stop = stop;
    }

    @XmlTransient
    public List<Students> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Students> studentsList) {
        this.studentsList = studentsList;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lectures)) {
            return false;
        }
        Lectures other = (Lectures) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gemtastic.Lectures[ id=" + id + " ]";
    }
    
}
