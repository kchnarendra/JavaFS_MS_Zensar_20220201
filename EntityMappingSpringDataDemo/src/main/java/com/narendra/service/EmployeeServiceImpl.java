package com.narendra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narendra.entity.one_to_one.EmployeeEntity;
import com.narendra.json.Employee;
import com.narendra.repo.EmployeeRepo;
import com.narendra.util.EmployeeUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public Employee createEmployee(Employee employee) {
		EmployeeEntity employeeEntity = employeeRepo.save(EmployeeUtil.convertEmployeeIntoEmployeeEntity(employee));
		return EmployeeUtil.convertEmployeeEntityIntoEmployee(employeeEntity);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return EmployeeUtil.convertEmployeeEntityListIntoEmployeeList(employeeRepo.findAll());
	}

}