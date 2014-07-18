package com.blogspot.mikelaud.ibl.test_command;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTask;

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
