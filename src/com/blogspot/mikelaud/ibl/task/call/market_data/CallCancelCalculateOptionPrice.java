package com.blogspot.mikelaud.ibl.task.call.market_data;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;

/**
 * Call this call to cancel a request to calculate the option price
 * and greek values for a supplied volatility and underlying price.
 */
public class CallCancelCalculateOptionPrice
	extends CallTaskEx<CallCancelCalculateOptionPrice.In>
{
	//------------------------------------------------------------------------
	public static class In {
	
		/**
		 * The ticker id.
		 */
		public final int REQ_ID;
		
		public In(int aReqId) {
			REQ_ID = aReqId;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().cancelCalculateOptionPrice(IN.REQ_ID);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s[%d]"
		,	super.toString()
		,	IN.REQ_ID
		);
	}

	public CallCancelCalculateOptionPrice(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, CallType.cancelCalculateOptionPrice);
	}

	public CallCancelCalculateOptionPrice(ConnectionContext aContext, int aReqId) {
		this(aContext, new In(aReqId));
	}

}
