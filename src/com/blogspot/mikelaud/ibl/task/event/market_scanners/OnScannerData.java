package com.blogspot.mikelaud.ibl.task.event.market_scanners;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;
import com.ib.client.ContractDetails;

/**
 * This event receives the requested market scanner data results.
 */
public class OnScannerData
	extends EventTaskEx<OnScannerData.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The ID of the request to which this row is responding.
		 */
		public final int REQ_ID;
		/**
		 * The ranking within the response of this bar.
		 */
		public final int RANK;
		/**
		 * This structure contains a full description
		 * of the contract that was executed.
		 */
		public final ContractDetails CONTRACT_DETAILS;
		/**
		 * Varies based on query.
		 */
		public final String DISTANCE;
		/**
		 * Varies based on query.
		 */
		public final String BENCHMARK;
		/**
		 * Varies based on query.
		 */
		public final String PROJECTION;
		/**
		 * Describes combo legs when scan is returning EFP.
		 */
		public final String LEGS_STR;
		
		public Info
		(	int aReqId
		,	int aRank
		,	ContractDetails aContractDetails
		,	String aDistance
		,	String aBenchmark
		,	String aProjection
		,	String aLegsStr
		) {
			REQ_ID = aReqId;
			RANK = aRank;
			CONTRACT_DETAILS = aContractDetails;
			DISTANCE = aDistance;
			BENCHMARK = aDistance;
			PROJECTION = aProjection;
			LEGS_STR = aLegsStr;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	public int getRequestId() {
		return INFO.REQ_ID;
	}

	@Override
	protected Task onEvent() throws Exception {
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s[%d] { rank=\"%d\" distance=\"%s\" benchmark=\"%s\" projection=\"%s\" legsStr=\"%s\" }"
		,	super.toString()
		,	INFO.REQ_ID
		,	INFO.RANK
		,	INFO.DISTANCE
		,	INFO.BENCHMARK
		,	INFO.PROJECTION
		,	INFO.LEGS_STR
		);
	}
	
	public OnScannerData(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, new TaskInnerObject(){});
	}

}
