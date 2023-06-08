package com.medical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.medical.model.Employee;
import com.medical.model.Project;
import com.medical.repo.EmpRepo;
import com.medical.repo.ProjectRepo;

import jakarta.annotation.PostConstruct;

@RestController
public class handler {
	
	public handler() {
		super();
		System.out.println("handler cnstr called!!!");
	}

	@Autowired
	ProjectRepo projectRepo;

	@Autowired
	EmpRepo empRepo;
	
	@PostConstruct
	void add() {		
		try {
			
			Project project1 = new Project();
			project1.setProjectName("my-project-12");
			
			Project project2 = new Project();
			project2.setProjectName("my-project-12-1");
			
			List<Project> projects = List.of(project1,project2);
			Employee employee = new Employee();
			employee.setName("my-employee-12");

			employee.setProjects(projects);
//			project.setEmployee(employee);
			
			empRepo.save(employee);
			System.out.println("employee saved");

//			projectRepo.save(project);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@GetMapping("/delete/{id}")
	void delete(@PathVariable int id) 
	{
		empRepo.deleteById(id);
		System.out.println("employee : " + empRepo.findById(id));
	}
}