package com.blogspot.mikelaud.ibl.task.call.historical_data;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;

/**
 * Call the CallCancelHistoricalData call to stop receiving
 * historical data results.
 */
public class CallCancelHistoricalData
	extends CallTaskEx<CallCancelHistoricalData.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The Id that was specified in the call to CallReqHistoricalData.
		 */
		public final int TICKER_ID;
		
		public Info(int aTickerId) {
			TICKER_ID = aTickerId;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().cancelHistoricalData(INFO.TICKER_ID);
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

	public CallCancelHistoricalData(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.cancelHistoricalData);
	}

	public CallCancelHistoricalData(ConnectionContext aContext, int aTickerId) {
		this(aContext, new Info(aTickerId));
	}

}
