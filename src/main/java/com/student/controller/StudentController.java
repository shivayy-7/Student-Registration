package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.student.entity.Student;
import com.student.services.StudentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class StudentController implements WebMvcConfigurer{
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/createstudent")
	public String createStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create-student";
	}
	
	@PostMapping("/createstudent")
	public String saveStudent(@Valid Model model, Student student,
			BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("student", student);
			return"create-student";
		}
		studentService.save(student);
		List<Student> students = studentService.findAllStudent();
		model.addAttribute("students", students);
		return "list-of-student";
	}
	
	@GetMapping("/listallstudent")
	public String listOfStudent( Model model) {
		List<Student> students = studentService.findAllStudent();
		model.addAttribute("students", students);
		return "list-of-student";
	}
	
	@GetMapping("/updatestudent/{id}/edit")
	public String updateStudent(@PathVariable String id, Model model) {
		Student student = studentService.findStudentById(id);
		model.addAttribute("student", student);
		return "update-student";
	}
	
	@PostMapping("/createstudent/{id}")
	public String update(@Valid @PathVariable("id") String id,
	                      @ModelAttribute("student") Student student,
	                     BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("student", student);
			return"create-student";
		}
		
		student.setId(id);
		studentService.updateStudent(student);
		List<Student> students = studentService.findAllStudent();
		model.addAttribute("students", students);
		return "list-of-student";
	}
	
	@GetMapping("/deletestudent/{id}")
	public String deleteStudent(@PathVariable("id") String id, Model model) {
		studentService.deleteStudentById(id);
		List<Student> students = studentService.findAllStudent();
		model.addAttribute("students", students);
		return "list-of-student";
	}
	
	
	
}
