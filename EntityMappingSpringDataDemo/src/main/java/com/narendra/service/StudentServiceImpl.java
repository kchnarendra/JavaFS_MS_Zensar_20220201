package com.narendra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narendra.entity.many_to_many.StudentEntity;
import com.narendra.json.Student;
import com.narendra.repo.StudentRepo;
import com.narendra.util.StudentUtil;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	public Student createStudent(Student student) {
		StudentEntity studentEntity = StudentUtil.convertStudentIntoStudentEntity(student);
		studentEntity = studentRepo.save(studentEntity);
		return StudentUtil.convertStudentEntityIntoStudent(studentEntity);
	}

	@Override
	public List<Student> getAllStudents() {
		return StudentUtil.convertStudentEntityListIntoStudentList(studentRepo.findAll());
	}

}
