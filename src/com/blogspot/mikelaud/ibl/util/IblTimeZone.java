package com.blogspot.mikelaud.ibl.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.blogspot.mikelaud.ibl.Logger;

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
		SimpleDateFormat dateFormat = new SimpleDateFormat(IblDate.getDefaultFormat());
		dateFormat.setTimeZone(java.util.TimeZone.getTimeZone(getId()));
		String dateString = dateFormat.format(date);
		return dateString;
	}
	
	public String toDate(String aUnixTimeSec) {
		String date = "";
		try {
			long unixTimeSec = Long.parseLong(aUnixTimeSec);
			date = toDate(unixTimeSec);
		}
		catch (Exception e) {
			Logger.logError(IblString.nvl(e.getMessage()));
			date = toDate(0);
		}
		return date;
	}
	
}
