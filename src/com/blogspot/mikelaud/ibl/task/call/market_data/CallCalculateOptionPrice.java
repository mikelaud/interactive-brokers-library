package com.blogspot.mikelaud.ibl.task.call.market_data;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.ib.client.Contract;

/**
 * Call this call to calculate option price and greek values
 * for a supplied volatility and underlying price.
 */
public class CallCalculateOptionPrice
	extends CallTaskEx<CallCalculateOptionPrice.In>
{
	/**
	 * The ticker ID.
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
		(	Contract aContract
		,	double aVolatility
		,	double aUnderPrice
		) {
			CONTRACT = aContract;
			VOLATILITY = aVolatility;
			UNDER_PRICE = aUnderPrice;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().calculateOptionPrice
		(	getRequestId()
		,	IN.CONTRACT
		,	IN.VOLATILITY
		,	IN.UNDER_PRICE
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s { volatility=\"%f\" underPrice=\"%f\" }"
		,	super.toString()
		,	IN.VOLATILITY
		,	IN.UNDER_PRICE
		);
	}

	public CallCalculateOptionPrice(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallCalculateOptionPrice
	(	ConnectionContext aContext
	,	Contract aContract
	,	double aVolatility
	,	double aUnderPrice
	) {
		this(aContext, new In
		(	aContract
		,	aVolatility
		,	aUnderPrice
		));
	}

}
