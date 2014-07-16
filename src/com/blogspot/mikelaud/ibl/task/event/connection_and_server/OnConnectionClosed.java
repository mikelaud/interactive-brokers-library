package com.blogspot.mikelaud.nyse.task.event.connection_and_server;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.event.EventTaskEx;
import com.blogspot.mikelaud.nyse.task.event.EventType;

/**
 * This event is called when TWS closes the sockets connection,
 * or when TWS is shut down.
 */
public class OnConnectionClosed
	extends EventTaskEx<OnConnectionClosed.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		public Info() {
			// void
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
		(	"%s"
		,	super.toString()
		);
	}

	public OnConnectionClosed(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, EventType.connectionClosed);
	}
	
}
