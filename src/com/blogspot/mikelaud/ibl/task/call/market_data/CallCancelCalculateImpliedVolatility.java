package com.blogspot.mikelaud.ibl.task.call.market_data;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;

/**
 * Call this call to cancel a request to calculate volatility
 * for a supplied option price and underlying price.
 */
public class CallCancelCalculateImpliedVolatility
	extends CallTaskEx<CallCancelCalculateImpliedVolatility.In>
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
		getClientSocket().cancelCalculateImpliedVolatility(IN.REQ_ID);
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

	public CallCancelCalculateImpliedVolatility(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallCancelCalculateImpliedVolatility(ConnectionContext aContext, int aReqId) {
		this(aContext, new In(aReqId));
	}

}
