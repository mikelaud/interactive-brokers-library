package com.blogspot.mikelaud.nyse.task.call.orders;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.call.CallTaskEx;
import com.blogspot.mikelaud.nyse.task.call.CallType;
import com.ib.client.Contract;
import com.ib.client.Order;

/**
 * Call this call to place an order.
 */
public class CallPlaceOrder
	extends CallTaskEx<CallPlaceOrder.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The order Id. You must specify a unique value.
		 * When the order status returns, it will be identified by this tag.
		 * This tag is also used when canceling the order.
		 */
		public final int ID;
		/**
		 * This class contains attributes used to describe the contract.
		 */
		public final Contract CONTRACT;
		/**
		 * This structure contains the details of the order.
		 * Note: Each client MUST connect with a unique clientId.
		 */
		public final Order ORDER;
		
		public Info(int aId, Contract aContract, Order aOrder) {
			ID = aId;
			CONTRACT = aContract;
			ORDER = aOrder;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().placeOrder
		(	INFO.ID
		,	INFO.CONTRACT
		,	INFO.ORDER
		);
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

	public CallPlaceOrder(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.placeOrder);
	}

	public CallPlaceOrder
	(	ConnectionContext aContext
	,	int aId
	,	Contract aContract
	,	Order aOrder
	) {
		this(aContext, new Info
		(	aId
		,	aContract
		,	aOrder
		));
	}

}
