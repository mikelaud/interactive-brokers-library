package com.blogspot.mikelaud.ibl.task.call.orders;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;

/**
 * Call this call to request the next valid ID
 * that can be used when placing an order.
 * 
 * After calling this call, the EventNextValidId event will be triggered,
 * and the id returned is that next valid ID.
 * 
 * That ID will reflect any autobinding that has occurred
 * (which generates new IDs and increments the next valid ID therein).
 */
public class CallReqIDs
	extends CallTaskEx<CallReqIDs.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * Set to 1.
		 */
		public final int NUM_IDS;
		
		public Info(int aNumIds) {
			NUM_IDS = aNumIds;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqIds(INFO.NUM_IDS);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s { numIds=\"%d\" }"
		,	super.toString()
		,	INFO.NUM_IDS
		);
	}

	public CallReqIDs(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.reqIDs);
	}

	public CallReqIDs(ConnectionContext aContext, int aNumIds) {
		this(aContext, new Info(aNumIds));
	}

}
