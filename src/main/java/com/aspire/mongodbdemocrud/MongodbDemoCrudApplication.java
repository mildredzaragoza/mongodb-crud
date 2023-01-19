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
	
	private static final Logger LOGGER = LogManager.getLogger(MongodbDemoCrudApplication.class);
	
	public static void main(String[] args) {
		 
		/**
		 * Testing logger
		 */
		LOGGER.debug("Debugging log");
		LOGGER.info("Info log");
		LOGGER.warn("Hey, This is a warning!");
		LOGGER.error("Oops! We have an Error. OK");
		LOGGER.fatal("Damn! Fatal error. Please fix me.");
	    
		SpringApplication.run(MongodbDemoCrudApplication.class, args);
	}

}
