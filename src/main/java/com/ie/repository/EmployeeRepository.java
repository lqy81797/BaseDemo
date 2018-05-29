package com.ie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ie.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee getByLastName(String lastName);
}
