package com.blogspot.mikelaud.ibl.task.event.orders;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;

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
		(	"%s(%d)"
		,	super.toString()
		,	INFO.ORDER_ID
		);
	}
	
	public OnNextValidId(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, new TaskInnerObject(){});
	}

}
