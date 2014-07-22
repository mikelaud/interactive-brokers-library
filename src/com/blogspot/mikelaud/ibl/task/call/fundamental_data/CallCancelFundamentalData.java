package com.blogspot.mikelaud.ibl.task.call.fundamental_data;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;

/**
 * Call this call to stop receiving Reuters global fundamental data.
 */
public class CallCancelFundamentalData
	extends CallTaskEx<CallCancelFundamentalData.In>
{
	/**
	 * The ID of the data request.
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
		getClientSocket().cancelFundamentalData(getRequestId());
		return null;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	private CallCancelFundamentalData(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallCancelFundamentalData(ConnectionContext aContext) {
		this(aContext, new In());
	}

}
