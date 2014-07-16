package com.blogspot.mikelaud.ibl.task.call.connection_and_server;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;

/**
 * This call must be called before any other.
 * There is no feedback for a successful connection,
 * but a subsequent attempt to connect will return
 * the message "Already connected."
 */
public class CallConnect
	extends CallTaskEx<CallConnect.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The host name or IP address of the machine where TWS is running.
		 * Leave blank to connect to the local host.
		 */
		public final String HOST;
		/**
		 * Must match the port specified in TWS
		 * on the Configure->API->Socket Port field.
		 */
		public final int PORT;
		/**
		 * A number used to identify this client connection.
		 * All orders placed/modified from this client will be
		 * associated with this client identifier.
		 * Note: Each client MUST connect with a unique clientId.
		 */
		public final int CLIENT_ID;
		
		public Info
		(	String aHost
		,	int aPort
		,	int aClientId
		) {
			HOST = aHost;
			PORT = aPort;
			CLIENT_ID = aClientId;
		}

	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().eConnect
		(	INFO.HOST
		,	INFO.PORT
		,	INFO.CLIENT_ID
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s(%s:%d) { clientId=\"%d\" }"
		,	super.toString()
		,	INFO.HOST
		,	INFO.PORT
		,	INFO.CLIENT_ID
		);
	}
	
	public CallConnect(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.connect);
	}
	
	public CallConnect
	(	ConnectionContext aContext
	,	String aHost
	,	int aPort
	,	int aClientId
	) {
		this(aContext, new Info
		(	aHost
		,	aPort
		,	aClientId
		));
	}
	
}
