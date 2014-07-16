package com.blogspot.mikelaud.nyse.task.event.account_and_portfolio;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.event.EventTaskEx;
import com.blogspot.mikelaud.nyse.task.event.EventType;

/**
 * This event is called only when CallReqAccountUpdates call
 * on the EClientSocket object has been called.
 */
public class OnUpdateAccountTime
	extends EventTaskEx<OnUpdateAccountTime.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * This indicates the last update time of the account information.
		 */
		public final String TIME_STAMP;
		
		public Info(String aTimeStamp) {
			TIME_STAMP = aTimeStamp;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onEvent() throws Exception {
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s(%s)"
		,	super.toString()
		,	INFO.TIME_STAMP
		);
	}

	public OnUpdateAccountTime(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, EventType.updateAccountTime);
	}

}
