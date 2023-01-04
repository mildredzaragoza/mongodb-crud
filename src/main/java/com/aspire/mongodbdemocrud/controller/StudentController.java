package com.aspire.mongodbdemocrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.mongodbdemocrud.model.Student;
import com.aspire.mongodbdemocrud.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping()
	public ResponseEntity<?> getStudents(){
		try {
			return new ResponseEntity<List<Student>>(studentService.getStudents(), HttpStatus.OK);
		}catch(Exception exception) {
			return new ResponseEntity<String>(exception.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getStudent(int studentId){
		try {
			return new ResponseEntity<Student>(studentService.getStudentById(studentId), HttpStatus.OK);
		}catch(Exception exception) {
			return new ResponseEntity<String>(exception.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> saveStudent(@RequestBody Student student){
		try {
			return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
		}catch(Exception exception) {
			return new ResponseEntity<String>(exception.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
