package com.aspire.mongodbdemocrud.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;

import com.aspire.mongodbdemocrud.exceptions.InvalidDateException;

/**
 * Class to validate the date introduced by the user
 * @author Mildred Zaragoza
 *
 */

@Service
public class DateValidator {
	
	/**
	 * This method valid the date introduced by the end user.
	 * @param date in String format
	 * @return boolean if the date is valid and false if not.
	 * @throws InvalidDateException when an invalid date is introduced. 
	 */
	public boolean validateDate(String date) throws InvalidDateException {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			dateFormat.setLenient(false);
			dateFormat.parse(date);
			return true;
		} catch (ParseException exception) {
			throw new InvalidDateException("dateOFJoin: Introduce a valid date");
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}	
	}
}
