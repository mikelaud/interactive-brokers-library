package com.blogspot.mikelaud.nyse.task.call.orders;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.call.CallTaskEx;
import com.blogspot.mikelaud.nyse.task.call.CallType;

/**
 * Use this call to cancel all open orders globally.
 * It cancels both API and TWS open orders.
 * 
 * If the order was created in TWS, it also gets canceled.
 * If the order was initiated in the API, it also gets canceled.
 */
public class CallReqGlobalCancel
	extends CallTaskEx<CallReqGlobalCancel.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		public Info() {
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
		return String.format
		(	"%s"
		,	super.toString()
		);
	}

	private CallReqGlobalCancel(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.reqGlobalCancel);
	}

	public CallReqGlobalCancel(ConnectionContext aContext) {
		this(aContext, new Info());
	}

}
