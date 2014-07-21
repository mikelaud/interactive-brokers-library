package com.blogspot.mikelaud.ibl.task.event.orders;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;

/**
 * This is called at the end of a given request for open orders.
 */
public class OnOpenOrderEnd
	extends EventTaskEx<OnOpenOrderEnd.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		public Info() {
			// void
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	public int getRequestId() {
		return getNoRequestId();
	}

	@Override
	protected Task onEvent() throws Exception {
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s"
		,	super.toString()
		);
	}
	
	public OnOpenOrderEnd(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, new TaskInnerObject(){});
	}

}
