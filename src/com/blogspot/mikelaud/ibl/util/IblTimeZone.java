package com.blogspot.mikelaud.ibl.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.blogspot.mikelaud.ibl.Config;

public enum IblTimeZone {

	KIEV("Europe/Kiev"),
	MOSCOW("Europe/Moscow"),
	NEW_YORK("America/New_York");
	
	private String mId;
	
	public String getId() {
		return mId;
	}
	
	private IblTimeZone(String aId) {
		mId = aId; 
	}
	
	@Override
	public String toString() {
		return getId();
	}
	
	//------------------------------------------------------------------------
	
	public String toDate(long aUnixTimeSec) {
		Date date = new Date(TimeUnit.SECONDS.toMillis(aUnixTimeSec));
		SimpleDateFormat dateFormat = new SimpleDateFormat(Config.getDefaultTimeFormat());
		dateFormat.setTimeZone(java.util.TimeZone.getTimeZone(getId()));
		String dateString = dateFormat.format(date);
		return dateString;
	}
	
	public String toDate(String aUnixTimeSec) {
		long unixTimeSec = Long.parseLong(aUnixTimeSec);
		return toDate(unixTimeSec);
	}
	
}
