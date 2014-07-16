package com.blogspot.mikelaud.ibl.task.call.connection_and_server;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;

/**
 * Call this call to check if there is a connection with TWS.
 */
public class CallIsConnected
	extends CallTaskEx<CallIsConnected.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		public Info() {
			// void
		}
		
	}
	//------------------------------------------------------------------------

	/**
	 * Connection state.
	 */
	private boolean mConnected = false;
	
	public boolean isConnected() { return mConnected; }
	
	@Override
	protected Task onCall() throws Exception {
		mConnected = getClientSocket().isConnected();
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s"
		,	super.toString()
		);
	}

	private CallIsConnected(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.isConnected);
	}

	public CallIsConnected(ConnectionContext aContext) {
		this(aContext, new Info());
	}

}
