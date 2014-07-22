package com.blogspot.mikelaud.ibl.task.event.connection_and_server;

import com.blogspot.mikelaud.ibl.Config;
import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;

/**
 * This event is called when an exception occurs
 * while handling a request.
 */
public class OnErrorException
	extends EventTaskEx<OnErrorException.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The exception that occurred.
		 */
		public final Exception EXCEPTION;
		
		public Info(Exception aException) {
			EXCEPTION = aException;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	public int getRequestId() {
		return Config.getNoRequestId();
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
		,	INFO.EXCEPTION.toString()
		);
	}

	public OnErrorException(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, new TaskInnerObject(){});
	}

}
