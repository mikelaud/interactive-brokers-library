package com.blogspot.mikelaud.ibl.task.call.account_and_portfolio;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;

/**
 * Cancels the request for Account Window Summary tab data.
 */
public class CallCancelAccountSummary
	extends CallTaskEx<CallCancelAccountSummary.In>
{
	/**
	 * The ID of the data request being canceled.
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
		getClientSocket().cancelAccountSummary(getRequestId());
		return null;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	private CallCancelAccountSummary(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallCancelAccountSummary(ConnectionContext aContext) {
		this(aContext, new In());
	}

}
