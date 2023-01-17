package com.aspire.mongodbdemocrud.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

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


/**
 * Class to define the endpoints of the Students API
 * @author Mildred Zaragoza
 *
 */

@RestController
@RequestMapping("/students")
public class StudentController {
	
	// Logger logger = Logger.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;
	
    /**
     * This method returns a ResponseEntity with a list of students stored; if there is an exception,
     * returns the cause along with an error code.
     */
	@GetMapping()
	public ResponseEntity<?> getStudents(){
		try {
			return new ResponseEntity<List<Student>>(studentService.getStudents(), HttpStatus.OK);
		}catch(Exception exception) {
			return new ResponseEntity<String>(exception.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
    /**
     * This method returns a ResponseEntity with the student's information, an ID is required. 
     */
	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") String studentId){
		try {
			return new ResponseEntity<Student>(studentService.getStudentById(studentId), HttpStatus.OK);
		}catch(IllegalArgumentException exception) {
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}catch(NoSuchElementException exception) {
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
		}catch(Exception exception) {
			return new ResponseEntity<String>(exception.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
    /**
     *This method allows you to save a new student, and when you do, it returns a ResponseEntity with the student's 
     *information saved; if an exception occurs, it returns the cause as well as an error code. 
     */
	@PostMapping
	public ResponseEntity<?> saveStudent(@RequestBody @Valid Student student){
		try {
			return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
		}catch(Exception exception) {
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * This method allows you to delete a student, it's necessary to specify the student's ID.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") String idStudent){
		try {
			studentService.deleteStudentById(idStudent);
	       	return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}catch(NoSuchElementException exception) {
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
		}catch(IllegalArgumentException exception){
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 *This method allows you to update a student's information; it's not required to specify the ID.
	 */
	@PutMapping
	public ResponseEntity<?> updateStudent(@RequestBody Student student){
		try {
			return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
		}catch(Exception exception) {
			return new ResponseEntity<String>(exception.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
}
