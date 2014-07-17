package com.blogspot.mikelaud.ibl.task.call.connection_and_server;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;

/**
 * The default level is ERROR.
 * Refer to the API logging page for more details:
 * https://www.interactivebrokers.com/en/software/api/apiguide/tables/api_logging.htm
 */
public class CallSetServerLogLevel
	extends CallTaskEx<CallSetServerLogLevel.In>
{
	//------------------------------------------------------------------------
	public static class In {
	
		/**
		 * Specifies the level of log entry detail used by the server (TWS)
		 * when processing API requests. Valid values include:
		 *     1 = SYSTEM
		 *     2 = ERROR
		 *     3 = WARNING
		 *     4 = INFORMATION
		 *     5 = DETAIL
		 */
		public final int LOG_LEVEL;
		
		public In(int aLogLevel) {
			LOG_LEVEL = aLogLevel;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().setServerLogLevel(IN.LOG_LEVEL);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s(%d)"
		,	super.toString()
		,	IN.LOG_LEVEL
		);
	}

	public CallSetServerLogLevel(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, CallType.setServerLogLevel);
	}

	public CallSetServerLogLevel
	(	ConnectionContext aContext
	,	int aLogLevel
	) {
		this(aContext, new In(aLogLevel));
	}

}
