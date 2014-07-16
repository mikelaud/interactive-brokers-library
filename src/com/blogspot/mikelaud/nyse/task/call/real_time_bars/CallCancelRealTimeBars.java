package com.blogspot.mikelaud.nyse.task.call.real_time_bars;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.call.CallTaskEx;
import com.blogspot.mikelaud.nyse.task.call.CallType;

/**
 * Call this call to stop receiving real time bar results.
 */
public class CallCancelRealTimeBars
	extends CallTaskEx<CallCancelRealTimeBars.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The Id that was specified in the call to CallReqRealTimeBars.
		 */
		public final int TICKER_ID;
		
		public Info(int aTickerId) {
			TICKER_ID = aTickerId;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().cancelRealTimeBars(INFO.TICKER_ID);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s[%d]"
		,	super.toString()
		,	INFO.TICKER_ID
		);
	}

	public CallCancelRealTimeBars(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.cancelRealTimeBars);
	}

	public CallCancelRealTimeBars(ConnectionContext aContext, int aTickerId) {
		this(aContext, new Info(aTickerId));
	}

}
