package com.blogspot.mikelaud.ibl.task.call.orders;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;

/**
 * Use this call to cancel all open orders globally.
 * It cancels both API and TWS open orders.
 * 
 * If the order was created in TWS, it also gets canceled.
 * If the order was initiated in the API, it also gets canceled.
 */
public class CallReqGlobalCancel
	extends CallTaskEx<CallReqGlobalCancel.In>
{
	@Override
	public boolean hasRequestId() {
		return false;
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
		getClientSocket().reqGlobalCancel();
		return null;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	private CallReqGlobalCancel(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallReqGlobalCancel(ConnectionContext aContext) {
		this(aContext, new In());
	}

}
