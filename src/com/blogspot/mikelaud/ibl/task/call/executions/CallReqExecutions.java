package com.blogspot.mikelaud.ibl.task.call.executions;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.out.OutEvent;
import com.blogspot.mikelaud.ibl.out.OutEvents;
import com.blogspot.mikelaud.ibl.out.OutTerminator;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.event.executions.OnCommissionReport;
import com.blogspot.mikelaud.ibl.task.event.executions.OnExecDetails;
import com.blogspot.mikelaud.ibl.task.event.executions.OnExecDetailsEnd;
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
	extends CallTaskEx<CallReqExecutions.In>
{
	/**
	 * Request Id.
	 */
	@Override
	public boolean hasRequestId() {
		return true;
	}
	//------------------------------------------------------------------------
	public static class In {
	
		/**
		 * The filter criteria used to determine
		 * which execution reports are returned.
		 */
		public final ExecutionFilter FILTER;
		
		public In(ExecutionFilter aFilter) {
			FILTER = aFilter;
		}
		
	}
	//------------------------------------------------------------------------

	public final OutEvent<OnCommissionReport> OUT_COMMISSION_REPORT;
	public final OutEvents<OnExecDetails> OUT_EXEC_DETAILS;
	public final OutTerminator<OnExecDetailsEnd> OUT_EXEC_DETAILS_END;
	
	//------------------------------------------------------------------------
	
	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqExecutions
		(	getRequestId()
		,	IN.FILTER
		);
		return null;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public CallReqExecutions(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
		OUT_COMMISSION_REPORT = new OutEvent<>(this, OnCommissionReport.class);
		OUT_EXEC_DETAILS = new OutEvents<>(this, OnExecDetails.class);
		OUT_EXEC_DETAILS_END = new OutTerminator<>(this, OnExecDetailsEnd.class);
	}

}
