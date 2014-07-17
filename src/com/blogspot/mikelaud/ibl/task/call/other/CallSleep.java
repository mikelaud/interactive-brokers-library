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
	extends CallTaskEx<CallSleep.In>
{
	//------------------------------------------------------------------------
	public static class In {
	
		/**
		 * Sleep time.
		 */
		public final long TIME;
		/**
		 * Time unit.
		 */
		public final TimeUnit TIME_UNIT;
		
		public In(long aTime, TimeUnit aTimeUnit) {
			TIME = aTime;
			TIME_UNIT = aTimeUnit;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		long timeMs = TimeUnit.MILLISECONDS.convert(IN.TIME, IN.TIME_UNIT);
		Thread.sleep(timeMs);
		OnSleepDone.Info info = new OnSleepDone.Info(IN.TIME, IN.TIME_UNIT);
		new OnSleepDone(mContext, info).call();
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s(%d %s)"
		,	super.toString()
		,	IN.TIME
		,	IN.TIME_UNIT.name().toLowerCase()
		);
	}

	public CallSleep(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, CallType.sleep);
	}

	public CallSleep(ConnectionContext aContext, long aTime, TimeUnit aTimeUnit) {
		this(aContext, new In(aTime, aTimeUnit));
	}

}
