package com.blogspot.mikelaud.ibl.task.call.market_scanners;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.out.OutEvents;
import com.blogspot.mikelaud.ibl.out.OutTerminator;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
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
	/**
	 * The Id for the subscription. Must be a unique value. When the
	 * subscription data is received, it will be identified by this Id.
	 * This is also used when canceling the scanner.
	 */
	@Override
	public boolean hasRequestId() {
		return true;
	}
	//------------------------------------------------------------------------
	public static class In {
	
		/**
		 * Summary of the scanner subscription parameters including filters.
		 */
		public final ScannerSubscription SUBSCRIPTION;
		
		public In(ScannerSubscription aSubscription) {
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
		(	getRequestId()
		,	IN.SUBSCRIPTION
		);
		return null;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public CallReqScannerSubscription(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
		OUT_SCANNER_DATA = new OutEvents<>(this, OnScannerData.class);
		OUT_SCANNER_DATA_END = new OutTerminator<>(this, OnScannerDataEnd.class);
	}

	public CallReqScannerSubscription
	(	ConnectionContext aContext
	,	ScannerSubscription aSubscription
	) {
		this(aContext, new In(aSubscription));
	}

}
