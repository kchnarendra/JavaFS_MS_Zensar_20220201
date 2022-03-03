package com.narendra.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.narendra.entity.one_to_one.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long>{

}