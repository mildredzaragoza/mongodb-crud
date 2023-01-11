package com.aspire.mongodbdemocrud.service;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspire.mongodbdemocrud.model.Student;
import com.aspire.mongodbdemocrud.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public ArrayList<Student> getStudents(){
		return (ArrayList<Student>) studentRepository.findAll();
	}
	
	public Optional<Student> getStudentById(int studentId) throws Exception{
		try {
			return studentRepository.findById(studentId);
	    }catch(NoSuchElementException exception) {
	    	 throw new NoSuchElementException("Student with ID: " + studentId + " doesn't exist.");
	    }catch(Exception exception) {
	    	 throw new Exception("Something went wrong, try again.");
	    }
	}
	
	public Student saveStudent(Student student) throws Exception {
		try {
			return studentRepository.save(student);
		}catch (Exception exception) {
    		throw new Exception("Something went wrong, try again.");	
    	}
	}
	
	public Boolean deleteStudent(int studentId) {
		try {
			studentRepository.deleteById(studentId);
			return true;
		}catch(Exception exception) {
			return false;
		}
		
	}
}
