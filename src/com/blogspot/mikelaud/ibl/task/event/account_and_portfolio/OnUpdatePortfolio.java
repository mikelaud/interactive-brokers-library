package com.blogspot.mikelaud.ibl.task.event.account_and_portfolio;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;
import com.ib.client.Contract;

/**
 * This event is called only when CallReqAccountUpdates() call
 * on the EClientSocket object has been called.
 */
public class OnUpdatePortfolio
	extends EventTaskEx<OnUpdatePortfolio.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * This structure contains a description of the contract
		 * which is being traded. The exchange field in a contract
		 * is not set for portfolio update.
		 */
		public final Contract CONTRACT;
		/**
		 * This integer indicates the position on the contract.
		 * If the position is 0, it means the position has just cleared.
		 */
		public final int POSITION;
		/**
		 * The unit price of the instrument.
		 */
		public final double MARKET_PRICE;
		/**
		 * The total market value of the instrument.
		 */
		public final double MARKET_VALUE;
		/**
		 * The average cost per share is calculated by dividing your cost
		 * (execution price + commission) by the quantity of your position.
		 */
		public final double AVERAGE_COST;
		/**
		 * The difference between the current market value
		 * of your open positions and the average cost,
		 * or Value - Average Cost.
		 */
		public final double UNREALIZED_PNL;
		/**
		 * Shows your profit on closed positions,
		 * which is the difference between your entry execution cost
		 * (execution price + commissions to open the position)
		 * and exit execution cost (execution price + commissions
		 * to close the position)
		 */
		public final double REALIZED_PNL;
		/**
		 * The name of the account to which the message applies.
		 * Useful for Financial Advisor sub-account messages.
		 */
		public final String ACCOUNT_NAME;
		
		public Info
		(	Contract aContract
		,	int aPosition
		,	double aMarketPrice
		,	double aMarketValue
		,	double aAverageCost
		,	double aUnrealizedPNL
		,	double aRealizedPNL
		,	String aAccountName		
		) {
			CONTRACT = aContract;
			POSITION = aPosition;
			MARKET_PRICE = aMarketPrice;
			MARKET_VALUE = aMarketValue;
			AVERAGE_COST = aAverageCost;
			UNREALIZED_PNL = aUnrealizedPNL;
			REALIZED_PNL = aRealizedPNL;
			ACCOUNT_NAME = aAccountName;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	public int getRequestId() {
		return getNoRequestId();
	}

	@Override
	protected Task onEvent() throws Exception {
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s { position=\"%d\" marketPrice=\"%f\" marketValue=\"%f\" averageCost=\"%f\" unrealizedPnl=\"%f\" realizedPnl=\"%f\" accountName=\"%s\" }"
		,	super.toString()
		,	INFO.POSITION
		,	INFO.MARKET_PRICE
		,	INFO.MARKET_VALUE
		,	INFO.AVERAGE_COST
		,	INFO.UNREALIZED_PNL
		,	INFO.REALIZED_PNL
		,	INFO.ACCOUNT_NAME
		);
	}

	public OnUpdatePortfolio(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, new TaskInnerObject(){});
	}

}
