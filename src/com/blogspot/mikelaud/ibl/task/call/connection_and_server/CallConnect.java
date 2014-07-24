package com.blogspot.mikelaud.ibl.task.call.connection_and_server;

import com.blogspot.mikelaud.ibl.Config;
import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.out.OutTerminator;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.event.financial_advisors.OnManagedAccounts;
import com.blogspot.mikelaud.ibl.task.event.orders.OnNextValidId;
import com.blogspot.mikelaud.ibl.util.IblString;

/**
 * This call must be called before any other.
 * There is no feedback for a successful connection,
 * but a subsequent attempt to connect will return
 * the message "Already connected."
 */
public class CallConnect
	extends CallTaskEx<CallConnect.In>
{
	@Override
	public boolean hasRequestId() {
		return false;
	}
	//------------------------------------------------------------------------
	public static class In {
	
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
		
		public In
		(	String aHost
		,	int aPort
		,	int aClientId
		) {
			HOST = IblString.nvl(aHost);
			PORT = aPort;
			CLIENT_ID = aClientId;
		}

	}	
	//------------------------------------------------------------------------

	public final OutTerminator<OnManagedAccounts> OUT_MANAGED_ACCOUNTS;
	public final OutTerminator<OnNextValidId> OUT_NEXT_VALID_ID;
	
	//------------------------------------------------------------------------
	
	@Override
	protected Task onCall() throws Exception {
		getClientSocket().eConnect
		(	IN.HOST
		,	IN.PORT
		,	IN.CLIENT_ID
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s { host=\"%s\" port=%d clientId=%d }"
		,	super.toString()
		,	IN.HOST
		,	IN.PORT
		,	IN.CLIENT_ID
		);
	}
	
	public CallConnect(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
		OUT_MANAGED_ACCOUNTS = new OutTerminator<>(this, OnManagedAccounts.class);
		OUT_NEXT_VALID_ID = new OutTerminator<>(this, OnNextValidId.class);
	}

	public CallConnect(ConnectionContext aContext) {
		this(aContext, new In
		(	Config.getHost()
		,	Config.getPort()
		,	Config.getClientId()
		));
	}

	public CallConnect
	(	ConnectionContext aContext
	,	String aHost
	,	int aPort
	,	int aClientId
	) {
		this(aContext, new In
		(	aHost
		,	aPort
		,	aClientId
		));
	}
	
}
