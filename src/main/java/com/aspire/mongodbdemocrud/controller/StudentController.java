package com.aspire.mongodbdemocrud.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<?> getStudentById(@PathVariable("id") Integer studentId){
		try {
			return new ResponseEntity<Student>(studentService.getStudentById(studentId).get(), HttpStatus.OK);
		}catch(NoSuchElementException exception) {
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
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
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") Integer idStudent){
		if(studentService.deleteStudent(idStudent)) {
	       	return new ResponseEntity<Boolean>(studentService.deleteStudent(idStudent), HttpStatus.OK);
		}else{
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updateStudent(@RequestBody Student student){
		try {
			return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
		}catch(Exception exception) {
			return new ResponseEntity<String>(exception.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
}
