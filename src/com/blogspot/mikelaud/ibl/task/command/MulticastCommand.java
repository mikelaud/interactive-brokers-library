package com.blogspot.mikelaud.ibl.task.command;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTask;

public class MulticastCommand extends Command {

	@Override
	protected void addToContext() {
		mCall.getCallType().getMulticastContext().addCommand(this);
	}

	@Override
	protected void removeFromContext() {
		mCall.getCallType().getMulticastContext().removeCommand(this);
	}

	@Override
	protected Task onCall() throws Exception {
		return callWithTimeout();
	}
	
	public MulticastCommand(ConnectionContext aContext, CallTask aCall) {
		super(aContext, aCall);		
	}

}
