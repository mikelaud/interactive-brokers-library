package com.blogspot.mikelaud.nyse.task.call.market_data;

import java.util.List;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.call.CallTaskEx;
import com.blogspot.mikelaud.nyse.task.call.CallType;
import com.ib.client.Contract;
import com.ib.client.TagValue;

/**
 * Call this call to request market data.
 * The market data will be returned by the
 * OnTickPrice, OnTickSize, OnTickOptionComputation,
 * OnTickGeneric, OnTickString and OnTickEFP events.
 */
public class CallReqMktData
	extends CallTaskEx<CallReqMktData.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The ticker id. Must be a unique value.
		 * When the market data returns, it will be identified by this tag.
		 * This is also used when canceling the market data.
		 */
		public final int TICKER_ID;
		/**
		 * This class contains attributes used to describe the contract.
		 */
		public final Contract CONTRACT;
		/**
		 * A comma delimited list of generic tick types.
		 * Tick types can be found in the Generic Tick Types page.
		 */
		public final String GENERIC_TICKLIST;
		/**
		 * Check to return a single snapshot of market data
		 * and have the market data subscription cancel.
		 * Do not enter any genericTicklist values if you use snapshot.
		 */
		public final boolean SNAPSHOT;
		/**
		 * For internal use only. Use default value XYZ.
		 */
		public final List<TagValue> MKT_DATA_OPTIONS;
		
		public Info
		(	int aTickerId
		,	Contract aContract
		,	String aGenericTicklist
		,	boolean aSnapshot
		,	List<TagValue> aMktDataOptions
		) {
			TICKER_ID = aTickerId;
			CONTRACT = aContract;
			GENERIC_TICKLIST = aGenericTicklist;
			SNAPSHOT = aSnapshot;
			MKT_DATA_OPTIONS = aMktDataOptions;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqMktData
		(	INFO.TICKER_ID
		,	INFO.CONTRACT
		,	INFO.GENERIC_TICKLIST
		,	INFO.SNAPSHOT
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s[%d] { genericTicklist=\"%s\" snapshot=\"%b\" }"
		,	super.toString()
		,	INFO.TICKER_ID
		,	INFO.GENERIC_TICKLIST
		,	INFO.SNAPSHOT
		);
	}

	public CallReqMktData(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.reqMktData);
	}

	public CallReqMktData
	(	ConnectionContext aContext
	,	int aTickerId
	,	Contract aContract
	,	String aGenericTicklist
	,	boolean aSnapshot
	,	List<TagValue> aMktDataOptions
	) {
		this(aContext, new Info
		(	aTickerId
		,	aContract
		,	aGenericTicklist
		,	aSnapshot
		,	aMktDataOptions
		));
	}

}
