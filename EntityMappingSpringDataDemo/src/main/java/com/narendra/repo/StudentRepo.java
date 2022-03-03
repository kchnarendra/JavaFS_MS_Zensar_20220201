package com.narendra.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.narendra.entity.many_to_many.StudentEntity;

public interface StudentRepo extends JpaRepository<StudentEntity, Long>{

}