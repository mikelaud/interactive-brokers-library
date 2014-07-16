package com.blogspot.mikelaud.nyse.task.command;

import java.util.HashMap;
import java.util.Map;

import com.blogspot.mikelaud.nyse.task.event.EventTask;

public class UnicastContext {

	private Object mLock = new Object();
	private Map<Long,UnicastCommand> mCommands = new HashMap<Long,UnicastCommand>();
	
	public void addEvent(EventTask aEvent) {
		long requestId = aEvent.getRequestId();
		UnicastCommand command;
		synchronized (mLock) {
			command = mCommands.remove(requestId);
		}
		if (null != command) {
			command.notifyMe(aEvent);	
		}
	}
	
	public void addCommand(UnicastCommand aCommand) {
		long requestId = aCommand.getCall().getRequestId();
		synchronized (mLock) {
			mCommands.put(requestId, aCommand);
		}
	}
	
	public void removeCommand(UnicastCommand aCommand) {
		long requestId = aCommand.getCall().getRequestId();
		synchronized (mLock) {
			mCommands.remove(requestId);
		}
	}
	
}
