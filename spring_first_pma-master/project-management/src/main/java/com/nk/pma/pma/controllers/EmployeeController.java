package com.nk.pma.pma.controllers;

import java.util.List;

import com.nk.pma.pma.dao.EmployeeRepository;
import com.nk.pma.pma.entities.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping
    public String employees(Model model){
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }


    @GetMapping("/new") 
    public String displayEmployeeForm(Model model){
        Employee emp = new Employee();
        model.addAttribute("employee",emp);
        return "/employees/newemployee";    
    }    


    @PostMapping("/save")
    public String SaveEmployee(Model model , Employee employee){
        empRepo.save(employee);
        return "redirect:/employees";
    }
}
