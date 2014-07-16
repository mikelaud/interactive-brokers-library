package com.blogspot.mikelaud.ibl.task.event.connection_and_server;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;
import com.blogspot.mikelaud.ibl.task.event.EventType;

/**
 * Artificial event for sync call CallIsConnected.
 */
public class OnIsConnected
	extends EventTaskEx<OnIsConnected.Info>
{

	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * Connection state.
		 */
		public final int IS_CONNECTED;
		
		public Info(int aIsConnected) {
			IS_CONNECTED = aIsConnected;
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
		(	"%s(%b)"
		,	super.toString()
		,	INFO.IS_CONNECTED
		);
	}

	public OnIsConnected(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, EventType.isConnected);
	}
	
}