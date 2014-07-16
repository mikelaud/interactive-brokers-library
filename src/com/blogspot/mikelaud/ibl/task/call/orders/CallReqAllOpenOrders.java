package com.blogspot.mikelaud.ibl.task.call.orders;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;

/**
 * Call this call to request all open orders that were placed
 * from all API clients linked to one TWS, and also from the TWS.
 * 
 * Note that you can run up to 8 API clients from a single TWS.
 * Each open order will be fed back through the OnOpenOrder
 * and OnOrderStatus events on the EWrapper.
 * 
 * Note: No association is made between the returned orders
 *       and the requesting client.
 */
public class CallReqAllOpenOrders
	extends CallTaskEx<CallReqAllOpenOrders.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		public Info() {
			// void
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqAllOpenOrders();
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s"
		,	super.toString()
		);
	}

	private CallReqAllOpenOrders(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.reqAllOpenOrders);
	}

	public CallReqAllOpenOrders(ConnectionContext aContext) {
		this(aContext, new Info());
	}

}
