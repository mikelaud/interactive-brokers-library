package com.blogspot.mikelaud.nyse.task.event.market_scanners;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.event.EventTaskEx;
import com.blogspot.mikelaud.nyse.task.event.EventType;

/**
 * This event receives an XML document that describes the valid parameters
 * that a scanner subscription can have.
 */
public class OnScannerParameters
	extends EventTaskEx<OnScannerParameters.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * A document describing available scanner subscription parameters.
		 */
		public final String XML;
		
		public Info(String aXml) {
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
		(	"%s { xml=\"%s\" }"
		,	super.toString()
		,	INFO.XML
		);
	}
	
	public OnScannerParameters(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, EventType.scannerParameters);
	}

}
