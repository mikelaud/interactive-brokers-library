package com.blogspot.mikelaud.ibl.router.context;

import java.util.HashMap;
import java.util.Map;

import com.blogspot.mikelaud.ibl.task.event.EventTask;
import com.blogspot.mikelaud.ibl.test_command.Command;

public class ContextUnicast extends ContextAbstract {

	private Map<Long,Command> mCommands = new HashMap<Long,Command>();
	
	@Override
	public void addEvent(EventTask aEvent) {
		long requestId = aEvent.getRequestId();
		Command command;
		synchronized (mLock) {
			command = mCommands.remove(requestId);
		}
		if (null != command) {
			command.notifyMe(aEvent);	
		}
	}
	
	@Override
	public void addCommand(Command aCommand) {
		long requestId = aCommand.getCall().getRequestId();
		synchronized (mLock) {
			mCommands.put(requestId, aCommand);
		}
	}
	
	@Override
	public void removeCommand(Command aCommand) {
		long requestId = aCommand.getCall().getRequestId();
		synchronized (mLock) {
			mCommands.remove(requestId);
		}
	}
	
}
