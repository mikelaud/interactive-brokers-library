package com.blogspot.mikelaud.ibl.task.call.financial_advisors;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.out.OutTerminator;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.event.financial_advisors.OnReceiveFA;

/**
 * Call this call to request FA configuration information from TWS.
 * The data returns in an XML string via the OnReceiveFA event.
 */
public class CallRequestFA
	extends CallTaskEx<CallRequestFA.In>
{
	//------------------------------------------------------------------------
	public static class In {
	
		/**
		 * Specifies the type of Financial Advisor configuration data
		 * being requested. Valid values include:
		 *     1 = GROUPS
		 *     2 = PROFILE
		 *     3 = ACCOUNT ALIASES
		 */
		public final int FA_DATA_TYPE;	
				
		public In(int aFaDataType) {
			FA_DATA_TYPE = aFaDataType;
		}
		
	}
	//------------------------------------------------------------------------

	public final OutTerminator<OnReceiveFA> OUT_RECEIVE_FA;
	
	//------------------------------------------------------------------------
	
	@Override
	protected Task onCall() throws Exception {
		getClientSocket().requestFA(IN.FA_DATA_TYPE);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s { faDataType=\"%d\" }"
		,	super.toString()
		,	IN.FA_DATA_TYPE
		);
	}

	public CallRequestFA(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
		OUT_RECEIVE_FA = new OutTerminator<>(this, OnReceiveFA.class);
	}

	public CallRequestFA(ConnectionContext aContext, int aFaDataType) {
		this(aContext, new In(aFaDataType));
	}

}
