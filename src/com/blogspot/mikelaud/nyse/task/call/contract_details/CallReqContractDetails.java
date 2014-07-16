package com.blogspot.mikelaud.nyse.task.call.contract_details;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.call.CallTaskEx;
import com.blogspot.mikelaud.nyse.task.call.CallType;
import com.ib.client.Contract;

/**
 * Call this call to download all details for a particular contract.
 * The contract details will be received
 * via the OnContractDetails method on the EWrapper.
 */
public class CallReqContractDetails
	extends CallTaskEx<CallReqContractDetails.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The ID of the data request. Ensures that responses are matched
		 * to requests if several requests are in process.
		 */
		public final int REQ_ID;
		/**
		 * This class contains attributes used to describe the contract.
		 */
		public final Contract CONTRACT;
		
		public Info
		(	int aReqId
		,	Contract aContract
		) {
			REQ_ID = aReqId;
			CONTRACT = aContract;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqContractDetails
		(	getRequestId()
		,	INFO.CONTRACT
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s[%d]"
		,	super.toString()
		,	getRequestId()
		);
	}

	public CallReqContractDetails(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.reqContractDetails);
	}

	public CallReqContractDetails
	(	ConnectionContext aContext
	,	int aReqId
	,	Contract aContract
	) {
		this(aContext, new Info
		(	aReqId
		,	aContract
		));
	}

}
