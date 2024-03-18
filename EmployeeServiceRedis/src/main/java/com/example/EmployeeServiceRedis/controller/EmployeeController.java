package com.example.EmployeeServiceRedis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeServiceRedis.entity.Employee;
import com.example.EmployeeServiceRedis.reponsitory.EmployeeRepository;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	

	@GetMapping("/list")
	public List<Employee> getAll(){
		return employeeRepository.findAll();
	}

	@PostMapping("/create")
	public Employee save(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}
}
