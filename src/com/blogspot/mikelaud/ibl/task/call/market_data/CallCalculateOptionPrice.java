package com.blogspot.mikelaud.ibl.task.call.market_data;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;
import com.ib.client.Contract;

/**
 * Call this call to calculate option price and greek values
 * for a supplied volatility and underlying price.
 */
public class CallCalculateOptionPrice
	extends CallTaskEx<CallCalculateOptionPrice.In>
{
	//------------------------------------------------------------------------
	public static class In {
	
		/**
		 * The ticker ID.
		 */
		public final int TICKER_ID;
		/**
		 * Describes the contract.
		 */
		public final Contract CONTRACT;
		/**
		 * The volatility.
		 */
		public final double VOLATILITY;
		/**
		 * Price of the underlying.
		 */
		public final double UNDER_PRICE;
		
		public In
		(	int aTickerId
		,	Contract aContract
		,	double aVolatility
		,	double aUnderPrice
		) {
			TICKER_ID = aTickerId;
			CONTRACT = aContract;
			VOLATILITY = aVolatility;
			UNDER_PRICE = aUnderPrice;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().calculateOptionPrice
		(	IN.TICKER_ID
		,	IN.CONTRACT
		,	IN.VOLATILITY
		,	IN.UNDER_PRICE
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s[%d] { volatility=\"%f\" underPrice=\"%f\" }"
		,	super.toString()
		,	IN.TICKER_ID
		,	IN.VOLATILITY
		,	IN.UNDER_PRICE
		);
	}

	public CallCalculateOptionPrice(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, CallType.calculateOptionPrice);
	}

	public CallCalculateOptionPrice
	(	ConnectionContext aContext
	,	int aTickerId
	,	Contract aContract
	,	double aVolatility
	,	double aUnderPrice
	) {
		this(aContext, new In
		(	aTickerId
		,	aContract
		,	aVolatility
		,	aUnderPrice
		));
	}

}
