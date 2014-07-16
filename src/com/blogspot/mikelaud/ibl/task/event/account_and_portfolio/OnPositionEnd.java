package com.blogspot.mikelaud.nyse.task.event.account_and_portfolio;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.event.EventTaskEx;
import com.blogspot.mikelaud.nyse.task.event.EventType;

/**
 * This is called once all position data for a given request are received
 * and functions as an end marker for the OnPosition data.
 */
public class OnPositionEnd
	extends EventTaskEx<OnPositionEnd.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		public Info() {
			// void
		}
		
	}
	//------------------------------------------------------------------------

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

	public OnPositionEnd(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, EventType.positionEnd);
	}

}
