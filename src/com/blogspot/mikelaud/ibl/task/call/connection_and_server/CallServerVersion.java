package com.blogspot.mikelaud.ibl.task.call.connection_and_server;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.event.connection_and_server.OnServerVersion;

/**
 * Returns the version of the TWS instance
 * to which the API application is connected.
 */
public class CallServerVersion
	extends CallTaskEx<CallServerVersion.In>
{
	//------------------------------------------------------------------------
	public static class In {
	
		public In() {
			// void
		}
		
	}
	//------------------------------------------------------------------------

	/**
	 * Version of the TWS instance
	 * to which the API application is connected.
	 */
	private int mServerVersion = 0;
	
	public int getServerVersion() { return mServerVersion; }
	
	@Override
	protected Task onCall() throws Exception {
		mServerVersion = getClientSocket().serverVersion();
		//
		OnServerVersion.Info versionInfo =
			new OnServerVersion.Info(mServerVersion);
		//
		new OnServerVersion(mContext, versionInfo).call();
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s"
		,	super.toString()
		);
	}

	private CallServerVersion(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallServerVersion(ConnectionContext aContext) {
		this(aContext, new In());
	}

}
