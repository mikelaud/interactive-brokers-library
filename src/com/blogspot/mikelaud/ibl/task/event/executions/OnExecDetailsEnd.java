package com.blogspot.mikelaud.ibl.task.event.executions;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;
import com.blogspot.mikelaud.ibl.task.event.EventType;

/**
 * This event is called once all executions have been sent to a client
 * in response to CallReqExecutions.
 */
public class OnExecDetailsEnd
	extends EventTaskEx<OnExecDetailsEnd.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The Id of the data request.
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
	
	public OnExecDetailsEnd(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, EventType.execDetailsEnd);
	}

}
