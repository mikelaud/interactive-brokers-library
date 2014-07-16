package com.blogspot.mikelaud.nyse.task.event.market_data;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.event.EventTaskEx;
import com.blogspot.mikelaud.nyse.task.event.EventType;

/**
 * This event is called when the market data changes.
 * Values are updated immediately with no delay.
 */
public class OnTickGeneric
	extends EventTaskEx<OnTickGeneric.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The ticker Id that was specified previously
		 * in the call to CallReqMktData.
		 */
		public final int TICKER_ID;
		/**
		 * Specifies the type of price.
		 * Pass the field value into TickType.getField(int tickType)
		 * to retrieve the field description.
		 * For example, a field value of 46 will map to shortable, etc.
		 */
		public final int TICK_TYPE;
		/**
		 * The value of the specified field.
		 */
		public final double VALUE;
		
		public Info(int aTickerId, int aTickType, double aValue) {
			TICKER_ID = aTickerId;
			TICK_TYPE = aTickType;
			VALUE = aValue;
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
		(	"%s[%d](%f) { tickType=\"%d\" }"
		,	super.toString()
		,	INFO.TICKER_ID
		,	INFO.VALUE
		,	INFO.TICK_TYPE
		);
	}
	
	public OnTickGeneric(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, EventType.tickGeneric);
	}

}
