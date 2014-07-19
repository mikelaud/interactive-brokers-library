package com.blogspot.mikelaud.ibl.task.call.market_depth;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.ib.client.Contract;

/**
 * Call this call to request market depth for a specific contract.
 * The market depth will be returned by the OnUpdateMktDepth
 * and OnUpdateMktDepthL2 events.
 */
public class CallReqMktDepth
	extends CallTaskEx<CallReqMktDepth.In>
{
	//------------------------------------------------------------------------
	public static class In {
	
		/**
		 * The ticker Id. Must be a unique value. When the market depth data
		 * returns, it will be identified by this tag. This is also used when
		 * canceling the market depth.
		 */
		public final int TICKER_ID;
		/**
		 * This class contains attributes used to describe the contract.
		 */
		public final Contract CONTRACT;
		/**
		 * Specifies the number of market depth rows to return.
		 */
		public final int NUM_ROWS;
		
		public In
		(	int aTickerId
		,	Contract aContract
		,	int aNumRows
		) {
			TICKER_ID = aTickerId;
			CONTRACT = aContract;
			NUM_ROWS = aNumRows;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqMktDepth
		(	IN.TICKER_ID
		,	IN.CONTRACT
		,	IN.NUM_ROWS
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s[%d] { numRows=\"%d\" }"
		,	super.toString()
		,	IN.TICKER_ID
		,	IN.NUM_ROWS
		);
	}

	public CallReqMktDepth(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallReqMktDepth
	(	ConnectionContext aContext
	,	int aTickerId
	,	Contract aContract
	,	int aNumRows
	) {
		this(aContext, new In
		(	aTickerId
		,	aContract
		,	aNumRows
		));
	}

}
