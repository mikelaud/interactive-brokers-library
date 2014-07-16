package com.blogspot.mikelaud.nyse.task.event.orders;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.event.EventTaskEx;
import com.blogspot.mikelaud.nyse.task.event.EventType;

/**
 * This event is called after a successful connection to TWS.
 */
public class OnNextValidId
	extends EventTaskEx<OnNextValidId.Info>
{
	//------------------------------------------------------------------------
	public static class Info {

		/**
		 * The next available order Id received from TWS upon connection.
		 * Increment all successive orders by one based on this Id.
		 */
		public final int ORDER_ID;

		public Info(int aOrderId) {
			ORDER_ID = aOrderId;
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
		(	"%s(%d)"
		,	super.toString()
		,	INFO.ORDER_ID
		);
	}
	
	public OnNextValidId(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, EventType.nextValidId);
	}

}
