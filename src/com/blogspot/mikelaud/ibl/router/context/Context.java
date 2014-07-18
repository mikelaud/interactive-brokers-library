package com.blogspot.mikelaud.ibl.router.context;

import com.blogspot.mikelaud.ibl.task.call.CallTask;
import com.blogspot.mikelaud.ibl.task.event.EventTask;

public interface Context {

	void addEvent(EventTask aEvent);
	//
	void addCommand(CallTask aCall);
	void removeCommand(CallTask aCall);
	
}
