package com.blogspot.mikelaud.ibl.task.call.account_and_portfolio;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.out.OutEvent;
import com.blogspot.mikelaud.ibl.out.OutEvents;
import com.blogspot.mikelaud.ibl.out.OutTerminator;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.event.account_and_portfolio.OnAccountDownloadEnd;
import com.blogspot.mikelaud.ibl.task.event.account_and_portfolio.OnUpdateAccountTime;
import com.blogspot.mikelaud.ibl.task.event.account_and_portfolio.OnUpdateAccountValue;
import com.blogspot.mikelaud.ibl.task.event.account_and_portfolio.OnUpdatePortfolio;

/**
 * Call this call to start getting account values, portfolio,
 * and last update time information.
 * The account data will be fed back through the OnUpdateAccountTime,
 * OnUpdateAccountValue and OnUpdatePortfolio EWrapper events.
 * 
 * The account information resulting from the invocation of CallReqAccountUpdates
 * is the same information that appears in Trader Workstation’s Account Window.
 * When trying to determine the definition of each variable
 * or key within the API account data,
 * it is essential that you use the TWS Account Window as guidance.
 * 
 * To identify API Account keys: The API’s OnUpdateAccountValue event handler
 * delivers all of the account information.
 * 
 *   - Strings or keys with a suffix of –C, such as AvailableFunds-C,
 *     EquityForInitial-C, NetLiquidation-C, correspond to Commodities
 *     in the TWS Account Window.
 *     
 *   - Keys with a suffix of –S, such as EquityForMaintenance-S,
 *     FullAvailableFunds-S or NetLiquidation-S, correspond to Securities
 *     in the TWS Account Window.
 *     
 *   - Keys without any suffix correspond to Totals in the TWS Account Window.
 *   
 * For more information about the information presented
 * in the TWS Account Window, see:
 * https://institutions.interactivebrokers.com/en/software/tws/usersguidebook/realtimeactivitymonitoring/the_account_window.htm
 */
public class CallReqAccountUpdates
	extends CallTaskEx<CallReqAccountUpdates.In>
{
	//------------------------------------------------------------------------
	public static class In {
	
		/**
		 * If set to TRUE, the client will start receiving account
		 * and portfolio updates.
		 * If set to FALSE, the client will stop receiving this information.
		 */
		public final boolean SUBSCRIBE;
		/**
		 * The account code for which to receive account
		 * and portfolio updates.
		 */
		public final String ACCT_CODE;
		
		public In
		(	boolean aSubscribe
		,	String aAcctCode
		) {
			SUBSCRIBE = aSubscribe;
			ACCT_CODE = aAcctCode;
		}
		
	}
	//------------------------------------------------------------------------

	public final OutEvent<OnUpdateAccountTime> OUT_UPDATE_ACCOUNT_TIME;
	public final OutEvents<OnUpdateAccountValue> OUT_UPDATE_ACCOUNT_VALUE;
	public final OutEvents<OnUpdatePortfolio> OUT_UPDATE_PORTFOLIO;
	public final OutTerminator<OnAccountDownloadEnd> OUT_ACCOUNT_DOWNLOAD_END;
	
	//------------------------------------------------------------------------
	
	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqAccountUpdates
		(	IN.SUBSCRIBE
		,	IN.ACCT_CODE
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s { subscribe=\"%b\" acctCode=\"%s\" }"
		,	super.toString()
		,	IN.SUBSCRIBE
		,	IN.ACCT_CODE
		);
	}

	public CallReqAccountUpdates(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
		OUT_UPDATE_ACCOUNT_TIME = new OutEvent<>(this, OnUpdateAccountTime.class);
		OUT_UPDATE_ACCOUNT_VALUE = new OutEvents<>(this, OnUpdateAccountValue.class);
		OUT_UPDATE_PORTFOLIO = new OutEvents<>(this, OnUpdatePortfolio.class);
		OUT_ACCOUNT_DOWNLOAD_END = new OutTerminator<>(this, OnAccountDownloadEnd.class);
	}

}
