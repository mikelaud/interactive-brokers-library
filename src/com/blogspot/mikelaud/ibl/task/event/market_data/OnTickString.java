package com.blogspot.mikelaud.ibl.task.event.market_data;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;
import com.blogspot.mikelaud.ibl.task.event.EventType;

/**
 * This event is called when the market data changes.
 * Values are updated immediately with no delay.
 */
public class OnTickString
	extends EventTaskEx<OnTickString.Info>
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
		 * For example, a field value of 45 will map to lastTimestamp, etc.
		 */
		public final int TICK_TYPE;
		/**
		 * The value of the specified field.
		 */
		public final String VALUE;		
		
		public Info(int aTickerId, int aTickType, String aValue) {
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
		(	"%s(%s)[%d] { tickType=\"%d\" }"
		,	super.toString()
		,	INFO.VALUE
		,	INFO.TICKER_ID
		,	INFO.TICK_TYPE
		);
	}
	
	public OnTickString(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, EventType.tickString);
	}

}
