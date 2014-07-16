package com.blogspot.mikelaud.nyse.task.call.financial_advisors;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.call.CallTaskEx;
import com.blogspot.mikelaud.nyse.task.call.CallType;

/**
 * Call this call to request the list of managed accounts.
 * The list will be returned by the OnManagedAccounts event on the EWrapper.
 * 
 * Note: This request can only be made when connected
 *       to a Financial Advisor (FA) account.
 */
public class CallReqManagedAccts
	extends CallTaskEx<CallReqManagedAccts.Info>
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
		getClientSocket().reqManagedAccts();
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s"
		,	super.toString()
		);
	}

	private CallReqManagedAccts(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.reqManagedAccts);
	}

	public CallReqManagedAccts(ConnectionContext aContext) {
		this(aContext, new Info());
	}

}
