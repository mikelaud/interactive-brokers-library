package com.blogspot.mikelaud.ibl.task.event.orders;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;
import com.ib.client.UnderComp;

/**
 * Upon accepting a Delta-Neutral RFQ(request for quote),
 * the server sends a OnDeltaNeutralValidation event
 * with the UnderComp structure.
 * 
 * If the delta and price fields are empty in the original request,
 * the confirmation will contain the current values from the server.
 * 
 * These values are locked when the RFQ is processed and
 * remain locked until the RFQ is canceled.
 */
public class OnDeltaNeutralValidation
	extends EventTaskEx<OnDeltaNeutralValidation.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The Id of the data request.
		 */
		public final int REQ_ID;
		/**
		 * Underlying component.
		 */
		public final UnderComp UNDER_COMP;
		
		public Info(int aReqId, UnderComp aUnderComp) {
			REQ_ID = aReqId;
			UNDER_COMP = aUnderComp;
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
	
	public OnDeltaNeutralValidation(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, new TaskInnerObject(){});
	}

}
