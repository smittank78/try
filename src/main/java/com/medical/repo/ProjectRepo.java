package com.medical.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medical.model.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {

}
