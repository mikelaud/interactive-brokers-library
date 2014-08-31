package com.blogspot.mikelaud.ibl.types;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class IblUnixTime {

	private static final String PATTERN = "yyyy-MM-dd/HH:mm:ss[VV]";
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

	private final ZonedDateTime DATE_TIME;

	public ZonedDateTime toDateTime(long aUnixTimeSec, ZoneId aZoneId) {
		Instant timePoint = Instant.ofEpochSecond(aUnixTimeSec);
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(timePoint, aZoneId);
		return zonedDateTime;
	}
	
	public ZonedDateTime get() {
		return DATE_TIME;
	}
	
	@Override
	public String toString() {
		return FORMATTER.format(DATE_TIME);
	}
	
	public IblUnixTime(long aUnixTimeSec, ZoneId aZoneId) {
		DATE_TIME = toDateTime(aUnixTimeSec, aZoneId);
	}

}
