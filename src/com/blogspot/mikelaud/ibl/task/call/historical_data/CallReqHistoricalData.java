package com.blogspot.mikelaud.ibl.task.call.historical_data;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.out.OutEvents;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.event.historical_data.OnHistoricalData;
import com.ib.client.Contract;

/**
 * Call the CallReqHistoricalData call to start receiving
 * historical data results through the OnHistoricalData EWrapper event.
 * 
 * Note: For more information about historical data request limitations,
 *       see Historical Data Limitations:
 * https://www.interactivebrokers.com/en/software/api/apiguide/tables/historical_data_limitations.htm
 */
public class CallReqHistoricalData
	extends CallTaskEx<CallReqHistoricalData.In>
{
	//------------------------------------------------------------------------
	public static class In {
	
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
		 * Use the format yyyymmdd hh:mm:ss tmz, where the time zone is
		 * allowed (optionally) after a space at the end.
		 */
		public final String END_DATE_TIME;
		/**
		 * This is the time span the request will cover, and is specified
		 * using the format: <integer> <unit>,
		 * i.e., 1 D, where valid units are:
		 *     " S (seconds)
		 *     " D (days)
		 *     " W (weeks)
		 *     " M (months)
		 *     " Y (years)
		 * If no unit is specified, seconds are used.
		 * Also, note "years" is currently limited to one.
		 */
		public final String DURATION_STR;
		/**
		 * Specifies the size of the bars that will be returned
		 * (within IB/TWS limits). Valid bar size values include:
		 *     1 sec
		 *     5 secs
		 *     15 secs
		 *     30 secs
		 *     1 min
		 *     2 mins
		 *     3 mins
		 *     5 mins
		 *     15 mins
		 *     30 mins
		 *     1 hour
		 *     1 day
		 */
		public final String BAR_SIZE_SETTING;
		/**
		 * Determines the nature of data being extracted.
		 * Valid values include:
		 *     TRADES
		 *     MIDPOINT
		 *     BID
		 *     ASK
		 *     BID_ASK
		 *     HISTORICAL_VOLATILITY
		 *     OPTION_IMPLIED_VOLATILITY
		 */
		public final String WHAT_TO_SHOW;
		/**
		 * Determines whether to return all data available during
		 * the requested time span, or only data that falls within
		 * regular trading hours. Valid values include:
		 *     0 - all data is returned even where the market in question
		 *         was outside of its regular trading hours.
		 *     1 - only data within the regular trading hours is returned,
		 *         even if the requested time span falls partially or
		 *         completely outside of the RTH.
		 */
		public final int USE_RTH;
		/**
		 * Determines the date format applied to returned bars.
		 * Valid values include:
		 *     1 - dates applying to bars returned in the format:
		 *         yyyymmdd{space}{space}hh:mm:dd
		 *     2 - dates are returned as a long integer specifying the number
		 *         of seconds since 1/1/1970 GMT.
		 */
		public final int FORMAT_DATE;
				
		public In
		(	int aTickerId
		,	Contract aContract
		,	String aEndDateTime
		,	String aDurationStr
		,	String aBarSizeSetting
		,	String aWhatToShow
		,	int aUseRTH
		,	int aFormatDate
		) {
			TICKER_ID = aTickerId;
			CONTRACT = aContract;
			END_DATE_TIME = aEndDateTime;
			DURATION_STR = aDurationStr;
			BAR_SIZE_SETTING = aBarSizeSetting;
			WHAT_TO_SHOW = aWhatToShow;
			USE_RTH = aUseRTH;
			FORMAT_DATE = aFormatDate;
		}
		
	}
	//------------------------------------------------------------------------

	public final OutEvents<OnHistoricalData> OUT_HISTORICAL_DATA;
	
	//------------------------------------------------------------------------
	
	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqHistoricalData
		(	IN.TICKER_ID
		,	IN.CONTRACT
		,	IN.END_DATE_TIME
		,	IN.DURATION_STR
		,	IN.BAR_SIZE_SETTING
		,	IN.WHAT_TO_SHOW
		,	IN.USE_RTH
		,	IN.FORMAT_DATE
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s[%d] { endDateTime=\"%s\" durationStr=\"%s\" barSizeSetting=\"%s\" whatToShow=\"%s\" useRth=\"%d\" formatDate=\"%d\" }"
		,	super.toString()
		,	IN.TICKER_ID
		,	IN.END_DATE_TIME
		,	IN.DURATION_STR
		,	IN.BAR_SIZE_SETTING
		,	IN.WHAT_TO_SHOW
		,	IN.USE_RTH
		,	IN.FORMAT_DATE
		);
	}

	public CallReqHistoricalData(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
		OUT_HISTORICAL_DATA = new OutEvents<OnHistoricalData>(getRouter());
	}

	public CallReqHistoricalData
	(	ConnectionContext aContext
	,	int aTickerId
	,	Contract aContract
	,	String aEndDateTime
	,	String aDurationStr
	,	String aBarSizeSetting
	,	String aWhatToShow
	,	int aUseRTH
	,	int aFormatDate
	) {
		this(aContext, new In
		(	aTickerId
		,	aContract
		,	aEndDateTime
		,	aDurationStr
		,	aBarSizeSetting
		,	aWhatToShow
		,	aUseRTH
		,	aFormatDate
		));
	}

}
