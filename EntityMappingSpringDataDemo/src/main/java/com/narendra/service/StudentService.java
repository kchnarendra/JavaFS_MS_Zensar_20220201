package com.narendra.service;

import java.util.List;

import com.narendra.json.Student;

public interface StudentService {
	public Student createStudent(Student student);
	public List<Student> getAllStudents();
}
