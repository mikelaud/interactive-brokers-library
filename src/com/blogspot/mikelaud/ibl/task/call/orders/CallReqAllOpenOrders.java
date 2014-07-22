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
	extends CallTaskEx<CallReqAllOpenOrders.In>
{
	@Override
	public boolean hasRequestId() {
		return false;
	}
	//------------------------------------------------------------------------
	public static class In {
	
		public In() {
			// void
		}
		
	}
	//------------------------------------------------------------------------

	public final OutEvents<OnOrderStatus> OUT_ORDER_STATUS;
	public final OutEvents<OnOpenOrder> OUT_OPEN_ORDER;
	public final OutTerminator<OnOpenOrderEnd> OUT_OPEN_ORDER_END;

	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqAllOpenOrders();
		return null;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	private CallReqAllOpenOrders(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
		OUT_ORDER_STATUS = new OutEvents<>(this, OnOrderStatus.class);
		OUT_OPEN_ORDER = new OutEvents<>(this, OnOpenOrder.class);
		OUT_OPEN_ORDER_END = new OutTerminator<>(this, OnOpenOrderEnd.class);
	}

	public CallReqAllOpenOrders(ConnectionContext aContext) {
		this(aContext, new In());
	}

}
