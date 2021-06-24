package com.nk.pma.pma.controllers;

import java.util.List;

import com.nk.pma.pma.dao.EmployeeRepository;
import com.nk.pma.pma.dao.ProjectRepository;
import com.nk.pma.pma.entities.Employee;
import com.nk.pma.pma.entities.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    
    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping
    public String projects(Model model){
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects);
        return "/projects/list-projects";
    }


    @RequestMapping("/new") // or @GetMapping for GET requests
    public String displayProjectForm(Model model){
        Project aproject = new Project();
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("project",aproject);
        model.addAttribute("allEmployees", employees);
        return "/projects/newproject";
    }

    @PostMapping(value="/save" )
    public String createproject(Project project , Model model){
        
        proRepo.save(project);

        
        
        return "redirect:/projects/";
    }
}
