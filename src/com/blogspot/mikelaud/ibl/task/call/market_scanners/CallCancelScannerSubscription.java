package com.blogspot.mikelaud.ibl.task.call.market_scanners;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;

/**
 * Call the CallCancelScannerSubscription call to stop
 * receiving market scanner results.
 */
public class CallCancelScannerSubscription
	extends CallTaskEx<CallCancelScannerSubscription.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The Id that was specified
		 * in the call to CallReqScannerSubscription.
		 */
		public final int TICKER_ID;
		
		public Info(int aTickerId) {
			TICKER_ID = aTickerId;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().cancelScannerSubscription(INFO.TICKER_ID);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s[%d]"
		,	super.toString()
		);
	}

	public CallCancelScannerSubscription(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.cancelScannerSubscription);
	}

	public CallCancelScannerSubscription(ConnectionContext aContext, int aTickerId) {
		this(aContext, new Info(aTickerId));
	}

}