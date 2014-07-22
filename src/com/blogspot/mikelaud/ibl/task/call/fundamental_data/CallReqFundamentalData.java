package com.blogspot.mikelaud.ibl.task.call.fundamental_data;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.ib.client.Contract;

/**
 * Call this call to receive Reuters global fundamental data for stocks.
 * There must be a subscription to Reuters Fundamental set up in
 * Account Management before you can receive this data.
 * 
 * CallReqFundamentalData can handle conid specified in the Contract object,
 * but not tradingClass or multiplier. This is because CallReqFundamentalData
 * is used only for stocks and stocks do not have a multiplier and trading class.
 */
public class CallReqFundamentalData
	extends CallTaskEx<CallReqFundamentalData.In>
{
	/**
	 * The ID of the data request. Ensures that responses are matched
	 * to requests if several requests are in process.
	 */
	@Override
	public boolean hasRequestId() {
		return true;
	}
	//------------------------------------------------------------------------
	public static class In {
	
		/**
		 * This structure contains a description of the contract for which
		 * Reuters Fundamental data is being requested.
		 */
		public final Contract CONTRACT;
		/**
		 * One of the following XML reports:
		 *     ReportSnapshot (company overview)
		 *     ReportsFinSummary (financial summary)
		 *     ReportRatios (financial ratios)
		 *     ReportsFinStatements (financial statements)
		 *     RESC (analyst estimates)
		 *     CalendarReport (company calendar)
		 */
		public final String REPORT_TYPE;
				
		public In
		(	Contract aContract
		,	String aReportType
		) {
			CONTRACT = aContract;
			REPORT_TYPE = aReportType;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqFundamentalData
		(	getRequestId()
		,	IN.CONTRACT
		,	IN.REPORT_TYPE
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s { reportType=\"%s\" }"
		,	super.toString()
		,	IN.REPORT_TYPE
		);
	}

	public CallReqFundamentalData(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallReqFundamentalData
	(	ConnectionContext aContext
	,	Contract aContract
	,	String aReportType
	) {
		this(aContext, new In
		(	aContract
		,	aReportType
		));
	}

}
