package com.nk.pma.pma.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeid;

    
    
    public Employee(){

    }

    public Employee(String fname, String lname, String email) {
        this.setFname(fname);
        this.setLname(lname);
        this.setEmail(email);
    }

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE , CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name="project_employee", joinColumns = @JoinColumn(name="employeeid"), inverseJoinColumns = @JoinColumn(name="projectid"))
    @JsonIgnore
    private List<Project> theprojects;

    public List<Project> getTheprojects() {
        return this.theprojects;
    }
 
    public void setTheprojects(List<Project> theprojects) {
        this.theprojects = theprojects;
    }

   

    public long getEmployeeid() {
        return this.employeeid;
    }

    public void setEmployeeid(long employeeid) {
        this.employeeid = employeeid;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    private String fname;
    private String lname;
    private String email;

    public void setProjects(List<Project> pro){
        if(theprojects==null){theprojects = new ArrayList<>();}
        theprojects.addAll(pro);
    }
    
}
