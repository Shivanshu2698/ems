package com.springbootems.app.service;

import java.util.List;

import com.springbootems.app.model.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public Employee saveEmployee(Employee employee);
	public Employee getEmployeeById(Long id);
	public Employee updateEmployee(Employee employee);
	public void deleteEmployeeById(Long id);
}
