package com.narendra.service;

import java.util.List;

import com.narendra.json.Employee;

public interface EmployeeService {
	public Employee createEmployee(Employee employee);
	public List<Employee> getAllEmployees();
}