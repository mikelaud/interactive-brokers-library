package com.blogspot.mikelaud.ibl.task.call.market_scanners;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.out.OutEvents;
import com.blogspot.mikelaud.ibl.out.OutTerminator;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;
import com.blogspot.mikelaud.ibl.task.event.market_scanners.OnScannerData;
import com.blogspot.mikelaud.ibl.task.event.market_scanners.OnScannerDataEnd;
import com.ib.client.ScannerSubscription;

/**
 * Call the CallReqScannerSubscription call to start receiving
 * market scanner results through the OnScannerData EWrapper event.
 */
public class CallReqScannerSubscription
	extends CallTaskEx<CallReqScannerSubscription.In>
{
	//------------------------------------------------------------------------
	public static class In {
	
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
		
		public In(int aTickerId, ScannerSubscription aSubscription) {
			TICKER_ID = aTickerId;
			SUBSCRIPTION = aSubscription;
		}
		
	}
	//------------------------------------------------------------------------

	public final OutEvents<OnScannerData> OUT_SCANNER_DATA;
	public final OutTerminator<OnScannerDataEnd> OUT_SCANNER_DATA_END;
	
	//------------------------------------------------------------------------
	
	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqScannerSubscription
		(	IN.TICKER_ID
		,	IN.SUBSCRIPTION
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s[%d]"
		,	super.toString()
		,	IN.TICKER_ID
		);
	}

	public CallReqScannerSubscription(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, CallType.reqScannerSubscription);
		OUT_SCANNER_DATA = new OutEvents<OnScannerData>(getRouter());
		OUT_SCANNER_DATA_END = new OutTerminator<OnScannerDataEnd>(getRouter());
	}

	public CallReqScannerSubscription
	(	ConnectionContext aContext
	,	int aTickerId
	,	ScannerSubscription aSubscription
	) {
		this(aContext, new In
		(	aTickerId
		,	aSubscription
		));
	}

}
