package com.blogspot.mikelaud.nyse.task.call.account_and_portfolio;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.call.CallTaskEx;
import com.blogspot.mikelaud.nyse.task.call.CallType;

/**
 * Cancels real-time position updates.
 */
public class CallCancelPositions
	extends CallTaskEx<CallCancelPositions.Info>
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
		getClientSocket().cancelPositions();
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s"
		,	super.toString()
		);
	}

	private CallCancelPositions(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.cancelPositions);
	}

	public CallCancelPositions(ConnectionContext aContext) {
		this(aContext, new Info());
	}

}
