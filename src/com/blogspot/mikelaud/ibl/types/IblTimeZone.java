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
	private final String NAME;
	private final String DESCRIPTION;
	private final ZoneId ZONE_ID;
		
	private IblTimeZone(String aName) {
		ID = this.ordinal();
		NAME = aName;
		DESCRIPTION = this.name();
		ZONE_ID = ZoneId.of(aName);
	}

	@Override
	public int getId() {
		return ID;
	}
	
	@Override
	public String getName() {
		return NAME;
	}
	
	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
	
	public ZoneId getZoneId() {
		return ZONE_ID;
	}

	public IblCurrentTime getCurrentTime(long aUnixTimeSec) {
		return new IblCurrentTime(aUnixTimeSec, ZONE_ID);
	}	
	
	public IblRealtimeBarTime getRealtimeBarTime(long aUnixTimeSec) {
		return new IblRealtimeBarTime(aUnixTimeSec, ZONE_ID);
	}	
	
	public IblHistoricalDateTime getHistoricalDateTime(String aUnixTimeSec) {
		return new IblHistoricalDateTime(aUnixTimeSec, ZONE_ID);
	}
	
	public IblEndDateTime getEndDateTime(LocalDateTime aLocalDateTime) {
		return new IblEndDateTime(aLocalDateTime, ZONE_ID);
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
		LocalDate localDate = LocalDate.now(ZONE_ID).plusDays(1);
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
