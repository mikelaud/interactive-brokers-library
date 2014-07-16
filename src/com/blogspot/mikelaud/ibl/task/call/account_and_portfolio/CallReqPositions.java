package com.blogspot.mikelaud.ibl.task.call.account_and_portfolio;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;

/**
 * Requests real-time position data for all accounts.
 * 
 * Note: This request can only be made when connected
 *       to a Financial Advisor (FA) account.
 */
public class CallReqPositions
	extends CallTaskEx<CallReqPositions.Info>
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
		getClientSocket().reqPositions();
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s"
		,	super.toString()
		);
	}

	private CallReqPositions(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.reqPositions);
	}

	public CallReqPositions(ConnectionContext aContext) {
		this(aContext, new Info());
	}

}
