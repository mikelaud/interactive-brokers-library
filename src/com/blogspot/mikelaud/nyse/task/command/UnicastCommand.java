package com.blogspot.mikelaud.nyse.task.command;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.call.CallTask;

public class UnicastCommand extends Command {

	@Override
	protected void addToContext() {
		mCall.getCallType().getUnicastContext().addCommand(this);
	}

	@Override
	protected void removeFromContext() {
		mCall.getCallType().getUnicastContext().removeCommand(this);
	}

	@Override
	protected Task onCall() throws Exception {
		return callWithTimeout();
	}

	public UnicastCommand(ConnectionContext aContext, CallTask aCall) {
		super(aContext, aCall);
	}

}
