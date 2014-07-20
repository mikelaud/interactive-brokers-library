package com.blogspot.mikelaud.ibl.task.call.orders;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.out.OutEvents;
import com.blogspot.mikelaud.ibl.out.OutTerminator;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.event.orders.OnOpenOrder;
import com.blogspot.mikelaud.ibl.task.event.orders.OnOpenOrderEnd;
import com.blogspot.mikelaud.ibl.task.event.orders.OnOrderStatus;

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
	extends CallTaskEx<CallReqAutoOpenOrders.In>
{
	//------------------------------------------------------------------------
	public static class In {
	
		/**
		 * If set to TRUE, newly created TWS orders
		 * will be implicitly associated with the client.
		 * If set to FALSE, no association will be made.
		 */
		public final boolean AUTO_BIND;
		
		public In(boolean aAutoBind) {
			AUTO_BIND = aAutoBind;
		}
		
	}
	//------------------------------------------------------------------------

	public final OutEvents<OnOrderStatus> OUT_ORDER_STATUS;
	public final OutEvents<OnOpenOrder> OUT_OPEN_ORDER;
	public final OutTerminator<OnOpenOrderEnd> OUT_OPEN_ORDER_END;

	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqAutoOpenOrders(IN.AUTO_BIND);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s { autoBind=\"%b\" }"
		,	super.toString()
		,	IN.AUTO_BIND
		);
	}

	public CallReqAutoOpenOrders(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
		OUT_ORDER_STATUS = new OutEvents<>(getRouter());
		OUT_OPEN_ORDER = new OutEvents<>(getRouter());
		OUT_OPEN_ORDER_END = new OutTerminator<>(getRouter());
	}

}
