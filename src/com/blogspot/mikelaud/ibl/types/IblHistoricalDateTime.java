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

	private final LocalDate LOCAL_DATE;
	private final String FORMATTED_DATE_TIME;

	private long parseUnixTimeSec(String aUnixTimeSec) {
		long unixTimeSec = Long.parseLong(aUnixTimeSec);
		return unixTimeSec;
	}
	
	private ZonedDateTime toZonedDateTime(long aUnixTimeSec, ZoneId aZoneId) {
		Instant timePoint = Instant.ofEpochSecond(aUnixTimeSec);
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(timePoint, aZoneId);
		return zonedDateTime;
	}
	
	public LocalDate getLocalDate() {
		return LOCAL_DATE;
	}
	
	@Override
	public String toString() {
		return FORMATTED_DATE_TIME;
	}
	
	public IblHistoricalDateTime(String aUnixTimeSec, ZoneId aZoneId) {
		if (aUnixTimeSec.length() == PATTERN_FROM_DATE.length()) {
			LOCAL_DATE = LocalDate.parse(aUnixTimeSec, FORMATTER_FROM_DATE);
			FORMATTED_DATE_TIME = FORMATTER_TO_DATE.format(LOCAL_DATE);
		}
		else {
			long unixTimeSec = parseUnixTimeSec(aUnixTimeSec);
			ZonedDateTime zonedDateTime = toZonedDateTime(unixTimeSec, aZoneId);
			LOCAL_DATE = zonedDateTime.toLocalDate();
			FORMATTED_DATE_TIME = zonedDateTime.format(FORMATTER_TO_DATE_TIME);
		}
	}

}
