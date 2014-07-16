package com.blogspot.mikelaud.nyse.task.call.market_data;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.call.CallTaskEx;
import com.blogspot.mikelaud.nyse.task.call.CallType;

/**
 * Call this call to cancel a request to calculate the option price
 * and greek values for a supplied volatility and underlying price.
 */
public class CallCancelCalculateOptionPrice
	extends CallTaskEx<CallCancelCalculateOptionPrice.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The ticker id.
		 */
		public final int REQ_ID;
		
		public Info(int aReqId) {
			REQ_ID = aReqId;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().cancelCalculateOptionPrice(INFO.REQ_ID);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s[%d]"
		,	super.toString()
		,	INFO.REQ_ID
		);
	}

	public CallCancelCalculateOptionPrice(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.cancelCalculateOptionPrice);
	}

	public CallCancelCalculateOptionPrice(ConnectionContext aContext, int aReqId) {
		this(aContext, new Info(aReqId));
	}

}
