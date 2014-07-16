package com.blogspot.mikelaud.ibl.task.call.executions;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;
import com.ib.client.ExecutionFilter;

/**
 * When this call is called, the execution reports from the last 24 hours
 * that meet the filter criteria are downloaded to the client
 * via the OnExecDetails method.
 * 
 * To view executions beyond the past 24 hours, open the Trade Log in TWS and,
 * while the Trade Log is displayed, request the executions again from the API.
 */
public class CallReqExecutions
	extends CallTaskEx<CallReqExecutions.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * Request Id.
		 */
		public final int REQ_ID;
		/**
		 * The filter criteria used to determine
		 * which execution reports are returned.
		 */
		public final ExecutionFilter FILTER;
		
		public Info
		(	int aReqId
		,	ExecutionFilter aFilter
		) {
			REQ_ID = aReqId;
			FILTER = aFilter;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqExecutions
		(	INFO.REQ_ID
		,	INFO.FILTER
		);
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

	public CallReqExecutions(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.reqExecutions);
	}

	public CallReqExecutions
	(	ConnectionContext aContext
	,	int aReqId
	,	ExecutionFilter aFilter
	) {
		this(aContext, new Info
		(	aReqId
		,	aFilter
		));
	}

}
