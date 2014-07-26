package com.blogspot.mikelaud.ibl.task.event;

import java.util.List;

import com.blogspot.mikelaud.ibl.Config;
import com.blogspot.mikelaud.ibl.Logger;
import com.blogspot.mikelaud.ibl.command.Command;
import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTask;
import com.blogspot.mikelaud.ibl.task.call.CallType;

/**
 * EWrapper events you can use when connecting to TWS.
 */
public abstract class EventTask extends Task {

	private final EventType EVENT_TYPE;

	private boolean notifyUnicastCall() {
		boolean done = false;
		int requestId = getRequestId();
		if (getRequestId() > Config.getNoRequestId()) {
			CallTask callTask = getContext().getUnicastCall(requestId);
			if (null != callTask) {
				callTask.notifyMe(this);
				done = true;
			}
		}
		return done;
	}
	
	private void addEvent() {
		List<CallType> targetCalls =
			EventTargetsFactory.get().getTargets(EVENT_TYPE);
		//
		if (targetCalls.size() > 0) {
			for (CallType targetCallType : targetCalls) {
				targetCallType.getContext(null).addEvent(this);
			}
		}
		else {
			if (! notifyUnicastCall()) {
				logLost(); 
			}
		}
	}

	public EventType getEventType() {
		return EVENT_TYPE;
	}
		
	protected abstract Task onEvent() throws Exception;

	@Override
	public Task call() throws Exception {
		Task nextTask = onEvent();
		addEvent();
		return nextTask;
	}

	@Override
	public String toString() {
		return EVENT_TYPE.toString();
	}

	public void logEvent(Command aCommand) {
		aCommand.incrementEvents();
		Logger.logEvent(getRequestId(), aCommand.getEventsCount(), toString());
	}
	
	public void logLost() {
		Logger.logLost(getRequestId(), toString());
	}

	public void logStream() {
		Logger.logStream(getRequestId(), toString());
	}

	public EventTask
	(	ConnectionContext aContext
	,	TaskInnerObject aTaskInnerObject
	) {
		super(aContext);
		EVENT_TYPE = EventTypesFactory.get().toType(aTaskInnerObject);
	}

}
