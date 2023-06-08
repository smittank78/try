package com.medical.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "project")
@Setter
@Getter
public class Project implements Serializable {
	public Project() {
		super();
		System.out.println("Project cnstr called!!!");
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name =  "project_name")
	private String projectName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "e_id")
	private Employee employee; 	
}