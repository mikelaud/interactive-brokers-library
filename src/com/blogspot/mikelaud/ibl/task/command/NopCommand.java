package com.blogspot.mikelaud.nyse.task.command;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.call.CallTask;

public class NopCommand extends Command {

	@Override
	protected void addToContext() {
		// void
	}

	@Override
	protected void removeFromContext() {
		// void
	}

	@Override
	protected Task onCall() throws Exception {
		return null;
	}

	public NopCommand(ConnectionContext aContext, CallTask aCall) {
		super(aContext, aCall);
	}

}
