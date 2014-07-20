package com.blogspot.mikelaud.ibl.task.call.financial_advisors;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.out.OutTerminator;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.event.financial_advisors.OnReceiveFA;

/**
 * Call this call to request new FA configuration information from TWS.
 * The data returns in an XML string via a OnReceiveFA event.
 */
public class CallReplaceFA
	extends CallTaskEx<CallReplaceFA.In>
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
		/**
		 * The XML string containing the new FA configuration information.
		 */
		public final String XML;
		
		public In(int aFaDataType, String aXml) {
			FA_DATA_TYPE = aFaDataType;
			XML = aXml;
		}
		
	}
	//------------------------------------------------------------------------

	public final OutTerminator<OnReceiveFA> OUT_RECEIVE_FA;
	
	//------------------------------------------------------------------------
	
	@Override
	protected Task onCall() throws Exception {
		getClientSocket().replaceFA
		(	IN.FA_DATA_TYPE
		,	IN.XML
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s { faDataType=\"%d\" xml=\"%s\" }"
		,	super.toString()
		,	IN.FA_DATA_TYPE
		,	IN.XML
		);
	}

	public CallReplaceFA(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
		OUT_RECEIVE_FA = new OutTerminator<>(getRouter());
	}

	public CallReplaceFA
	(	ConnectionContext aContext
	,	int aFaDataType
	,	String aXml
	) {
		this(aContext, new In
		(	aFaDataType
		,	aXml
		));
	}

}
