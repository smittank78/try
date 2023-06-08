package com.medical.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medical.model.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
