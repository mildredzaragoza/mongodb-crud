package com.aspire.mongodbdemocrud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception to validate a date.
 * @author Mildred Zaragoza
 *
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDateException extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidDateException(String message){
        super(message);
    }
}
