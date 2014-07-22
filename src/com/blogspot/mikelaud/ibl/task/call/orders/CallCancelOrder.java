package com.blogspot.mikelaud.ibl.task.call.orders;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;

/**
 * Call this call to cancel an order.
 */
public class CallCancelOrder
	extends CallTaskEx<CallCancelOrder.In>
{
	@Override
	public boolean hasRequestId() {
		return false;
	}
	//------------------------------------------------------------------------
	public static class In {
	
		/**
		 * The order Id that was specified previously
		 * in the call to CallPlaceOrder.
		 */
		public final int ORDER_ID;
		
		public In(int aId) {
			ORDER_ID = aId;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().cancelOrder(IN.ORDER_ID);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s(%d)"
		,	super.toString()
		,	IN.ORDER_ID
		);
	}

	public CallCancelOrder(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallCancelOrder(ConnectionContext aContext, int aOrderId) {
		this(aContext, new In(aOrderId));
	}

}
