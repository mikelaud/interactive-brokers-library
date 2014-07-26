package com.blogspot.mikelaud.ibl.task.call.market_depth;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTask;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;

/**
 * After calling this call,
 * market depth data for the specified Id will stop flowing.
 */
public class CallCancelMktDepth
	extends CallTaskEx<CallCancelMktDepth.In>
{
	@Override
	public Class<? extends CallTask> getCancelTarget() {
		return CallReqMktDepth.class;
	}
	/**
	 * The Id that was specified in the call to CallReqMktDepth.
	 */
	@Override
	public boolean hasRequestId() {
		return true;
	}
	//------------------------------------------------------------------------
	public static class In {
	
		public In() {
			// void
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().cancelMktDepth(getRequestId());
		return null;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	private CallCancelMktDepth(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallCancelMktDepth(ConnectionContext aContext) {
		this(aContext, new In());
	}

}
