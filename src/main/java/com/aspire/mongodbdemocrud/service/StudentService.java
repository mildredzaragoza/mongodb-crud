package com.aspire.mongodbdemocrud.service;

import java.util.ArrayList;
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
	
	public Optional<Student> getStudentById(int studentId) {
		return studentRepository.findById(studentId);
	}
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
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
