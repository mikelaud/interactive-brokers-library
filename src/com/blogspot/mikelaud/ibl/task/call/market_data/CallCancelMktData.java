package com.blogspot.mikelaud.ibl.task.call.market_data;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;

/**
 * After calling this call,
 * market data for the specified Id will stop flowing.
 */
public class CallCancelMktData
	extends CallTaskEx<CallCancelMktData.In>
{
	/**
	 * The Id that was specified in the call to CallReqMktData.
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
		getClientSocket().cancelMktData(getRequestId());
		return null;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	private CallCancelMktData(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallCancelMktData(ConnectionContext aContext) {
		this(aContext, new In());
	}

}
