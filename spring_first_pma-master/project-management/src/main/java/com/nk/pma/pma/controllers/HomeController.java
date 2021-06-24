package com.nk.pma.pma.controllers;

import java.util.List;

import com.nk.pma.pma.dao.EmployeeRepository;
import com.nk.pma.pma.dao.ProjectRepository;
import com.nk.pma.pma.dto.EmployeeProject;
import com.nk.pma.pma.entities.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
    
    @Autowired
    ProjectRepository proRepo;
    @Autowired
    EmployeeRepository empRepo;


    @GetMapping("/")
    public String DisplayHome(Model model){
        
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects);

        List<EmployeeProject> employessprojectcount = empRepo.EmployeesProjects();
        model.addAttribute("employeesprojectscount",employessprojectcount);
        
       



        return "/main/home";

    }

}
