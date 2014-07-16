package com.blogspot.mikelaud.nyse.task.call.market_scanners;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.call.CallTaskEx;
import com.blogspot.mikelaud.nyse.task.call.CallType;

/**
 * Call the CallReqScannerParameters call to receive an XML document
 * that describes the valid parameters that a scanner subscription can have.
 */
public class CallReqScannerParameters
	extends CallTaskEx<CallReqScannerParameters.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		public Info() {
			// void
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqScannerParameters();
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s"
		,	super.toString()
		);
	}

	private CallReqScannerParameters(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.reqScannerParameters);
	}

	public CallReqScannerParameters(ConnectionContext aContext) {
		this(aContext, new Info());
	}

}
