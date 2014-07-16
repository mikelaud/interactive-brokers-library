package com.blogspot.mikelaud.nyse.task.event.contract_details;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.event.EventTaskEx;
import com.blogspot.mikelaud.nyse.task.event.EventType;
import com.ib.client.ContractDetails;

/**
 * This event is called only when CallReqContractDetails call
 * on the EClientSocket object has been called.
 */
public class OnContractDetails
	extends EventTaskEx<OnContractDetails.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The ID of the data request. Ensures that responses are matched
		 * to requests if several requests are in process.
		 */
		public final int REQ_ID;
		/**
		 * This structure contains a full description
		 * of the contract being looked up.
		 */
		public final ContractDetails CONTRACT_DETAILS;
		
		public Info(int aReqId, ContractDetails aContractDetails) {
			REQ_ID = aReqId;
			CONTRACT_DETAILS = aContractDetails;
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
		(	"%s[%d] { \"%s\" }"
		,	super.toString()
		,	INFO.REQ_ID
		,	INFO.CONTRACT_DETAILS.m_longName
		);
	}
	
	public OnContractDetails(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, EventType.contractDetails);
	}

}
