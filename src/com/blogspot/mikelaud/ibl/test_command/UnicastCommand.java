package com.blogspot.mikelaud.ibl.test_command;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTask;

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
