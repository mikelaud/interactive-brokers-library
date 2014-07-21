package com.blogspot.mikelaud.ibl.task.event.connection_and_server;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;

/**
 * This event is called when TWS wants to send an error message
 * to the client. (V1).
 */
public class OnErrorString
	extends EventTaskEx<OnErrorString.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * This is the textual description of the error.
		 */
		public final String STRING;
		
		public Info(String aString) {
			STRING = aString;
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
		,	INFO.STRING
		);
	}
	
	public OnErrorString(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, new TaskInnerObject(){});
	}

}
