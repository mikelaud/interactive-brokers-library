package com.blogspot.mikelaud.ibl.task.call.market_scanners;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;
import com.ib.client.ScannerSubscription;

/**
 * Call the CallReqScannerSubscription call to start receiving
 * market scanner results through the OnScannerData EWrapper event.
 */
public class CallReqScannerSubscription
	extends CallTaskEx<CallReqScannerSubscription.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The Id for the subscription. Must be a unique value. When the
		 * subscription data is received, it will be identified by this Id.
		 * This is also used when canceling the scanner.
		 */
		public final int TICKER_ID;
		/**
		 * Summary of the scanner subscription parameters including filters.
		 */
		public final ScannerSubscription SUBSCRIPTION;
		
		public Info(int aTickerId, ScannerSubscription aSubscription) {
			TICKER_ID = aTickerId;
			SUBSCRIPTION = aSubscription;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqScannerSubscription
		(	INFO.TICKER_ID
		,	INFO.SUBSCRIPTION
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s[%d]"
		,	super.toString()
		,	INFO.TICKER_ID
		);
	}

	public CallReqScannerSubscription(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.reqScannerSubscription);
	}

	public CallReqScannerSubscription
	(	ConnectionContext aContext
	,	int aTickerId
	,	ScannerSubscription aSubscription
	) {
		this(aContext, new Info
		(	aTickerId
		,	aSubscription
		));
	}

}
