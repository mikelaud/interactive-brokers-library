package com.blogspot.mikelaud.ibl.types;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

import com.blogspot.mikelaud.ibl.types.common.IblEnum;

public enum IblTimeZone implements IblEnum {

	KIEV("Europe/Kiev"),
	MOSCOW("Europe/Moscow"),
	NEW_YORK("America/New_York");

	private final int ID;
	private final ZoneId VALUE;
	private final String NAME;
	private final String DESCRIPTION;
		
	private IblTimeZone(String aName) {
		ID = this.ordinal();
		VALUE = ZoneId.of(aName);
		NAME = aName;
		DESCRIPTION = this.name();  
	}

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
	
	public IblEndDateTime getEndDateTime(LocalDate aLocalDate) {
		LocalTime localTime = LocalTime.of(0, 0);
		LocalDateTime localDateTime = LocalDateTime.of(aLocalDate, localTime);
		return getEndDateTime(localDateTime);
	}
	
	public IblEndDateTime getEndDateTime(int aYear, int aMonth, int aDayOfMonth) {
		LocalDate localDate = LocalDate.of(aYear, aMonth, aDayOfMonth);
		return getEndDateTime(localDate);
	}
	
	public IblEndDateTime getEndDateTimeNow() {
		LocalDate localDate = LocalDate.now(VALUE).plusDays(1);
		return getEndDateTime(localDate);
	}
	
	@Override
	public String toString() {
		String message = String.format
		(	"name=\"%s\""
		,	NAME
		);
		return message;
	}

}
