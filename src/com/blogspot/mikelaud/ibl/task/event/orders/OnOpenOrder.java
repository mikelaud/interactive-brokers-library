package com.blogspot.mikelaud.ibl.task.event.orders;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;
import com.ib.client.Contract;
import com.ib.client.Order;
import com.ib.client.OrderState;

/**
 * This event is called to feed in open orders.
 */
public class OnOpenOrder
	extends EventTaskEx<OnOpenOrder.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The order Id assigned by TWS. Used to cancel or update the order.
		 */
		public final int ORDER_ID;
		/**
		 * The Contract class attributes describe the contract.
		 */
		public final Contract CONTRACT;
		/**
		 * The Order class attributes define the details of the order.
		 */
		public final Order ORDER;
		/**
		 * The orderState attributes include margin and commissions fields
		 * for both pre and post trade data.
		 */
		public final OrderState ORDER_STATE;
		
		public Info
		(	int aOrderId
		,	Contract aContract
		,	Order aOrder
		,	OrderState aOrderState
		) {
			ORDER_ID = aOrderId;
			CONTRACT = aContract;
			ORDER = aOrder;
			ORDER_STATE = aOrderState;
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
		,	INFO.ORDER_ID
		);
	}
	
	public OnOpenOrder(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, new TaskInnerObject(){});
	}

}
