package com.blogspot.mikelaud.nyse.task.call.connection_and_server;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.call.CallTaskEx;
import com.blogspot.mikelaud.nyse.task.call.CallType;
import com.blogspot.mikelaud.nyse.task.event.connection_and_server.OnServerVersion;

/**
 * Returns the version of the TWS instance
 * to which the API application is connected.
 */
public class CallServerVersion
	extends CallTaskEx<CallServerVersion.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		public Info() {
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

	private CallServerVersion(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.serverVersion);
	}

	public CallServerVersion(ConnectionContext aContext) {
		this(aContext, new Info());
	}

}
