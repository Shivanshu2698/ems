package com.springbootems.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootems.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
