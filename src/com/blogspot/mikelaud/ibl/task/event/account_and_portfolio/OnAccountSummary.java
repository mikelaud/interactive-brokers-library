package com.blogspot.mikelaud.ibl.task.event.account_and_portfolio;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;

/**
 * Returns the data from the TWS Account Window Summary tab
 * in response to CallReqAccountSummary.
 */
public class OnAccountSummary
	extends EventTaskEx<OnAccountSummary.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The ID of the data request.
		 */
		public final int REQ_ID;
		/**
		 * The account ID.
		 */
		public final String ACCOUNT;
		/**
		 * The tag from the data request. Available tags are:
		 *     AccountType
		 *     TotalCashValue: Total cash including futures pnl
		 *     SettledCash: For cash accounts,
		 *                   this is the same as TotalCashValue
		 *     AccruedCash: Net accrued interest
		 *     BuyingPower: The maximum amount of marginable US stocks
		 *                   the account can buy
		 *     EquityWithLoanValue: Cash + stocks + bonds + mutual funds
		 *     PreviousEquityWithLoanValue
		 *     GrossPositionValue: The sum of the absolute value of all stock
		 *                          and equity option positions
		 *     RegTEquity
		 *     RegTMargin
		 *     SMA: Special Memorandum Account
		 *     InitMarginReq
		 *     MaintMarginReq
		 *     AvailableFunds
		 *     ExcessLiquidity
		 *     Cushion: Excess liquidity as a percentage
		 *               of net liquidation value
		 *     FullInitMarginReq
		 *     FullMaintMarginReq
		 *     FullAvailableFunds
		 *     FullExcessLiquidity
		 *     LookAheadNextChange: Time when look-ahead values take effect
		 *     LookAheadInitMarginReq
		 *     LookAheadMaintMarginReq
		 *     LookAheadAvailableFunds
		 *     LookAheadExcessLiquidity
		 *     HighestSeverity: A measure of how close
		 *                       the account is to liquidation
		 *     DayTradesRemaining: The Number of Open/Close trades a user
		 *                          could put on before Pattern Day Trading
		 *                          is detected. A value of "-1" means
		 *                          that the user can put on unlimited day trades.
		 *     Leverage: GrossPositionValue / NetLiquidation
		 */
		public final String TAG;
		/**
		 * The value of the tag.
		 */
		public final String VALUE;
		/**
		 * The currency of the tag.
		 */
		public final String CURRENCY;
		
		public Info
		(	int aReqId
		,	String aAccount
		,	String aTag
		,	String aValue
		,	String aCurrency
		) {
			REQ_ID = aReqId;
			ACCOUNT = aAccount;
			TAG = aTag;
			VALUE = aValue;
			CURRENCY = aCurrency;
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
		(	"%s(%s)[%d] { tag=\"%s\" value=\"%s\" currency=\"%s\" }"
		,	super.toString()
		,	INFO.ACCOUNT
		,	INFO.REQ_ID
		,	INFO.TAG
		,	INFO.VALUE
		,	INFO.CURRENCY
		);
	}

	public OnAccountSummary(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, new TaskInnerObject(){});
	}

}
