package com.narendra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.narendra.json.Employee;
import com.narendra.service.EmployeeService;

@RestController
@CrossOrigin("*")
@RequestMapping("/myapp")
public class EmployeeProfileController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value="/employee", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@PostMapping(value="/employee", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee createNewEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
}