package com.blogspot.mikelaud.ibl.task.event.connection_and_server;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;
import com.blogspot.mikelaud.ibl.task.event.EventType;

/**
 * Artificial event for sync call CallServerVersion.
 */
public class OnServerVersion
	extends EventTaskEx<OnServerVersion.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * Version of the TWS instance
		 * to which the API application is connected.
		 */
		public final int SERVER_VERSION;
		
		public Info(int aServerVersion) {
			SERVER_VERSION = aServerVersion;
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
		,	INFO.SERVER_VERSION
		);
	}

	public OnServerVersion(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, EventType.serverVersion);
	}

}
