package com.blogspot.mikelaud.ibl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Utils {

	public static String nvl(String aString) {
		return (null == aString ? "" : aString);
	}
	
	public static String toTimeZoneTime(long aUnixTimeSec, String aTimeZone) { // number of seconds since 1/1/1970 GMT.
		Date date = new Date(TimeUnit.SECONDS.toMillis(aUnixTimeSec));
		SimpleDateFormat dateFormat = new SimpleDateFormat(Config.getDefaultTimeFormat());
		dateFormat.setTimeZone(TimeZone.getTimeZone(Const.getNewYorkTimeZone()));
		String dateString = dateFormat.format(date);
		return dateString;
	}
	
	public static String toTimeZoneTime(String aUnixTimeSec, String aTimeZone) { // number of seconds since 1/1/1970 GMT.
		long unixTimeSec = Long.parseLong(aUnixTimeSec);
		return toTimeZoneTime(unixTimeSec, aTimeZone);
	}
	
	public static String toNewYorkTime(long aUnixTimeSec) {
		return toTimeZoneTime(aUnixTimeSec, Const.getNewYorkTimeZone());
	}
	
	public static String toNewYorkTime(String aUnixTimeSec) {
		return toTimeZoneTime(aUnixTimeSec, Const.getNewYorkTimeZone());
	}
	
	public static String toMoscowTime(long aUnixTimeSec) {
		return toTimeZoneTime(aUnixTimeSec, Const.getMoscowTimeZone());
	}
	
	public static String toMoscowTime(String aUnixTimeSec) {
		return toTimeZoneTime(aUnixTimeSec, Const.getMoscowTimeZone());
	}
	
	public static String toKievTime(long aUnixTimeSec) {
		return toTimeZoneTime(aUnixTimeSec, Const.getKievTimeZone());
	}
	
	public static String toKievTime(String aUnixTimeSec) {
		return toTimeZoneTime(aUnixTimeSec, Const.getKievTimeZone());
	}
	
}
