package com.blogspot.mikelaud.ibl.task.event.connection_and_server;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;

/**
 * This event receives the current system time on the server side.
 */
public class OnCurrentTime
	extends EventTaskEx<OnCurrentTime.Info>
{
	//------------------------------------------------------------------------
	public static class Info {

		/**
		 * The current system time on the server side.
		 */
		public final long UNIX_TIME_SEC;

		public Info(long aUnixTimeSec) {
			UNIX_TIME_SEC = aUnixTimeSec;
		}
		
	}
	//------------------------------------------------------------------------

	public static final String TIME_ZONE = "America/New_York";
	public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss z";

	@Override
	protected Task onEvent() throws Exception {
		return null;
	}

	@Override
	public String toString() {
		Date date = new Date(TimeUnit.SECONDS.toMillis(INFO.UNIX_TIME_SEC));
		SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);
		dateFormat.setTimeZone(TimeZone.getTimeZone(TIME_ZONE));
		String dateString = dateFormat.format(date);
		return String.format
		(	"%s(%d sec) { \"%s\" }"
		,	super.toString()
		,	INFO.UNIX_TIME_SEC
		,	dateString
		);
	}

	public OnCurrentTime(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, new TaskInnerObject(){});
	}

}
