package com.blogspot.mikelaud.ibl.router.context;

import java.util.HashSet;
import java.util.Set;

import com.blogspot.mikelaud.ibl.task.event.EventTask;
import com.blogspot.mikelaud.ibl.test_command.Command;

public class ContextMulticast extends ContextAbstract {

	private Set<Command> mCommands = new HashSet<Command>();
	
	@Override
	public void addEvent(EventTask aEvent) {
		Set<Command> commandsCopy = null;
		synchronized (mLock) {
			int commandsCount = mCommands.size();
			if (commandsCount > 0) {
				commandsCopy = new HashSet<Command>(commandsCount);
				commandsCopy.addAll(mCommands);
				mCommands.clear();
			}
		}
		if (null != commandsCopy) {
			for (Command command : commandsCopy) {
				command.notifyMe(aEvent);
			}
			commandsCopy.clear();
		}
	}
	
	@Override
	public void addCommand(Command aCommand) {
		synchronized (mLock) {
			mCommands.add(aCommand);
		}
	}
	
	@Override
	public void removeCommand(Command aCommand) {
		synchronized (mLock) {
			mCommands.remove(aCommand);
		}
	}
	
}
