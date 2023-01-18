package com.aspire.mongodbdemocrud;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * REST API with MongoDB
 * @author Mildred Zaragoza
 * Created at: 01/04/2023
 * Updated at: 01/17/2023
 * Reviewed by Suresh Rajendran
 * Reviewed at: 01/16/2023
 */

@SpringBootApplication
public class MongodbDemoCrudApplication {
	
	public static void main(String[] args) {
		    	Date newDate = new Date("22-JAN-2022");
		    	System.out.println("The date is " + newDate);
		    
		SpringApplication.run(MongodbDemoCrudApplication.class, args);
	}

}
