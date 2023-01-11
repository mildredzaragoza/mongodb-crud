package com.aspire.mongodbdemocrud.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.aspire.mongodbdemocrud.model.Student;
import com.aspire.mongodbdemocrud.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
public class StudentServiceUnitTest {
	
	@Mock
	private StudentRepository studentRepository;

	@InjectMocks
    private StudentService studentService;
    
	@BeforeEach
    public void init() {
    	MockitoAnnotations.openMocks(this);
    }
	
    @Test
    @DisplayName("Test mock creation")
    public void testMockCreation(){
        assertNotNull(studentRepository);
        assertNotNull(studentService);
    }
   
    @Test
    @DisplayName("Get all student test")
    public void getAllStudentsTest() throws Exception {
    	ArrayList<Student> student = new ArrayList<Student>();
    	when(studentRepository.findAll()).thenReturn(student);
    	studentService.getStudents();
        verify(studentRepository).findAll();
    }

    @Test
    @DisplayName("Save new student test")
    public void saveStudentTest() throws Exception {
    	when(studentRepository.save(any(Student.class))).thenReturn(new Student());
    	studentService.saveStudent(new Student());
    	verify(studentRepository).save(any(Student.class));
    }
    
    @Test
    @DisplayName("Delete student test")
    public void deleteStudentTest() throws Exception {
    	studentService.deleteStudent(1);
    	verify(studentRepository, times(1)).deleteById(any());
    }
    
    @Test
    @DisplayName("Get student by id test")
    public void getStudentByIdTest() throws Exception {
    	when(studentRepository.findById(any())).thenReturn(Optional.of(new Student()));
    	studentService.getStudentById(5);
    	verify(studentRepository).findById(any());
    }
    
}
