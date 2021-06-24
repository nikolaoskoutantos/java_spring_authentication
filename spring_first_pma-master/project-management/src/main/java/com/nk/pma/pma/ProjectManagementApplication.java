package com.nk.pma.pma;

import com.nk.pma.pma.dao.EmployeeRepository;
import com.nk.pma.pma.dao.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectManagementApplication {

	  
    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;



	public static void main(String[] args) {
		
		SpringApplication.run(ProjectManagementApplication.class, args);
	}

	
}
