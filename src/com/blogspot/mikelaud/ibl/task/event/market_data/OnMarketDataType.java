package com.blogspot.mikelaud.ibl.task.event.market_data;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;
import com.blogspot.mikelaud.ibl.task.event.EventType;

/**
 * TWS sends a OnMarketDataType event to the API,
 * where type is set to Frozen or RealTime, to announce
 * that market data has been switched between frozen and real-time.
 * 
 * This notification occurs only when market data switches between
 * real-time and frozen. The OnMarketDataType event accepts
 * a reqId parameter and is sent per every subscription because
 * different contracts can generally trade on a different schedule.
 */
public class OnMarketDataType
	extends EventTaskEx<OnMarketDataType.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * Id of the data request.
		 */
		public final int REQ_ID;
		/**
		 * 1 for real-time streaming market data or 2 for frozen market data.
		 */
		public final int MARKET_DATA_TYPE;
		
		public Info(int aReqId, int aMarketDataType) {
			REQ_ID = aReqId;
			MARKET_DATA_TYPE = aMarketDataType;
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
		(	"%s[%d] { marketDataType=\"%d\" }"
		,	super.toString()
		,	INFO.REQ_ID
		,	INFO.MARKET_DATA_TYPE
		);
	}
	
	public OnMarketDataType(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, EventType.marketDataType);
	}

}
