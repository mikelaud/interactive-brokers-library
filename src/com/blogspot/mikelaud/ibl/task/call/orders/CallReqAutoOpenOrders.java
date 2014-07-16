package com.blogspot.mikelaud.nyse.task.call.orders;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.call.CallTaskEx;
import com.blogspot.mikelaud.nyse.task.call.CallType;

/**
 * Call this call to request that newly created TWS orders
 * be implicitly associated with the client.
 * 
 * When a new TWS order is created, the order will be associated
 * with the client and automatically fed back through the OnOpenOrder
 * and OnOrderStatus events on the EWrapper.
 * 
 * Note: TWS orders can only be bound to clients with a clientId of 0.
 */
public class CallReqAutoOpenOrders
	extends CallTaskEx<CallReqAutoOpenOrders.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * If set to TRUE, newly created TWS orders
		 * will be implicitly associated with the client.
		 * If set to FALSE, no association will be made.
		 */
		public final boolean AUTO_BIND;
		
		public Info(boolean aAutoBind) {
			AUTO_BIND = aAutoBind;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqAutoOpenOrders(INFO.AUTO_BIND);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s { autoBind=\"%b\" }"
		,	super.toString()
		,	INFO.AUTO_BIND
		);
	}

	public CallReqAutoOpenOrders(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.reqAutoOpenOrders);
	}

	public CallReqAutoOpenOrders(ConnectionContext aContext, boolean aAutoBind) {
		this(aContext, new Info(aAutoBind));
	}

}
