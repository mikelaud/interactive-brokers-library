package com.blogspot.mikelaud.ibl.task.call.market_data;

import java.util.List;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.ib.client.Contract;
import com.ib.client.TagValue;

/**
 * Call this call to request market data.
 * The market data will be returned by the
 * OnTickPrice, OnTickSize, OnTickOptionComputation,
 * OnTickGeneric, OnTickString and OnTickEFP events.
 */
public class CallReqMktData
	extends CallTaskEx<CallReqMktData.In>
{
	/**
	 * The ticker id. Must be a unique value.
	 * When the market data returns, it will be identified by this tag.
	 * This is also used when canceling the market data.
	 */
	@Override
	public boolean hasRequestId() {
		return true;
	}
	//------------------------------------------------------------------------
	public static class In {
	
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
		
		public In
		(	Contract aContract
		,	String aGenericTicklist
		,	boolean aSnapshot
		,	List<TagValue> aMktDataOptions
		) {
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
		(	getRequestId()
		,	IN.CONTRACT
		,	IN.GENERIC_TICKLIST
		,	IN.SNAPSHOT
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s { genericTicklist=\"%s\" snapshot=\"%b\" }"
		,	super.toString()
		,	IN.GENERIC_TICKLIST
		,	IN.SNAPSHOT
		);
	}

	public CallReqMktData(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallReqMktData
	(	ConnectionContext aContext
	,	Contract aContract
	,	String aGenericTicklist
	,	boolean aSnapshot
	,	List<TagValue> aMktDataOptions
	) {
		this(aContext, new In
		(	aContract
		,	aGenericTicklist
		,	aSnapshot
		,	aMktDataOptions
		));
	}

}
