package com.blogspot.mikelaud.nyse.task.call.news_bulletins;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.call.CallTaskEx;
import com.blogspot.mikelaud.nyse.task.call.CallType;

/**
 * Call this call to stop receiving news bulletins.
 */
public class CallCancelNewsBulletins
	extends CallTaskEx<CallCancelNewsBulletins.Info>
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

	private CallCancelNewsBulletins(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.cancelNewsBulletins);
	}

	public CallCancelNewsBulletins(ConnectionContext aContext) {
		this(aContext, new Info());
	}

}
