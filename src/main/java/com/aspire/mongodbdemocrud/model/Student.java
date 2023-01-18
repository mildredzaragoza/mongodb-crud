package com.aspire.mongodbdemocrud.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Mildred Zaragoza
 *
 */

@Document(collection = "students")
public class Student {

	@Id
	@Null(message = "You cannot provide an ID, it's assigned automatically.")
	private String id;
	
	@NotBlank(message="Name must not be null.")
	@Pattern(regexp = "[A-Z][a-z]+( [A-Z][a-z]+)?", message = "Follow this format: Name LastName. Numbers are not allowed.")
	private String name;
	
	@NotBlank(message="Email must not be null.")
	@Email
	private String email;
	
	@NotBlank(message="Phone number must not be null.")
	@Pattern(regexp = "^\\d{10}$", message = "Phone number must contain 10 digits.")
	private String phoneNumber;
	
	@NotNull(message = "Age must not be null.")
	@Min(5)
	@Max(25)
	private int age;
	
	@NotBlank(message="Date of join must not be null.")
	@Pattern(regexp = "^\\d{2}-[a-zA-Z]{3}-\\d{4}$", message = "Follow this format: dd-MMM-yyyy")
	private String dateOfJoin;
	
	public Student() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	
	
    
}
