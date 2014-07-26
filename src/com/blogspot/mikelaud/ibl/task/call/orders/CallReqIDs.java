package com.blogspot.mikelaud.ibl.task.call.orders;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.out.OutEnd;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.event.orders.OnNextValidId;

/**
 * Call this call to request the next valid ID
 * that can be used when placing an order.
 * 
 * After calling this call, the OnNextValidId event will be triggered,
 * and the id returned is that next valid ID.
 * 
 * That ID will reflect any autobinding that has occurred
 * (which generates new IDs and increments the next valid ID therein).
 */
public class CallReqIDs
	extends CallTaskEx<CallReqIDs.In>
{
	@Override
	public boolean hasRequestId() {
		return false;
	}
	//------------------------------------------------------------------------
	public static class In {
	
		/**
		 * Set to 1.
		 */
		public final int NUM_IDS;
		
		public In() {
			NUM_IDS = 1;
		}
		
	}
	//------------------------------------------------------------------------

	public final OutEnd<OnNextValidId> OUT_NEXT_VALID_ID;
	
	//------------------------------------------------------------------------
	
	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqIds(IN.NUM_IDS);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s { numIds=\"%d\" }"
		,	super.toString()
		,	IN.NUM_IDS
		);
	}

	private CallReqIDs(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
		OUT_NEXT_VALID_ID = new OutEnd<>(this, OnNextValidId.class);
	}

	public CallReqIDs(ConnectionContext aContext) {
		this(aContext, new In());
	}

}
