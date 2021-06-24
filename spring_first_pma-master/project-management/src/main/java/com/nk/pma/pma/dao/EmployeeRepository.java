package com.nk.pma.pma.dao;

import java.util.List;

import com.nk.pma.pma.dto.EmployeeProject;
import com.nk.pma.pma.entities.Employee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee , Long>{
   @Override
    public List<Employee> findAll(); 

    @Query(nativeQuery =true , value = "SELECT e.fname as firstname , e.lname as lastname, COUNT(pe.employeeid) as projectcount FROM employee e left join project_employee pe ON pe.employeeid = e.employeeid GROUP BY e.fname, e.lname ORDER BY 3 DESC")
    public List<EmployeeProject> EmployeesProjects();    

}
