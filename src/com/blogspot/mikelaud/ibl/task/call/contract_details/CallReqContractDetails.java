package com.blogspot.mikelaud.ibl.task.call.contract_details;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.out.OutEvents;
import com.blogspot.mikelaud.ibl.out.OutTerminator;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.event.contract_details.OnBondContractDetails;
import com.blogspot.mikelaud.ibl.task.event.contract_details.OnContractDetails;
import com.blogspot.mikelaud.ibl.task.event.contract_details.OnContractDetailsEnd;
import com.ib.client.Contract;

/**
 * Call this call to download all details for a particular contract.
 * The contract details will be received
 * via the OnContractDetails method on the EWrapper.
 */
public class CallReqContractDetails
	extends CallTaskEx<CallReqContractDetails.In>
{
	//------------------------------------------------------------------------
	public static class In {
	
		/**
		 * The ID of the data request. Ensures that responses are matched
		 * to requests if several requests are in process.
		 */
		public final int REQ_ID;
		/**
		 * This class contains attributes used to describe the contract.
		 */
		public final Contract CONTRACT;
		
		public In
		(	int aReqId
		,	Contract aContract
		) {
			REQ_ID = aReqId;
			CONTRACT = aContract;
		}
		
	}
	//------------------------------------------------------------------------

	public final OutEvents<OnContractDetails> OUT_CONTRACT_DETAILS;
	public final OutEvents<OnBondContractDetails> OUT_BOND_CONTRACT_DETAILS;
	public final OutTerminator<OnContractDetailsEnd> OUT_CONTRACT_DETAILS_END;
	
	//------------------------------------------------------------------------
	
	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqContractDetails
		(	getRequestId()
		,	IN.CONTRACT
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

	public CallReqContractDetails(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
		OUT_CONTRACT_DETAILS = new OutEvents<>(getRouter());
		OUT_BOND_CONTRACT_DETAILS = new OutEvents<>(getRouter());
		OUT_CONTRACT_DETAILS_END = new OutTerminator<>(getRouter());
	}

}
