package com.blogspot.mikelaud.ibl.task.call.connection_and_server;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;

/**
 * Returns the current system time on the server side
 * via the OnCurrentTime EWrapper event.
 */
public class CallReqCurrentTime
	extends CallTaskEx<CallReqCurrentTime.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		public Info() {
			// void
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqCurrentTime();
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s"
		,	super.toString()
		);
	}

	private CallReqCurrentTime(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.reqCurrentTime);
	}

	public CallReqCurrentTime(ConnectionContext aContext) {
		this(aContext, new Info());
	}

}
