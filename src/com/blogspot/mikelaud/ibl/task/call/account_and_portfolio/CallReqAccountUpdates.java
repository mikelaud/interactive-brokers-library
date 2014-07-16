package com.blogspot.mikelaud.ibl.task.call.account_and_portfolio;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;

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
	extends CallTaskEx<CallReqAccountUpdates.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
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
		
		public Info
		(	boolean aSubscribe
		,	String aAcctCode
		) {
			SUBSCRIBE = aSubscribe;
			ACCT_CODE = aAcctCode;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqAccountUpdates
		(	INFO.SUBSCRIBE
		,	INFO.ACCT_CODE
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s { subscribe=\"%b\" acctCode=\"%s\" }"
		,	super.toString()
		,	INFO.SUBSCRIBE
		,	INFO.ACCT_CODE
		);
	}

	public CallReqAccountUpdates(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.reqAccountUpdates);
	}

	public CallReqAccountUpdates
	(	ConnectionContext aContext
	,	boolean aSubscribe
	,	String aAcctCode
	) {
		this(aContext, new Info
		(	aSubscribe
		,	aAcctCode
		));
	}

}
