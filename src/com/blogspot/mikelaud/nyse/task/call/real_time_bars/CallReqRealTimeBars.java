package com.blogspot.mikelaud.nyse.task.call.real_time_bars;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.call.CallTaskEx;
import com.blogspot.mikelaud.nyse.task.call.CallType;
import com.ib.client.Contract;

/**
 * Call the CallReqRealTimeBars call to start receiving real time bar results
 * through the OnRealtimeBar EWrapper event.
 */
public class CallReqRealTimeBars
	extends CallTaskEx<CallReqRealTimeBars.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The Id for the request. Must be a unique value. When the data is
		 * received, it will be identified by this Id. This is also used when
		 * canceling the historical data request.
		 */
		public final int TICKER_ID;
		/**
		 * This class contains attributes used to describe the contract.
		 */
		public final Contract CONTRACT;
		/**
		 * Currently only 5 second bars are supported,
		 * if any other value is used, an exception will be thrown. 
		 */
		public final int BAR_SIZE;
		/**
		 * Determines the nature of the data extracted. Valid values include:
		 *     TRADES
		 *     BID
		 *     ASK
		 *     MIDPOINT
		 */
		public final String WHAT_TO_SHOW;
		/**
		 * Regular Trading Hours only. Valid values include:
		 *     0 = all data available during the time span requested is
		 *         returned, including time intervals when the market in
		 *         question was outside of regular trading hours.
		 *     1 = only data within the regular trading hours for the product
		 *         requested is returned, even if the time time span falls
		 *         partially or completely outside.

		 */
		public final boolean USE_RTH;
				
		public Info
		(	int aTickerId
		,	Contract aContract
		,	int aBarSize
		,	String aWhatToShow
		,	boolean aUseRTH
		) {
			TICKER_ID = aTickerId;
			CONTRACT = aContract;
			BAR_SIZE = aBarSize;
			WHAT_TO_SHOW = aWhatToShow;
			USE_RTH = aUseRTH;	
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqRealTimeBars
		(	INFO.TICKER_ID
		,	INFO.CONTRACT
		,	INFO.BAR_SIZE
		,	INFO.WHAT_TO_SHOW
		,	INFO.USE_RTH
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s[%d] { barSize=\"%d\" whatToShow=\"%s\" useRth=\"%b\" }"
		,	super.toString()
		,	INFO.TICKER_ID
		,	INFO.BAR_SIZE
		,	INFO.WHAT_TO_SHOW
		,	INFO.USE_RTH
		);
	}

	public CallReqRealTimeBars(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.reqRealTimeBars);
	}

	public CallReqRealTimeBars
	(	ConnectionContext aContext
	,	int aTickerId
	,	Contract aContract
	,	int aBarSize
	,	String aWhatToShow
	,	boolean aUseRTH
	) {
		this(aContext, new Info
		(	aTickerId
		,	aContract
		,	aBarSize
		,	aWhatToShow
		,	aUseRTH
		));
	}

}
