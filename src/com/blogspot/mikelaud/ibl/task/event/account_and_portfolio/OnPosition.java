package com.blogspot.mikelaud.ibl.task.event.account_and_portfolio;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;
import com.blogspot.mikelaud.ibl.task.event.EventType;
import com.ib.client.Contract;

/**
 * This event returns real-time positions for all accounts
 * in response to the CallReqPositions call.
 */
public class OnPosition
	extends EventTaskEx<OnPosition.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The account.
		 */
		public final String ACCOUNT;
		/**
		 * This structure contains a full description
		 * of the contract that was executed.
		 */
		public final Contract CONTRACT;
		/**
		 * The position.
		 */
		public final int POS;
		/**
		 * Agv cost.
		 */
		public final double AVG_COST;
		
		public Info
		(	String aAccount
		,	Contract aContract
		,	int aPos
		,	double aAvgCost
		) {
			ACCOUNT = aAccount;
			CONTRACT = aContract;
			POS = aPos;
			AVG_COST = aAvgCost;
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
		(	"%s(%d) { account=\"%s\" avgCost=\"%f\" }"
		,	super.toString()
		,	INFO.POS
		,	INFO.ACCOUNT
		,	INFO.AVG_COST
		);
	}

	public OnPosition(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, EventType.position);
	}

}
