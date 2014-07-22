package com.blogspot.mikelaud.ibl.task.call.market_data;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.ib.client.Contract;

/**
 * Call this call to calculate volatility
 * for a supplied option price and underlying price.
 */
public class CallCalculateImpliedVolatility
	extends CallTaskEx<CallCalculateImpliedVolatility.In>
{
	/**
	 * The ticker id.
	 */
	@Override
	public boolean hasRequestId() {
		return true;
	}
	//------------------------------------------------------------------------
	public static class In {
	
		/**
		 * Describes the contract.
		 */
		public final Contract OPTION_CONTRACT;
		/**
		 * The price of the option.
		 */
		public final double OPTION_PRICE;
		/**
		 * Price of the underlying.
		 */
		public final double UNDER_PRICE;
		
		public In
		(	Contract aOptionContract
		,	double aOptionPrice
		,	double aUnderPrice
		) {
			OPTION_CONTRACT = aOptionContract;
			OPTION_PRICE = aOptionPrice;
			UNDER_PRICE = aUnderPrice;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().calculateImpliedVolatility
		(	getRequestId()
		,	IN.OPTION_CONTRACT
		,	IN.OPTION_PRICE
		,	IN.UNDER_PRICE
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s { optionPrice=\"%f\" underPrice=\"%f\" }"
		,	super.toString()
		,	IN.OPTION_PRICE
		,	IN.UNDER_PRICE
		);
	}

	public CallCalculateImpliedVolatility(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallCalculateImpliedVolatility
	(	ConnectionContext aContext
	,	Contract aOptionContract
	,	double aOptionPrice
	,	double aUnderPrice
	) {
		this(aContext, new In
		(	aOptionContract
		,	aOptionPrice
		,	aUnderPrice
		));
	}

}
