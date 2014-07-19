package com.blogspot.mikelaud.ibl.task.call.connection_and_server;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.out.OutTerminator;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.event.connection_and_server.OnCurrentTime;

/**
 * Returns the current system time on the server side
 * via the OnCurrentTime EWrapper event.
 */
public class CallReqCurrentTime
	extends CallTaskEx<CallReqCurrentTime.In>
{
	//------------------------------------------------------------------------
	public static class In {
	
		public In() {
			// void
		}
		
	}
	//------------------------------------------------------------------------
	
	public final OutTerminator<OnCurrentTime> OUT_CURRENT_TIME;
	
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

	private CallReqCurrentTime(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
		OUT_CURRENT_TIME = new OutTerminator<OnCurrentTime>(getRouter()); 
	}

	public CallReqCurrentTime(ConnectionContext aContext) {
		this(aContext, new In());
	}

}
