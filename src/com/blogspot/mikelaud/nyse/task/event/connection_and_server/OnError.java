package com.blogspot.mikelaud.nyse.task.event.connection_and_server;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.event.EventTaskEx;
import com.blogspot.mikelaud.nyse.task.event.EventType;

/**
 * This event is called when there is an error with the communication or
 * when TWS wants to send a message to the client.
 */
public class OnError
	extends EventTaskEx<OnError.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * This is the orderId or tickerId of the request
		 * that generated the error.
		 */
		public final int ID;
		/**
		 * For information on error codes, see Error Codes.
		 */
		public final int ERROR_CODE;
		/**
		 * The textual description of the error.
		 */
		public final String ERROR_STRING;

		public Info(int aId, int aErrorCode, String aErrorString) {
			ID = aId;
			ERROR_CODE = aErrorCode;
			ERROR_STRING = aErrorString;
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
		(	"%s(%d)[%d] { \"%s\" }"
		,	super.toString()
		,	INFO.ERROR_CODE
		,	INFO.ID
		,	INFO.ERROR_STRING
		);
	}
	
	public OnError(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, EventType.error);
	}

}
