package com.blogspot.mikelaud.nyse.task.command;

import java.util.HashSet;
import java.util.Set;

import com.blogspot.mikelaud.nyse.task.event.EventTask;

public class MulticastContext {

	private Object mLock = new Object();
	private Set<MulticastCommand> mCommands = new HashSet<MulticastCommand>();
	
	public void addEvent(EventTask aEvent) {
		Set<MulticastCommand> commandsCopy = null;
		synchronized (mLock) {
			int commandsCount = mCommands.size();
			if (commandsCount > 0) {
				commandsCopy = new HashSet<MulticastCommand>(commandsCount);
				commandsCopy.addAll(mCommands);
				mCommands.clear();
			}
		}
		if (null != commandsCopy) {
			for (MulticastCommand command : commandsCopy) {
				command.notifyMe(aEvent);
			}
			commandsCopy.clear();
		}
	}
	
	public void addCommand(MulticastCommand aCommand) {
		synchronized (mLock) {
			mCommands.add(aCommand);
		}
	}
	
	public void removeCommand(MulticastCommand aCommand) {
		synchronized (mLock) {
			mCommands.remove(aCommand);
		}
	}
	
}
