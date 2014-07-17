package com.blogspot.mikelaud.ibl.task.call.orders;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;

/**
 * Call this call to cancel an order.
 */
public class CallCancelOrder
	extends CallTaskEx<CallCancelOrder.In>
{
	//------------------------------------------------------------------------
	public static class In {
	
		/**
		 * The order Id that was specified previously
		 * in the call to CallPlaceOrder.
		 */
		public final int ID;
		
		public In(int aId) {
			ID = aId;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().cancelOrder(IN.ID);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s[%d]"
		,	super.toString()
		,	IN.ID
		);
	}

	public CallCancelOrder(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, CallType.cancelOrder);
	}

	public CallCancelOrder(ConnectionContext aContext, int aId) {
		this(aContext, new In(aId));
	}

}
