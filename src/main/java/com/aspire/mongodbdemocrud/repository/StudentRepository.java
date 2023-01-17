package com.aspire.mongodbdemocrud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aspire.mongodbdemocrud.model.Student;

/**
 * This interface extends MongoRepository to implement the methods available in the CRUD Repository
 * @author Mildred Zaragoza
 *
 */
@Repository
public interface StudentRepository extends MongoRepository<Student, String>{

}
