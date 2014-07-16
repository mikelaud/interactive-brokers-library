package com.blogspot.mikelaud.nyse.task.call.news_bulletins;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.call.CallTaskEx;
import com.blogspot.mikelaud.nyse.task.call.CallType;

/**
 * Call this call to start receiving news bulletins.
 * Each bulletin will be returned by the OnUpdateNewsBulletin method.
 */
public class CallReqNewsBulletins
	extends CallTaskEx<CallReqNewsBulletins.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * If set to TRUE, returns all the existing bulletins
		 * for the current day and any new ones.
		 * IF set to FALSE, will only return new bulletins.
		 */
		public final boolean ALL_MSGS;
		
		public Info(boolean aAllMsgs) {
			ALL_MSGS = aAllMsgs;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqNewsBulletins(INFO.ALL_MSGS);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s { allMsgs=\"%b\" }"
		,	super.toString()
		,	INFO.ALL_MSGS
		);
	}

	public CallReqNewsBulletins(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.reqNewsBulletins);
	}

	public CallReqNewsBulletins(ConnectionContext aContext, boolean aAllMsgs) {
		this(aContext, new Info(aAllMsgs));
	}

}
