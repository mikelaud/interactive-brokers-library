package com.blogspot.mikelaud.ibl.task.call.market_data;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;

/**
 * After calling this call,
 * market data for the specified Id will stop flowing.
 */
public class CallCancelMktData
	extends CallTaskEx<CallCancelMktData.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The Id that was specified in the call to CallReqMktData.
		 */
		public final int TICKER_ID;
		
		public Info(int aTickerId) {
			TICKER_ID = aTickerId;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().cancelMktData(INFO.TICKER_ID);
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

	public CallCancelMktData(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.cancelMktData);
	}

	public CallCancelMktData(ConnectionContext aContext, int aTickerId) {
		this(aContext, new Info(aTickerId));
	}

}
