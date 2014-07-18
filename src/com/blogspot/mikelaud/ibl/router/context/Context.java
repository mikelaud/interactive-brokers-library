package com.blogspot.mikelaud.ibl.router.context;

import com.blogspot.mikelaud.ibl.task.event.EventTask;
import com.blogspot.mikelaud.ibl.test_command.Command;

public interface Context {

	void addEvent(EventTask aEvent);
	//
	void addCommand(Command aCommand);
	void removeCommand(Command aCommand);
	
}
