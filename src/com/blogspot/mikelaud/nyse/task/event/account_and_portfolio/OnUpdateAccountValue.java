package com.blogspot.mikelaud.nyse.task.event.account_and_portfolio;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.event.EventTaskEx;
import com.blogspot.mikelaud.nyse.task.event.EventType;

/**
 * This event is called only when CallReqAccountUpdates call
 * on the EClientSocket object has been called.
 */
public class OnUpdateAccountValue
	extends EventTaskEx<OnUpdateAccountValue.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * A string that indicates one type of account value.
		 * There is a long list of possible keys that can be sent,
		 * here are just a few examples:
		 *     CashBalance - account cash balance
		 *     DayTradesRemaining - number of day trades left
		 *     EquityWithLoanValue - equity with Loan Value
		 *     InitMarginReq - current initial margin requirement
		 *     MaintMarginReq - current maintenance margin
		 *     NetLiquidation - net liquidation value
		 */
		public final String KEY;
		/**
		 * The value associated with the key.
		 */
		public final String VALUE;
		/**
		 * Defines the currency type, in case the value is a currency type.
		 */
		public final String CURRENCY;
		/**
		 * States the account the message applies to.
		 * Useful for Financial Advisor sub-account messages.
		 */
		public final String ACCOUNT_NAME;
		
		public Info
		(	String aKey
		,	String aValue
		,	String aCurrency
		,	String aAccountName
		) {
			KEY = aKey;
			VALUE = aValue;
			CURRENCY = aCurrency;
			ACCOUNT_NAME = aAccountName;
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
		(	"%s(%s) { key=\"%s\" currency=\"%s\" accountName=\"%s\" }"
		,	super.toString()
		,	INFO.VALUE
		,	INFO.KEY
		,	INFO.CURRENCY
		,	INFO.ACCOUNT_NAME
		);
	}

	public OnUpdateAccountValue(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, EventType.updateAccountValue);
	}

}
