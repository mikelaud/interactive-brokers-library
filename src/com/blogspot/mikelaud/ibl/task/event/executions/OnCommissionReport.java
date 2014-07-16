package com.blogspot.mikelaud.nyse.task.event.executions;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.event.EventTaskEx;
import com.blogspot.mikelaud.nyse.task.event.EventType;
import com.ib.client.CommissionReport;

/**
 * The OnCommissionReport event is triggered as follows:
 *   - immediately after a trade execution
 *   - by calling CallReqExecutions
 */
public class OnCommissionReport
	extends EventTaskEx<OnCommissionReport.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The structure that contains commission details.
		 */
		public final CommissionReport COMMISSION_REPORT;
		
		public Info(CommissionReport aCommissionReport) {
			COMMISSION_REPORT = aCommissionReport;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onEvent() throws Exception {
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s"
		,	super.toString()
		);
	}
	
	public OnCommissionReport(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, EventType.commissionReport);
	}

}
