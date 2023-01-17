package com.aspire.mongodbdemocrud.utils;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Class to handle the messages generated during the validation process.
 * @author Mildred Zaragoza
 *
 */

@RestControllerAdvice
public class MessageExceptionHandler {

	/**
	 * This methods links the field's name and its error message
	 * @param exception
	 * @return 
	 */
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public HashMap<String, String> handleValidateExceptions(MethodArgumentNotValidException exception) {
		HashMap<String, String> errors = new HashMap<String, String>();
		exception.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return errors;
	}
}
