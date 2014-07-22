package com.blogspot.mikelaud.ibl.task.call.market_data;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;

/**
 * Call this call to cancel a request to calculate the option price
 * and greek values for a supplied volatility and underlying price.
 */
public class CallCancelCalculateOptionPrice
	extends CallTaskEx<CallCancelCalculateOptionPrice.In>
{
	/**
	 * The ticker id.
	 */
	@Override
	public boolean hasRequestId() {
		return true;
	}
	//------------------------------------------------------------------------
	public static class In {
	
		public In() {
			// void
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().cancelCalculateOptionPrice(getRequestId());
		return null;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	private CallCancelCalculateOptionPrice(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallCancelCalculateOptionPrice(ConnectionContext aContext) {
		this(aContext, new In());
	}

}
