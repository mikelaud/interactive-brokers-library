package com.blogspot.mikelaud.ibl.task.call.real_time_bars;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.out.OutStream;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.event.real_time_bars.OnRealtimeBar;
import com.blogspot.mikelaud.ibl.types.IblBarSize;
import com.blogspot.mikelaud.ibl.types.IblUseRth;
import com.blogspot.mikelaud.ibl.types.IblWhatToShow;
import com.blogspot.mikelaud.ibl.types.common.IblSymbol;
import com.ib.client.Contract;

/**
 * Call the CallReqRealTimeBars call to start receiving real time bar results
 * through the OnRealtimeBar EWrapper event.
 */
public class CallReqRealTimeBars
	extends CallTaskEx<CallReqRealTimeBars.In>
{
	/**
	 * The Id for the request. Must be a unique value. When the data is
	 * received, it will be identified by this Id. This is also used when
	 * canceling the historical data request.
	 */
	@Override
	public boolean hasRequestId() {
		return true;
	}
	//------------------------------------------------------------------------
	public static class In {
	
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
				
		public In
		(	Contract aContract
		,	IblBarSize aBarSize
		,	IblWhatToShow aWhatToShow
		,	IblUseRth aUseRTH
		) {
			CONTRACT = aContract;
			BAR_SIZE = (int) aBarSize.getDuration().getSeconds();
			WHAT_TO_SHOW = aWhatToShow.getName();
			USE_RTH = aUseRTH.getBooleanValue();
		}
		
	}
	//------------------------------------------------------------------------

	public final OutStream<OnRealtimeBar> STREAM_REALTIME_BAR;
	
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqRealTimeBars
		(	getRequestId()
		,	IN.CONTRACT
		,	IN.BAR_SIZE
		,	IN.WHAT_TO_SHOW
		,	IN.USE_RTH
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s { barSize=\"%d\" whatToShow=\"%s\" useRth=\"%b\" }"
		,	super.toString()
		,	IN.BAR_SIZE
		,	IN.WHAT_TO_SHOW
		,	IN.USE_RTH
		);
	}

	public CallReqRealTimeBars(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
		STREAM_REALTIME_BAR = new OutStream<>(this, OnRealtimeBar.class);
	}

	public CallReqRealTimeBars
	(	ConnectionContext aContext
	,	IblSymbol aSymbol
	) {
		this(aContext, new In
		(	new Contract()
		,	IblBarSize.BAR_5_SEC
		,	IblWhatToShow.TRADES
		,	IblUseRth.ALL_DATA
		));
		IN.CONTRACT.m_symbol = aSymbol.getName();
		IN.CONTRACT.m_secType = aSymbol.getSecurityType().getName(); 
		IN.CONTRACT.m_currency = aSymbol.getCurrency().getName();
		IN.CONTRACT.m_exchange = aSymbol.getExchange().getName();
		IN.CONTRACT.m_primaryExch = aSymbol.getPrimaryExchange().getName();
	}

}
