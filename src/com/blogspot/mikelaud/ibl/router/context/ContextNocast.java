package com.blogspot.mikelaud.ibl.router.context;

import com.blogspot.mikelaud.ibl.task.event.EventTask;
import com.blogspot.mikelaud.ibl.test_command.Command;

public class ContextNocast extends ContextAbstract {

	@Override
	public void addEvent(EventTask aEvent) {
		// void
	}

	@Override
	public void addCommand(Command aCommand) {
		// void
	}

	@Override
	public void removeCommand(Command aCommand) {
		// void
	}

}
