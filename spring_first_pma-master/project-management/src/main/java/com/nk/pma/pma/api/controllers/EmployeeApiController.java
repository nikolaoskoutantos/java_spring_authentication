package com.nk.pma.pma.api.controllers;

import java.util.List;

import com.nk.pma.pma.dao.EmployeeRepository;
import com.nk.pma.pma.entities.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {
    
@Autowired
EmployeeRepository empRepo;

//GET /app-api/employees
@GetMapping
public List<Employee> getEmployees() {
    return empRepo.findAll();
}

//GET a spesific employee  
@GetMapping("/{id}")
public Employee getEmployee(@PathVariable("id") Long id){
    return empRepo.findById(id).get();
} 

//POST employee for creation
@PostMapping(consumes = "application/json")
@ResponseStatus(HttpStatus.CREATED)
public Employee createEmployee(@RequestBody Employee employee){
    return empRepo.save(employee);
}


//UPDATE employee
@PutMapping("/{id}")
@ResponseStatus(HttpStatus.OK)
public Employee updateEmployees(@RequestBody Employee employee){
   return empRepo.save(employee);
}

//DELETE employee
@DeleteMapping("/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void deleteEmployee(@PathVariable("id") Long id ){
 try {
    empRepo.deleteById(id); 
 } catch (EmptyResultDataAccessException e) {
    System.out.println("No record in order to delete");
 }

    
}


}
