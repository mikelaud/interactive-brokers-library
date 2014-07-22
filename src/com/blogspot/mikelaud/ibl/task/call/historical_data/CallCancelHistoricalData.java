package com.blogspot.mikelaud.ibl.task.call.historical_data;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;

/**
 * Call the CallCancelHistoricalData call to stop receiving
 * historical data results.
 */
public class CallCancelHistoricalData
	extends CallTaskEx<CallCancelHistoricalData.In>
{
	/**
	 * The Id that was specified in the call to CallReqHistoricalData.
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
		getClientSocket().cancelHistoricalData(getRequestId());
		return null;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	private CallCancelHistoricalData(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallCancelHistoricalData(ConnectionContext aContext) {
		this(aContext, new In());
	}

}
