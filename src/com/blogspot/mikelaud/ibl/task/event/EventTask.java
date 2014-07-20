package com.blogspot.mikelaud.ibl.task.event;

import java.util.List;

import com.blogspot.mikelaud.ibl.Logger;
import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallType;

/**
 * EWrapper events you can use when connecting to TWS.
 */
public abstract class EventTask extends Task {

	private final EventType EVENT_TYPE;

	private void addEvent() {
		List<CallType> targetCalls =
			EventTargetsFactory.EVENT_TARGETS.getTargets(EVENT_TYPE);
		//
		for (CallType targetCallType : targetCalls) {
			targetCallType.getContext().addEvent(this);
		}
	}

	public EventType getEventType() {
		return EVENT_TYPE;
	}
	
	public int getRequestId() { // TODO
		return 0;
	}
	
	protected abstract Task onEvent() throws Exception;

	@Override
	public Task call() throws Exception {
		Logger.logEvent(toString());
		Task nextTask = onEvent();
		addEvent();
		return nextTask;
	}

	@Override
	public String toString() {
		return EVENT_TYPE.toString();
	}
	
	public EventTask
	(	ConnectionContext aContext
	,	TaskInnerObject aTaskInnerObject
	) {
		super(aContext);
		EVENT_TYPE = EventTypesFactory.EVENT_TYPES.toType(aTaskInnerObject);
	}

}
