package com.blogspot.mikelaud.nyse.task.call.connection_and_server;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.call.CallTaskEx;
import com.blogspot.mikelaud.nyse.task.call.CallType;

/**
 * Call this call to terminate the connections with TWS.
 * Calling this call does not cancel orders that have already been sent.
 */
public class CallDisconnect
	extends CallTaskEx<CallDisconnect.Info>
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
		getClientSocket().eDisconnect();
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s"
		,	super.toString()
		);
	}

	private CallDisconnect(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.disconnect);
	}
	
	public CallDisconnect(ConnectionContext aContext) {
		this(aContext, new Info());
	}

}
