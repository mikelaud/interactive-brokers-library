package com.blogspot.mikelaud.ibl.task.call.financial_advisors;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;

/**
 * Call this call to request new FA configuration information from TWS.
 * The data returns in an XML string via a OnReceiveFA event.
 */
public class CallReplaceFA
	extends CallTaskEx<CallReplaceFA.Info>
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
		/**
		 * The XML string containing the new FA configuration information.
		 */
		public final String XML;
		
		public Info(int aFaDataType, String aXml) {
			FA_DATA_TYPE = aFaDataType;
			XML = aXml;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().replaceFA
		(	INFO.FA_DATA_TYPE
		,	INFO.XML
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s { faDataType=\"%d\" xml=\"%s\" }"
		,	super.toString()
		,	INFO.FA_DATA_TYPE
		,	INFO.XML
		);
	}

	public CallReplaceFA(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.replaceFA);
	}

	public CallReplaceFA
	(	ConnectionContext aContext
	,	int aFaDataType
	,	String aXml
	) {
		this(aContext, new Info
		(	aFaDataType
		,	aXml
		));
	}

}
