package com.blogspot.mikelaud.ibl.task.call.news_bulletins;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;

/**
 * Call this call to stop receiving news bulletins.
 */
public class CallCancelNewsBulletins
	extends CallTaskEx<CallCancelNewsBulletins.In>
{
	//------------------------------------------------------------------------
	public static class In {
	
		public In() {
			// void
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().cancelNewsBulletins();
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s"
		,	super.toString()
		);
	}

	private CallCancelNewsBulletins(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, CallType.cancelNewsBulletins);
	}

	public CallCancelNewsBulletins(ConnectionContext aContext) {
		this(aContext, new In());
	}

}
