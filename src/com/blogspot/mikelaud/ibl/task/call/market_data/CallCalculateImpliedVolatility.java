package com.blogspot.mikelaud.nyse.task.call.market_data;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.call.CallTaskEx;
import com.blogspot.mikelaud.nyse.task.call.CallType;
import com.ib.client.Contract;

/**
 * Call this call to calculate volatility
 * for a supplied option price and underlying price.
 */
public class CallCalculateImpliedVolatility
	extends CallTaskEx<CallCalculateImpliedVolatility.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The ticker id.
		 */
		public final int REQ_ID;
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
		
		public Info
		(	int aReqId
		,	Contract aOptionContract
		,	double aOptionPrice
		,	double aUnderPrice
		) {
			REQ_ID = aReqId;
			OPTION_CONTRACT = aOptionContract;
			OPTION_PRICE = aOptionPrice;
			UNDER_PRICE = aUnderPrice;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().calculateImpliedVolatility
		(	INFO.REQ_ID
		,	INFO.OPTION_CONTRACT
		,	INFO.OPTION_PRICE
		,	INFO.UNDER_PRICE
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s[%d] { optionPrice=\"%f\" underPrice=\"%f\" }"
		,	super.toString()
		,	INFO.REQ_ID
		,	INFO.OPTION_PRICE
		,	INFO.UNDER_PRICE
		);
	}

	public CallCalculateImpliedVolatility(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.calculateImpliedVolatility);
	}

	public CallCalculateImpliedVolatility
	(	ConnectionContext aContext
	,	int aReqId
	,	Contract aOptionContract
	,	double aOptionPrice
	,	double aUnderPrice
	) {
		this(aContext, new Info
		(	aReqId
		,	aOptionContract
		,	aOptionPrice
		,	aUnderPrice
		));
	}

}
