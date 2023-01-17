package com.aspire.mongodbdemocrud.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
	
	

    
}
