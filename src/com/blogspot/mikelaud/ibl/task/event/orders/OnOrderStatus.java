package com.blogspot.mikelaud.ibl.task.event.orders;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;

/**
 * This event is called whenever the status of an order changes.
 * It is also fired after reconnecting to TWS if the client has any open orders.
 * 
 * Note: It is possible that OnOrderStatus may return duplicate messages.
 *       It is essential that you filter the message accordingly.
 */
public class OnOrderStatus
	extends EventTaskEx<OnOrderStatus.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The order Id that was specified previously
		 * in the call to CallPlaceOrder.
		 */
		public final int ORDER_ID;
		/**
		 * The order status. Possible values include:
		 *     PendingSubmit - indicates that you have transmitted the order,
		 *                     but have not yet received confirmation
		 *                     that it has been accepted by the order destination.
		 *                     NOTE: This order status is not sent by TWS
		 *                           and should be explicitly set by the API developer
		 *                           when an order is submitted.
		 *     PendingCancel - indicates that you have sent a request to cancel
		 *                     the order but have not yet received cancel confirmation
		 *                     from the order destination. At this point, your order
		 *                     is not confirmed canceled. You may still receive
		 *                     an execution while your cancellation request is pending.
		 *                     NOTE: This order status is not sent by TWS
		 *                           and should be explicitly set by the API developer
		 *                           when an order is canceled.
		 *     PreSubmitted - indicates that a simulated order type has been accepted
		 *                    by the IB system and that this order has yet to be elected.
		 *                    The order is held in the IB system until the election
		 *                    criteria are met. At that time the order is transmitted
		 *                    to the order destination as specified.
		 *     Submitted - indicates that your order has been accepted
		 *                 at the order destination and is working.
		 *     Cancelled - indicates that the balance of your order has been confirmed
		 *                 canceled by the IB system. This could occur unexpectedly
		 *                 when IB or the destination has rejected your order.
		 *     Filled - indicates that the order has been completely filled.
		 *     Inactive - indicates that the order has been accepted by the system
		 *                (simulated orders) or an exchange (native orders)
		 *                but that currently the order is inactive due to system,
		 *                exchange or other issues.
		 */
		public final String STATUS;
		/**
		 * Specifies the number of shares that have been executed.
		 * For more information about partial fills,
		 * see Order Status for Partial Fills:
		 * https://www.interactivebrokers.com/en/software/api/apiguide/tables/order_status_for_partial_fills.htm
		 */
		public final int FILLED;
		/**
		 * Specifies the number of shares still outstanding.
		 */
		public final int REMAINING;
		/**
		 * The average price of the shares that have been executed.
		 * This parameter is valid only if the filled parameter value
		 * is greater than zero. Otherwise, the price parameter will be zero.
		 */
		public final double AVG_FILL_PRICE;
		/**
		 * The TWS id used to identify orders.
		 * Remains the same over TWS sessions.
		 */
		public final int PERM_ID;
		/**
		 * The order ID of the parent order, used for bracket
		 * and auto trailing stop orders.
		 */
		public final int PARENT_ID;
		/**
		 * The last price of the shares that have been executed.
		 * This parameter is valid only if the filled parameter value
		 * is greater than zero. Otherwise, the price parameter will be zero.
		 */
		public final double LAST_FILL_PRICE;
		/**
		 * The ID of the client (or TWS) that placed the order.
		 * Note that TWS orders have a fixed clientId
		 * and orderId of 0 that distinguishes them from API orders.
		 */
		public final int CLIENT_ID;
		/**
		 * This field is used to identify an order held
		 * when TWS is trying to locate shares for a short sell.
		 * The value used to indicate this is 'locate'.
		 */
		public final String WHY_HELD;
		
		public Info
		(	int aOrderId
		,	String aStatus
		,	int aFilled
		,	int aRemaining
		,	double aAvgFillPrice
		,	int aPermId
		,	int aParentId
		,	double aLastFillPrice
		,	int aClientId
		,	String aWhyHeld		
		) {
			ORDER_ID = aOrderId;
			STATUS = aStatus;
			FILLED = aFilled;
			REMAINING = aRemaining;
			AVG_FILL_PRICE = aAvgFillPrice;
			PERM_ID = aPermId;
			PARENT_ID = aParentId;
			LAST_FILL_PRICE = aLastFillPrice;
			CLIENT_ID = aClientId;
			WHY_HELD = aWhyHeld;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	public int getRequestId() {
		return getNoRequestId();
	}

	@Override
	protected Task onEvent() throws Exception {
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s(%s)[%d] { filled=\"%d\" remaining=\"%d\" avgFillPrice=\"%f\" permId=\"%d\" parentId=\"%d\" lastFillPrice=\"%f\" clientId=\"%d\" whyHeld=\"%s\" }"
		,	super.toString()
		,	INFO.STATUS
		,	INFO.ORDER_ID
		,	INFO.FILLED
		,	INFO.REMAINING
		,	INFO.AVG_FILL_PRICE
		,	INFO.PERM_ID
		,	INFO.PARENT_ID
		,	INFO.LAST_FILL_PRICE
		,	INFO.CLIENT_ID
		,	INFO.WHY_HELD
		);
	}
	
	public OnOrderStatus(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, new TaskInnerObject(){});
	}

}
