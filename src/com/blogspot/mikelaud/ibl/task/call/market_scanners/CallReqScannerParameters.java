package com.blogspot.mikelaud.ibl.task.call.market_scanners;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.out.OutEnd;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.event.market_scanners.OnScannerParameters;

/**
 * Call the CallReqScannerParameters call to receive an XML document
 * that describes the valid parameters that a scanner subscription can have.
 */
public class CallReqScannerParameters
	extends CallTaskEx<CallReqScannerParameters.In>
{
	@Override
	public boolean hasRequestId() {
		return false;
	}
	//------------------------------------------------------------------------
	public static class In {
	
		public In() {
			// void
		}
		
	}
	//------------------------------------------------------------------------

	public final OutEnd<OnScannerParameters> OUT_SCANNER_PARAMETERS;
	
	//------------------------------------------------------------------------
	
	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqScannerParameters();
		return null;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	private CallReqScannerParameters(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
		OUT_SCANNER_PARAMETERS = new OutEnd<>(this, OnScannerParameters.class);
	}

	public CallReqScannerParameters(ConnectionContext aContext) {
		this(aContext, new In());
	}

}
