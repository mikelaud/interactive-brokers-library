package com.blogspot.mikelaud.ibl.types;

import java.time.LocalDateTime;
import java.time.ZoneId;

public enum IblTimeZone implements IblEnum {

	KIEV("Europe/Kiev"),
	MOSCOW("Europe/Moscow"),
	NEW_YORK("America/New_York");

	private final int ID;
	private final ZoneId VALUE;
	private final String NAME;
	private final String DESCRIPTION;
		
	@Override
	public int getId() {
		return ID;
	}
	
	public ZoneId getValue() {
		return VALUE;
	}
	
	public String getName() {
		return NAME;
	}
	
	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
	
	public IblUnixTime getUnixTime(long aUnixTimeSec) {
		return new IblUnixTime(aUnixTimeSec, VALUE);
	}	
	
	public IblHistoricalDateTime getHistoricalDateTime(String aUnixTimeSec) {
		return new IblHistoricalDateTime(aUnixTimeSec, VALUE);
	}
	
	public IblEndDateTime getEndDateTime(LocalDateTime aLocalDateTime) {
		return new IblEndDateTime(aLocalDateTime, VALUE);
	}
	
	public IblEndDateTime getEndDateTime(int aYear, int aMonth, int aDayOfMonth, int aHour, int aMinute) {
		LocalDateTime dateTime = LocalDateTime.of(aYear, aMonth, aDayOfMonth, aHour, aMinute); 
		return new IblEndDateTime(dateTime, VALUE);
	}
	
	@Override
	public String toString() {
		String message = String.format
		(	"name=\"%s\""
		,	NAME
		);
		return message;
	}
	
	private IblTimeZone(String aName) {
		ID = this.ordinal();
		VALUE = ZoneId.of(aName);
		NAME = aName;
		DESCRIPTION = this.name();  
	}

}
