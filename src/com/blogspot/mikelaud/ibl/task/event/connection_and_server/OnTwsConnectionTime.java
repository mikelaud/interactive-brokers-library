package com.blogspot.mikelaud.ibl.task.event.connection_and_server;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;

/**
 * Artificial event for sync call CallTwsConnectionTime.
 */
public class OnTwsConnectionTime
	extends EventTaskEx<OnTwsConnectionTime.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The time the API application made a connection to TWS.
		 */
		public final String TWS_TIME;
		
		public Info(String aTwsTime) {
			TWS_TIME = aTwsTime;
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
		(	"%s { \"%s\" }"
		,	super.toString()
		,	INFO.TWS_TIME
		);
	}

	public OnTwsConnectionTime(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, new TaskInnerObject(){});
	}

}
