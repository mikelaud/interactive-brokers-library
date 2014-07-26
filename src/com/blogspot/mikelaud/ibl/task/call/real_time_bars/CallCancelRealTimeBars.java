package com.blogspot.mikelaud.ibl.task.call.real_time_bars;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTask;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;

/**
 * Call this call to stop receiving real time bar results.
 */
public class CallCancelRealTimeBars
	extends CallTaskEx<CallCancelRealTimeBars.In>
{
	@Override
	public Class<? extends CallTask> getCancelTarget() {
		return CallReqRealTimeBars.class;
	}
	/**
	 * The Id that was specified in the call to CallReqRealTimeBars.
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
		getClientSocket().cancelRealTimeBars(getRequestId());
		return null;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	private CallCancelRealTimeBars(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallCancelRealTimeBars(ConnectionContext aContext) {
		this(aContext, new In());
	}

}
