package com.student.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repositories.StudentRepository;

import jakarta.validation.Valid;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepo;

	@Override
	public void save(Student student) {
		//generate unique userid
		String randomUserId = UUID.randomUUID().toString();
		student.setId(randomUserId);
		studentRepo.save(student);
	}

	@Override
	public List<Student> findAllStudent() {
		List<Student> students = studentRepo.findAll();
		return students;
	}

	@Override
	public Student findStudentById(String id) {
		return studentRepo.findById(id).get();
	}

	@Override
	public void updateStudent( Student student) {
        studentRepo.save(student);		
	}

	@Override
	public void deleteStudentById(String id) {
		studentRepo.deleteById(id);
	}

}
