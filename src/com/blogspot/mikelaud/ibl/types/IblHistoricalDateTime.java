package com.blogspot.mikelaud.ibl.types;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class IblHistoricalDateTime {

	private static final String PATTERN_FROM_DATE = "yyyyMMdd";
	private static final String PATTERN_TO_DATE = "yyyy-MM-dd";
	private static final String PATTERN_TO_DATE_TIME = String.format("%s/HH:mm:ss", PATTERN_TO_DATE);
	
	private static final DateTimeFormatter FORMATTER_FROM_DATE = DateTimeFormatter.ofPattern(PATTERN_FROM_DATE);
	private static final DateTimeFormatter FORMATTER_TO_DATE = DateTimeFormatter.ofPattern(PATTERN_TO_DATE);
	private static final DateTimeFormatter FORMATTER_TO_DATE_TIME = DateTimeFormatter.ofPattern(PATTERN_TO_DATE_TIME);

	private final String FORMATTED_DATE_TIME;

	private long parseUnixTimeSec(String aUnixTimeSec) {
		long unixTimeSec = Long.parseLong(aUnixTimeSec);
		return unixTimeSec;
	}
	
	private ZonedDateTime toDateTime(long aUnixTimeSec, ZoneId aZoneId) {
		Instant timePoint = Instant.ofEpochSecond(aUnixTimeSec);
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(timePoint, aZoneId);
		return zonedDateTime;
	}
	
	private String formatDateTime(long aUnixTimeSec, ZoneId aZoneId) {
		ZonedDateTime zonedDateTime = toDateTime(aUnixTimeSec, aZoneId);
		String stringDateTime = zonedDateTime.format(FORMATTER_TO_DATE_TIME);
		return stringDateTime;
	}
	
	@Override
	public String toString() {
		return FORMATTED_DATE_TIME;
	}
	
	public IblHistoricalDateTime(String aUnixTimeSec, ZoneId aZoneId) {
		if (aUnixTimeSec.length() == PATTERN_FROM_DATE.length()) {
			LocalDate date = LocalDate.parse(aUnixTimeSec, FORMATTER_FROM_DATE);
			FORMATTED_DATE_TIME = FORMATTER_TO_DATE.format(date);
		}
		else {
			long unixTimeSec = parseUnixTimeSec(aUnixTimeSec);
			FORMATTED_DATE_TIME = formatDateTime(unixTimeSec, aZoneId);
		}
	}

}
