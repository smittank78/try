package com.medical.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Setter
@Getter
public class Employee implements Serializable
{
	public Employee() {
		super();
		System.out.println("Employee cnstr called!!!");
	}
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	
	@Column(name =  "name")
	private String name;	

	@OneToMany(cascade = CascadeType.PERSIST,mappedBy = "employee",fetch = FetchType.LAZY)
	/*
	 * @JoinTable(name = "emp_project", joinColumns = @JoinColumn(name =
	 * "employee_id"), inverseJoinColumns = @JoinColumn(name = "project_id") )
	 */
	private List<Project> projects; // = new ArrayList<>();
	
	public void setProjects(List<Project> projects)
	{
		projects.forEach(project -> project.setEmployee(this));
		this.projects = projects;
	}
}