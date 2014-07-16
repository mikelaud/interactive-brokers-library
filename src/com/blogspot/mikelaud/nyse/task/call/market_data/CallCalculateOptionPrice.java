package com.blogspot.mikelaud.nyse.task.call.market_data;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.call.CallTaskEx;
import com.blogspot.mikelaud.nyse.task.call.CallType;
import com.ib.client.Contract;

/**
 * Call this call to calculate option price and greek values
 * for a supplied volatility and underlying price.
 */
public class CallCalculateOptionPrice
	extends CallTaskEx<CallCalculateOptionPrice.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
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
		
		public Info
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
		(	INFO.TICKER_ID
		,	INFO.CONTRACT
		,	INFO.VOLATILITY
		,	INFO.UNDER_PRICE
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s[%d] { volatility=\"%f\" underPrice=\"%f\" }"
		,	super.toString()
		,	INFO.TICKER_ID
		,	INFO.VOLATILITY
		,	INFO.UNDER_PRICE
		);
	}

	public CallCalculateOptionPrice(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.calculateOptionPrice);
	}

	public CallCalculateOptionPrice
	(	ConnectionContext aContext
	,	int aTickerId
	,	Contract aContract
	,	double aVolatility
	,	double aUnderPrice
	) {
		this(aContext, new Info
		(	aTickerId
		,	aContract
		,	aVolatility
		,	aUnderPrice
		));
	}

}
