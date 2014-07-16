package com.blogspot.mikelaud.ibl.task.event.contract_details;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;
import com.blogspot.mikelaud.ibl.task.event.EventType;

/**
 * This event is called once all contract details
 * for a given request are received.
 * This helps to define the end of an option chain.
 */
public class OnContractDetailsEnd
	extends EventTaskEx<OnContractDetailsEnd.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The Id of the data request.
		 */
		public final int REQ_ID;
		
		public Info(int aReqId) {
			REQ_ID = aReqId;
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
	
	public OnContractDetailsEnd(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, EventType.contractDetailsEnd);
	}

}
