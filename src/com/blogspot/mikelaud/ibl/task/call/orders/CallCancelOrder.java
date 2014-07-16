package com.blogspot.mikelaud.ibl.task.call.orders;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;

/**
 * Call this call to cancel an order.
 */
public class CallCancelOrder
	extends CallTaskEx<CallCancelOrder.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The order Id that was specified previously
		 * in the call to CallPlaceOrder.
		 */
		public final int ID;
		
		public Info(int aId) {
			ID = aId;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().cancelOrder(INFO.ID);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s[%d]"
		,	super.toString()
		,	INFO.ID
		);
	}

	public CallCancelOrder(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.cancelOrder);
	}

	public CallCancelOrder(ConnectionContext aContext, int aId) {
		this(aContext, new Info(aId));
	}

}
