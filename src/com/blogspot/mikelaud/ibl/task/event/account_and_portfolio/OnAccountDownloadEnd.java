package com.blogspot.mikelaud.ibl.task.event.account_and_portfolio;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;
import com.blogspot.mikelaud.ibl.task.event.EventType;

/**
 * This event is called after a batch OnUpdateAccountValue
 * and OnUpdatePortfolio is sent.
 */
public class OnAccountDownloadEnd
	extends EventTaskEx<OnAccountDownloadEnd.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The name of the account.
		 */
		private final String ACCOUNT_NAME;
		
		public Info(String aAccountName) {
			ACCOUNT_NAME = aAccountName;
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
		,	INFO.ACCOUNT_NAME
		);
	}

	public OnAccountDownloadEnd(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, EventType.accountDownloadEnd);
	}

}
