package com.blogspot.mikelaud.ibl.task.event.historical_data;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;

/**
 * This event receives the requested historical data results.
 */
public class OnHistoricalData
	extends EventTaskEx<OnHistoricalData.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The ticker Id of the request to which this bar is responding.
		 */
		public final int REQ_ID;
		/**
		 * The date-time stamp of the start of the bar.
		 * The format is determined
		 * by the CallReqHistoricalData formatDate parameter.
		 */
		public final String DATE;
		/**
		 * The bar opening price.
		 */
		public final double OPEN;
		/**
		 * The high price during the time covered by the bar.
		 */
		public final double HIGH;
		/**
		 * The low price during the time covered by the bar.
		 */
		public final double LOW;
		/**
		 * The bar closing price.
		 */
		public final double CLOSE;
		/**
		 * The volume during the time covered by the bar.
		 */
		public final int VOLUME;
		/**
		 * When TRADES historical data is returned,
		 * represents the number of trades
		 * that occurred during the time period the bar covers.
		 */
		public final int COUNT;
		/**
		 * The weighted average price during the time covered by the bar.
		 */
		public final double WAP;
		/**
		 * Whether or not there are gaps in the data.
		 */
		public final boolean HAS_GAPS;
		
		public Info
		(	int aReqId
		,	String aDate
		,	double aOpen
		,	double aHigh
		,	double aLow
		,	double aClose
		,	int aVolume
		,	int aCount
		,	double aWAP
		,	boolean aHasGaps
		) {
			REQ_ID = aReqId;
			DATE = aDate;
			OPEN = aOpen;
			HIGH = aHigh;
			LOW = aLow;
			CLOSE = aClose;
			VOLUME = aVolume;
			COUNT = aCount;
			WAP = aWAP;
			HAS_GAPS = aHasGaps;
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
		(	"%s[%d] { date=\"%s\" open=\"%f\" high=\"%f\" low=\"%f\" close=\"%f\" volume=\"%d\" count=\"%d\" wap=\"%f\" hasGaps=\"%b\" }"
		,	super.toString()
		,	INFO.REQ_ID
		,	INFO.DATE
		,	INFO.OPEN
		,	INFO.HIGH
		,	INFO.LOW
		,	INFO.CLOSE
		,	INFO.VOLUME
		,	INFO.COUNT
		,	INFO.WAP
		,	INFO.HAS_GAPS
		);
	}
	
	public OnHistoricalData(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, new TaskInnerObject(){});
	}

}
