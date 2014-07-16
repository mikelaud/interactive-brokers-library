package com.blogspot.mikelaud.ibl.task.event.financial_advisors;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;
import com.blogspot.mikelaud.ibl.task.event.EventType;

/**
 * This event receives previously requested FA configuration information
 * from TWS.
 */
public class OnReceiveFA
	extends EventTaskEx<OnReceiveFA.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * Specifies the type of Financial Advisor configuration data
		 * being received from TWS. Valid values include:
		 *     1 = GROUPS
		 *     2 = PROFILE
		 *     3 =ACCOUNT ALIASES
		 */
		public final int FA_DATA_TYPE;
		/**
		 * The XML string containing the previously requested
		 * FA configuration information.
		 */
		public final String XML;
		
		public Info(int aFaDataType, String aXml) {
			FA_DATA_TYPE = aFaDataType;
			XML = aXml;
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
		(	"%s { faDataType=\"%d\" xml=\"%s\" }"
		,	super.toString()
		,	INFO.FA_DATA_TYPE
		,	INFO.XML
		);
	}
	
	public OnReceiveFA(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, EventType.receiveFA);
	}

}
