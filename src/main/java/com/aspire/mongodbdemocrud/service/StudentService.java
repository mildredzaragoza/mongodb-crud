package com.aspire.mongodbdemocrud.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspire.mongodbdemocrud.model.Student;
import com.aspire.mongodbdemocrud.repository.StudentRepository;

/**
 * Class to implement methods available on StudentRepository such as 
 * findAll, findById, save, and deleteById.
 * @author Mildred Zaragoza
 *
 */
@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	/**
	 * This method returns all students
	 * @return a list of students' information
	 */
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}
	
	/**
	 * This method returns a student's information identified by its id
	 * @param id must not be null
	 * @return the entity with the given id
	 * @throws IllegalArgumentException when the user doesn't specify the id
	 * @throws NoSuchElementException when any student has the id specified.
	 */
	public Student getStudentById(String studentId) {
		try{
			return studentRepository.findById(studentId).get();
		}catch (IllegalArgumentException exception){
			throw new IllegalArgumentException("ID must not be null.");
		}catch(NoSuchElementException exception) {
			throw new NoSuchElementException("Student not found.");
		}
	}
	
	/**
	 * This method deletes a student identified by its id
	 * @param studentId must not be null
	 * @throws NoSuchElementException when any student has the id specified
	 * @throws IllegalArgumentException when the id is not specified.
	 */
	public void deleteStudentById(String studentId) {
		Optional<Student> student = studentRepository.findById(studentId);
		student.orElseThrow(() -> new NoSuchElementException("Student doesn't exist."));
		
		try {
			studentRepository.deleteById(studentId);
		}catch (IllegalArgumentException exception) {
			throw new IllegalArgumentException("ID must not be null.");
		}
		
	}
	
	/**
	 * This method saves a new student in the current collection
	 * @param student must not be null 
	 * @return the student saved
	 */
	public Student saveStudent(Student student){
		return studentRepository.insert(student);
	}
	
}
