package com.blogspot.mikelaud.ibl.task.call.connection_and_server;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;
import com.blogspot.mikelaud.ibl.task.event.connection_and_server.OnTwsConnectionTime;

/**
 * Returns the time the API application made a connection to TWS.
 */
public class CallTwsConnectionTime
	extends CallTaskEx<CallTwsConnectionTime.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		public Info() {
			// void
		}
		
	}
	//------------------------------------------------------------------------

	/**
	 * The time the API application made a connection to TWS.
	 */
	private String mTwsConnectionTime = "";
	
	public String getTwsConnectionTime() { return mTwsConnectionTime; }
	
	@Override
	protected Task onCall() throws Exception {
		String result = getClientSocket().TwsConnectionTime();
		mTwsConnectionTime = (null == result ? "" : result);
		//
		OnTwsConnectionTime.Info timeInfo =
			new OnTwsConnectionTime.Info(mTwsConnectionTime);
		//
		new OnTwsConnectionTime(mContext, timeInfo).call();
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s"
		,	super.toString()
		);
	}

	private CallTwsConnectionTime(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.twsConnectionTime);
	}

	public CallTwsConnectionTime(ConnectionContext aContext) {
		this(aContext, new Info());
	}

}