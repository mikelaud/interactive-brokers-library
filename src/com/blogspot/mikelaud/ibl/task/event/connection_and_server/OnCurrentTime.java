package com.blogspot.mikelaud.ibl.task.event.connection_and_server;

import com.blogspot.mikelaud.ibl.Config;
import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;
import com.blogspot.mikelaud.ibl.util.IblTimeZone;

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

	@Override
	public int getRequestId() {
		return Config.getNoRequestId();
	}

	@Override
	protected Task onEvent() throws Exception {
		return null;
	}

	@Override
	public String toString() {
		String dateString = IblTimeZone.NEW_YORK.toDate(INFO.UNIX_TIME_SEC);
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
