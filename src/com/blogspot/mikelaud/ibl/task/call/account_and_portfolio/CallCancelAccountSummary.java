package com.blogspot.mikelaud.ibl.task.call.account_and_portfolio;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;

/**
 * Cancels the request for Account Window Summary tab data.
 */
public class CallCancelAccountSummary
	extends CallTaskEx<CallCancelAccountSummary.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The ID of the data request being canceled.
		 */
		public final int REQ_ID;
		
		public Info(int aReqId) {
			REQ_ID = aReqId;
		}
		
	}
	//------------------------------------------------------------------------
	
	@Override
	protected Task onCall() throws Exception {
		getClientSocket().cancelAccountSummary(INFO.REQ_ID);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s[%d]"
		,	super.toString()
		,	INFO.REQ_ID
		);
	}

	public CallCancelAccountSummary(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.cancelAccountSummary);
	}

	public CallCancelAccountSummary
	(	ConnectionContext aContext
	,	int aReqId
	) {
		this(aContext, new Info(aReqId));
	}

}
