package com.blogspot.mikelaud.ibl.task.call.market_data;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;

/**
 * The API can receive frozen market data from Trader Workstation.
 * Frozen market data is the last data recorded in our system.
 * During normal trading hours, the API receives real-time market data.
 * 
 * If you use this function, you are telling TWS to automatically switch
 * to frozen market data after the close.
 * 
 * Then, before the opening of the next trading day,
 * market data will automatically switch back to real-time market data.
 */
public class CallReqMarketDataType
	extends CallTaskEx<CallReqMarketDataType.In>
{
	@Override
	public boolean hasRequestId() {
		return false;
	}
	//------------------------------------------------------------------------
	public static class In {
	
		/**
		 * 1 for real-time streaming market data or 2 for frozen market data.
		 */
		public final int TYPE;
		
		public In(int aType) {
			TYPE = aType;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqMarketDataType(IN.TYPE);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s(%d)"
		,	super.toString()
		,	IN.TYPE
		);
	}

	public CallReqMarketDataType(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallReqMarketDataType(ConnectionContext aContext, int aType) {
		this(aContext, new In(aType));
	}

}
