package com.aspire.mongodbdemocrud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aspire.mongodbdemocrud.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer>{

}
