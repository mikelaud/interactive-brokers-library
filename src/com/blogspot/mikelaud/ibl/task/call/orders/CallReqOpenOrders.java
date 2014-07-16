package com.blogspot.mikelaud.nyse.task.call.orders;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.call.CallTaskEx;
import com.blogspot.mikelaud.nyse.task.call.CallType;

/**
 * Call this call to request any open orders
 * that were placed from this API client.
 * 
 * Each open order will be fed back through the EventOpenOrder
 * and OnOrderStatus events on the EWrapper.
 * 
 * Note: The client with a clientId of "0"
 *       will also receive the TWS-owned open orders.
 *       These orders will be associated with the client
 *       and a new orderId will be generated.
 *       This association will persist over multiple API and TWS sessions.
 */
public class CallReqOpenOrders
	extends CallTaskEx<CallReqOpenOrders.Info>
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
		getClientSocket().reqOpenOrders();
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s"
		,	super.toString()
		);
	}

	private CallReqOpenOrders(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.reqOpenOrders);
	}

	public CallReqOpenOrders(ConnectionContext aContext) {
		this(aContext, new Info());
	}

}
