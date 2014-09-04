package com.blogspot.mikelaud.ibl.types;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class IblRealtimeBarTime {

	private static final String PATTERN = "HH:mm:ss";
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

	private final ZonedDateTime DATE_TIME;

	public ZonedDateTime toDateTime(long aUnixTimeSec, ZoneId aZoneId) {
		Instant timePoint = Instant.ofEpochSecond(aUnixTimeSec);
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(timePoint, aZoneId);
		return zonedDateTime;
	}
	
	public ZonedDateTime getValue() {
		return DATE_TIME;
	}
	
	@Override
	public String toString() {
		return FORMATTER.format(DATE_TIME);
	}
	
	public IblRealtimeBarTime(long aUnixTimeSec, ZoneId aZoneId) {
		DATE_TIME = toDateTime(aUnixTimeSec, aZoneId);
	}

}
