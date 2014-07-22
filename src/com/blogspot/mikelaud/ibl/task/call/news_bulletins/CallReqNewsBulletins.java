package com.blogspot.mikelaud.ibl.task.call.news_bulletins;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;

/**
 * Call this call to start receiving news bulletins.
 * Each bulletin will be returned by the OnUpdateNewsBulletin method.
 */
public class CallReqNewsBulletins
	extends CallTaskEx<CallReqNewsBulletins.In>
{
	@Override
	public boolean hasRequestId() {
		return false;
	}
	//------------------------------------------------------------------------
	public static class In {
	
		/**
		 * If set to TRUE, returns all the existing bulletins
		 * for the current day and any new ones.
		 * IF set to FALSE, will only return new bulletins.
		 */
		public final boolean ALL_MSGS;
		
		public In(boolean aAllMsgs) {
			ALL_MSGS = aAllMsgs;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqNewsBulletins(IN.ALL_MSGS);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s { allMsgs=\"%b\" }"
		,	super.toString()
		,	IN.ALL_MSGS
		);
	}

	public CallReqNewsBulletins(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallReqNewsBulletins(ConnectionContext aContext, boolean aAllMsgs) {
		this(aContext, new In(aAllMsgs));
	}

}
