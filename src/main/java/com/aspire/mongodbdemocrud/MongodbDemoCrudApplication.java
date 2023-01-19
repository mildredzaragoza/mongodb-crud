package com.aspire.mongodbdemocrud;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * REST API with MongoDB
 * @author Mildred Zaragoza
 * Created at: 01/04/2023
 * Updated at: 01/19/2023
 * Reviewed by Suresh Rajendran
 * Reviewed at: 01/16/2023
 */

@SpringBootApplication
public class MongodbDemoCrudApplication {
	
	private static final Logger logger = LogManager.getLogger(MongodbDemoCrudApplication.class);
	
	public static void main(String[] args) {
		 
		/**
		 * Testing logger
		 */
		logger.debug("Debugging log");
	    logger.info("Info log");
	    logger.warn("Hey, This is a warning!");
	    logger.error("Oops! We have an Error. OK");
	    logger.fatal("Damn! Fatal error. Please fix me.");
	    
		SpringApplication.run(MongodbDemoCrudApplication.class, args);
	}

}
