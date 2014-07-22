package com.blogspot.mikelaud.ibl.task.call.account_and_portfolio;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.out.OutEvents;
import com.blogspot.mikelaud.ibl.out.OutTerminator;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.event.account_and_portfolio.OnPosition;
import com.blogspot.mikelaud.ibl.task.event.account_and_portfolio.OnPositionEnd;

/**
 * Requests real-time position data for all accounts.
 * 
 * Note: This request can only be made when connected
 *       to a Financial Advisor (FA) account.
 */
public class CallReqPositions
	extends CallTaskEx<CallReqPositions.In>
{
	@Override
	public boolean hasRequestId() {
		return false;
	}
	//------------------------------------------------------------------------
	public static class In {
	
		public In() {
			// void
		}
		
	}	
	//------------------------------------------------------------------------
	
	public final OutEvents<OnPosition> OUT_POSITION;
	public final OutTerminator<OnPositionEnd> OUT_POSITION_END;

	//------------------------------------------------------------------------
	
	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqPositions();
		return null;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	private CallReqPositions(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
		OUT_POSITION = new OutEvents<>(this, OnPosition.class);
		OUT_POSITION_END = new OutTerminator<>(this, OnPositionEnd.class);
	}

	public CallReqPositions(ConnectionContext aContext) {
		this(aContext, new In());
	}

}
