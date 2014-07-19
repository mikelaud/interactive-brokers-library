package com.blogspot.mikelaud.ibl.task.call.real_time_bars;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;

/**
 * Call this call to stop receiving real time bar results.
 */
public class CallCancelRealTimeBars
	extends CallTaskEx<CallCancelRealTimeBars.In>
{
	//------------------------------------------------------------------------
	public static class In {
	
		/**
		 * The Id that was specified in the call to CallReqRealTimeBars.
		 */
		public final int TICKER_ID;
		
		public In(int aTickerId) {
			TICKER_ID = aTickerId;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().cancelRealTimeBars(IN.TICKER_ID);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s[%d]"
		,	super.toString()
		,	IN.TICKER_ID
		);
	}

	public CallCancelRealTimeBars(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallCancelRealTimeBars(ConnectionContext aContext, int aTickerId) {
		this(aContext, new In(aTickerId));
	}

}
