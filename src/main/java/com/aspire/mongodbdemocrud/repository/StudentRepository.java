package com.aspire.mongodbdemocrud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aspire.mongodbdemocrud.model.Student;

public interface StudentRepository extends MongoRepository<Student, Integer>{

}
