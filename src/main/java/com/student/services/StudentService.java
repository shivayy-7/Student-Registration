package com.student.services;

import java.util.List;

import com.student.entity.Student;

import jakarta.validation.Valid;

public interface StudentService {

	void save(Student student);

	List<Student> findAllStudent();

	Student findStudentById(String id);

	void updateStudent( Student student);

	void deleteStudentById(String id);

}
