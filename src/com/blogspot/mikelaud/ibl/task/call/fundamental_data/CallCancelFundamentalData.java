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
	//------------------------------------------------------------------------
	public static class In {
	
		/**
		 * The ID of the data request.
		 */
		public final int REQ_ID;
		
		public In(int aReqId) {
			REQ_ID = aReqId;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().cancelFundamentalData(IN.REQ_ID);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s[%d]"
		,	super.toString()
		,	IN.REQ_ID
		);
	}

	public CallCancelFundamentalData(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallCancelFundamentalData(ConnectionContext aContext, int aReqId) {
		this(aContext, new In(aReqId));
	}

}
