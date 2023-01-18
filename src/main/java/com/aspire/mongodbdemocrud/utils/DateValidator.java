package com.aspire.mongodbdemocrud.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;

import com.aspire.mongodbdemocrud.exceptions.InvalidDateException;

@Service
public class DateValidator {
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
