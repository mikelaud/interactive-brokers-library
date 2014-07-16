package com.blogspot.mikelaud.nyse.task.call.financial_advisors;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.call.CallTaskEx;
import com.blogspot.mikelaud.nyse.task.call.CallType;

/**
 * Call this call to request FA configuration information from TWS.
 * The data returns in an XML string via the OnReceiveFA event.
 */
public class CallRequestFA
	extends CallTaskEx<CallRequestFA.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * Specifies the type of Financial Advisor configuration data
		 * being requested. Valid values include:
		 *     1 = GROUPS
		 *     2 = PROFILE
		 *     3 = ACCOUNT ALIASES
		 */
		public final int FA_DATA_TYPE;	
				
		public Info(int aFaDataType) {
			FA_DATA_TYPE = aFaDataType;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().requestFA(INFO.FA_DATA_TYPE);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s { faDataType=\"%d\" }"
		,	super.toString()
		,	INFO.FA_DATA_TYPE
		);
	}

	public CallRequestFA(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.requestFA);
	}

	public CallRequestFA(ConnectionContext aContext, int aFaDataType) {
		this(aContext, new Info(aFaDataType));
	}

}
