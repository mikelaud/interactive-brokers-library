package com.blogspot.mikelaud.ibl.types;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class IblLoggerDateTime {

	private static final String PATTERN = "yyyy-MM-dd/HH:mm:ss";
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);
	
	public static String get(ZoneId aZoneId) {
		ZonedDateTime DATE_TIME = ZonedDateTime.now(aZoneId);
		return FORMATTER.format(DATE_TIME);
	}
	
}
