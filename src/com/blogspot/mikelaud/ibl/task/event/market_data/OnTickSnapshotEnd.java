package com.blogspot.mikelaud.nyse.task.event.market_data;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.event.EventTaskEx;
import com.blogspot.mikelaud.nyse.task.event.EventType;

/**
 * This is called when a snapshot market data subscription
 * has been fully handled and there is nothing more to wait for.
 * This also covers the timeout case.
 */
public class OnTickSnapshotEnd
	extends EventTaskEx<OnTickSnapshotEnd.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * Id of the data request.
		 */
		public final int REQ_ID;
		
		public Info(int aReqId) {
			REQ_ID = aReqId;
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
		,	INFO.REQ_ID
		);
	}
	
	public OnTickSnapshotEnd(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, EventType.tickSnapshotEnd);
	}

}
