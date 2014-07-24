package com.blogspot.mikelaud.ibl.router.context;

import com.blogspot.mikelaud.ibl.task.call.CallTask;
import com.blogspot.mikelaud.ibl.task.event.EventTask;

public class ContextNocast extends ContextAbstract {

	@Override
	public void addEvent(EventTask aEvent) {
		// void
	}

	@Override
	public void addCommand(CallTask aCall) {
		// void
	}

	@Override
	public void removeCommand(CallTask aCall) {
		// void
	}

}
