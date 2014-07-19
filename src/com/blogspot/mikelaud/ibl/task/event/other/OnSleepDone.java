package com.blogspot.mikelaud.ibl.task.event.other;

import java.util.concurrent.TimeUnit;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;

/**
 * Artificial event for sync call CallSleep.
 */
public class OnSleepDone
	extends EventTaskEx<OnSleepDone.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * Sleep time.
		 */
		public final long TIME;
		/**
		 * Time unit.
		 */
		public final TimeUnit TIME_UNIT;
		
		public Info(long aTime, TimeUnit aTimeUnit) {
			TIME = aTime;
			TIME_UNIT = aTimeUnit;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onEvent() throws Exception {
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s(%d %s)"
		,	super.toString()
		,	INFO.TIME
		,	INFO.TIME_UNIT.name().toLowerCase()
		);
	}

	public OnSleepDone(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, new TaskInnerObject(){});
	}

}
