package com.blogspot.mikelaud.ibl.task.event.contract_details;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;
import com.blogspot.mikelaud.ibl.task.event.EventType;
import com.ib.client.ContractDetails;

/**
 * This event is called only when CallReqContractDetails call
 * on the EClientSocket object has been called for bonds.
 */
public class OnBondContractDetails
	extends EventTaskEx<OnBondContractDetails.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The ID of the data request.
		 */
		public final int REQ_ID;
		/**
		 * This structure contains a full description
		 * of the bond contract being looked up.
		 */
		public final ContractDetails CONTRACT_DETAILS;
		
		public Info(int aReqId, ContractDetails aContractDetails) {
			REQ_ID = aReqId;
			CONTRACT_DETAILS = aContractDetails;
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
		(	"%s[%d]"
		,	super.toString()
		,	INFO.REQ_ID
		);
	}
	
	public OnBondContractDetails(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, EventType.bondContractDetails);
	}

}
