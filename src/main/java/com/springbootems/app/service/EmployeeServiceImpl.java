package com.springbootems.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootems.app.model.Employee;
import com.springbootems.app.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmailService emailService;
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmailService emailService) {
		super();
		this.employeeRepository = employeeRepository;
		this.emailService=emailService;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		Employee isSaved = employeeRepository.save(employee);
		if(isSaved.getId()!=null) {
			String subject="Employee Registration";
			String body="Hello "+isSaved.getFirstName().toUpperCase()+" , "+ "Your EMS registration is successful !";
			String to = isSaved.getEmail();
			emailService.simpleMailSender(subject, body, to);
		}
		return isSaved;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
		
	}

}
