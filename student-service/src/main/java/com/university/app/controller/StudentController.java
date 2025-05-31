package com.university.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.app.response.StudentResponse;
import com.university.app.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	private StudentService stService;
	@Autowired
	public StudentController(StudentService stService){
		this.stService = stService;
	}
	
	@GetMapping("/getById/{id}")
	public StudentResponse getStudentById(@PathVariable Long id) {
		return stService.getStudentById(id);
	}
	

}
