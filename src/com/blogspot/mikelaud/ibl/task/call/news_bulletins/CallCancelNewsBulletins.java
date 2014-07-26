package com.blogspot.mikelaud.ibl.task.call.news_bulletins;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTask;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;

/**
 * Call this call to stop receiving news bulletins.
 */
public class CallCancelNewsBulletins
	extends CallTaskEx<CallCancelNewsBulletins.In>
{
	@Override
	public Class<? extends CallTask> getCancelTarget() {
		return CallReqNewsBulletins.class;
	}

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

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().cancelNewsBulletins();
		return null;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	private CallCancelNewsBulletins(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallCancelNewsBulletins(ConnectionContext aContext) {
		this(aContext, new In());
	}

}
