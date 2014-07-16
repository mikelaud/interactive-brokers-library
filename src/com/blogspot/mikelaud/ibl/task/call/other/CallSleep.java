package com.blogspot.mikelaud.ibl.task.call.other;

import java.util.concurrent.TimeUnit;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;
import com.blogspot.mikelaud.ibl.task.event.other.OnSleepDone;

/**
 * Sleep call.
 */
public class CallSleep
	extends CallTaskEx<CallSleep.Info>
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
	protected Task onCall() throws Exception {
		long timeMs = TimeUnit.MILLISECONDS.convert(INFO.TIME, INFO.TIME_UNIT);
		Thread.sleep(timeMs);
		new OnSleepDone(mContext, INFO).call();
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

	public CallSleep(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.sleep);
	}

	public CallSleep(ConnectionContext aContext, long aTime, TimeUnit aTimeUnit) {
		this(aContext, new Info(aTime, aTimeUnit));
	}

}
