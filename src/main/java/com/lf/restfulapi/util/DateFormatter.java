package com.lf.restfulapi.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * DateFormatter class responsible for date formatting.
 */

public class DateFormatter {
	
	/**
	 * Format the current date-time from the system to ISO8601 pattern.
	 * 
	 * @return the formatted date
	 */

	public static String formatToISO8601() {
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
		return dtf.format(ldt);
	}
}