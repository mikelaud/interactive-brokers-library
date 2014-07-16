package com.blogspot.mikelaud.ibl.task.call.fundamental_data;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.call.CallType;

/**
 * Call this call to stop receiving Reuters global fundamental data.
 */
public class CallCancelFundamentalData
	extends CallTaskEx<CallCancelFundamentalData.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The ID of the data request.
		 */
		public final int REQ_ID;
		
		public Info(int aReqId) {
			REQ_ID = aReqId;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().cancelFundamentalData(INFO.REQ_ID);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s[%d]"
		,	super.toString()
		,	INFO.REQ_ID
		);
	}

	public CallCancelFundamentalData(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, CallType.cancelFundamentalData);
	}

	public CallCancelFundamentalData(ConnectionContext aContext, int aReqId) {
		this(aContext, new Info(aReqId));
	}

}
