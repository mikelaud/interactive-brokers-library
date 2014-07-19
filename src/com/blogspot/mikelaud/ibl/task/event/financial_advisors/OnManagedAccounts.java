package com.blogspot.mikelaud.ibl.task.event.financial_advisors;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;

/**
 * This event is called when a successful connection is made to an account.
 * It is also called when the CallReqManagedAccts call is invoked.
 */
public class OnManagedAccounts
	extends EventTaskEx<OnManagedAccounts.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The comma delimited list of FA managed accounts.
		 */
		public final String ACCOUNTS_LIST;

		public Info(String aAccountsList) {
			ACCOUNTS_LIST = aAccountsList;
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
		,	INFO.ACCOUNTS_LIST
		);
	}

	public OnManagedAccounts(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, new TaskInnerObject(){});
	}

}
