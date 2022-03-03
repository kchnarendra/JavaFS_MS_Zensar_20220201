package com.narendra.util;

import java.util.ArrayList;
import java.util.List;

import com.narendra.entity.one_to_one.EmployeeEntity;
import com.narendra.entity.one_to_one.ProfileEntity;
import com.narendra.json.Employee;
import com.narendra.json.Profile;

public class EmployeeUtil {

	public static Employee convertEmployeeEntityIntoEmployee(EmployeeEntity employeeEntity) {
		ProfileEntity profileEntity = employeeEntity.getProfile();
		Profile profile = new Profile(profileEntity.getId(), profileEntity.getCompany(), profileEntity.getExperience());
		return new Employee(employeeEntity.getEmployeeId(), employeeEntity.getName(), employeeEntity.getSal(), profile);
	}

	public static EmployeeEntity convertEmployeeIntoEmployeeEntity(Employee employee) {
		Profile profile = employee.getProfile();
		ProfileEntity profileEntity = new ProfileEntity(profile.getCompany(), profile.getExperience());
		return new EmployeeEntity(employee.getName(), employee.getSal(), profileEntity);
	}

	public static List<Employee> convertEmployeeEntityListIntoEmployeeList(List<EmployeeEntity> employeeEntityList) {
		List<Employee> employees = new ArrayList<Employee>();
		for(EmployeeEntity employeeEntity: employeeEntityList) {
			employees.add(convertEmployeeEntityIntoEmployee(employeeEntity));
		}
		return employees;
	}
}