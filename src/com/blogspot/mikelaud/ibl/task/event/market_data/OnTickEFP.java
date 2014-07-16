package com.blogspot.mikelaud.ibl.task.event.market_data;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;
import com.blogspot.mikelaud.ibl.task.event.EventType;

/**
 * This event is called when the market data changes.
 * Values are updated immediately with no delay.
 */
public class OnTickEFP
	extends EventTaskEx<OnTickEFP.Info>
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
		 * For example, a field value of 38 will map to bidEFP, etc.
		 */
		public final int TICK_TYPE;
		/**
		 * Annualized basis points, which is representative of the financing rate
		 * that can be directly compared to broker rates.
		 */
		public final double BASIS_POINTS;
		/**
		 * Annualized basis points as a formatted string
		 * that depicts them in percentage form.
		 */
		public final String FORMATTED_BASIS_POINTS;
		/**
		 * Implied futures price.
		 */
		public final double IMPLIED_FUTURE;
		/**
		 * The number of hold days until the expiry of the EFP.
		 */
		public final int HOLD_DAYS;
		/**
		 * The expiration date of the single stock future.
		 */
		public final String FUTURE_EXPIRY;
		/**
		 * The dividend impact upon the annualized basis points interest rate.
		 */
		public final double DIVIDENT_IMPACT;
		/**
		 * The dividends expected until the expiration
		 * of the single stock future.
		 */
		public final double DIVIDENTS_TO_EXPIRY;

		public Info
		(	int aTickerId
		,	int aTickType
		,	double aBasisPoints
		,	String aFormattedBasisPoints
		,	double aImpliedFuture
		,	int aHoldDays
		,	String aFutureExpiry
		,	double aDividendImpact
		,	double aDividendsToExpiry
		) {
			TICKER_ID = aTickerId;
			TICK_TYPE = aTickType;
			BASIS_POINTS = aBasisPoints;
			FORMATTED_BASIS_POINTS = aFormattedBasisPoints;
			IMPLIED_FUTURE = aImpliedFuture;
			HOLD_DAYS = aHoldDays;
			FUTURE_EXPIRY = aFutureExpiry;
			DIVIDENT_IMPACT = aDividendImpact;
			DIVIDENTS_TO_EXPIRY = aDividendsToExpiry;
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
		(	"%s[%d] { tickType=\"%d\" basisPoints=\"%f\" formattedBasisPoints=\"%s\" impliedFuture=\"%f\" holdDays=\"%d\" futureExpiry=\"%s\" dividendImpact=\"%f\" dividendsToExpiry=\"%f\" }"
		,	super.toString()
		,	INFO.TICKER_ID
		,	INFO.TICK_TYPE
		,	INFO.BASIS_POINTS
		,	INFO.FORMATTED_BASIS_POINTS
		,	INFO.IMPLIED_FUTURE
		,	INFO.HOLD_DAYS
		,	INFO.FUTURE_EXPIRY
		,	INFO.DIVIDENT_IMPACT
		,	INFO.DIVIDENTS_TO_EXPIRY
		);
	}
	
	public OnTickEFP(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, EventType.tickEFP);
	}

}
