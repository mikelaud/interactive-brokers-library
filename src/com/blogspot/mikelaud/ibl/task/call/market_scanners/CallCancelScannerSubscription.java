package com.blogspot.mikelaud.ibl.task.call.market_scanners;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;

/**
 * Call the CallCancelScannerSubscription call to stop
 * receiving market scanner results.
 */
public class CallCancelScannerSubscription
	extends CallTaskEx<CallCancelScannerSubscription.In>
{
	/**
	 * The Id that was specified
	 * in the call to CallReqScannerSubscription.
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
		getClientSocket().cancelScannerSubscription(getRequestId());
		return null;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	private CallCancelScannerSubscription(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallCancelScannerSubscription(ConnectionContext aContext) {
		this(aContext, new In());
	}

}
