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


@Entity 
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long projectid;
    private String name;
    private String stage;
    private String description;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE , CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name="project_employee", joinColumns = @JoinColumn(name="projectid"), inverseJoinColumns = @JoinColumn(name="employeeid"))
    private List<Employee> employees;




    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
                   
    public Project(){

    }

    public Project(String name, String stage, String description) {
        super(); 
        this.name = name;
        this.stage = stage;
        this.description = description;
    }

    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   
    public long getProjectid() {
        return projectid;
    }
    public String getStage() {
        return stage;
    }
    public void setStage(String stage) {
        this.stage = stage;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setProjectid(long projectid) {
        this.projectid = projectid;
    }

    public void addEmployee(Employee emp){
        if(employees == null){
            employees = new ArrayList<>();
        }
        employees.add(emp);
    }
     
}
