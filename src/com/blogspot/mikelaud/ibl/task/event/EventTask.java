package com.blogspot.mikelaud.ibl.task.event;

import com.blogspot.mikelaud.ibl.Logger;
import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallKind;
import com.blogspot.mikelaud.ibl.task.call.CallType;

/**
 * EWrapper events you can use when connecting to TWS.
 */
public abstract class EventTask extends Task {

	protected final EventType EVENT_TYPE;
		
	public EventType getEventType() { return EVENT_TYPE; }

	private void addEvent() {
		CallType targetCallType = EVENT_TYPE.getTargetCallType();
		if (null != targetCallType) {
			CallKind callKind = targetCallType.getKind();
			switch (callKind) {
				case MULTICAST:
					targetCallType.getMulticastContext().addEvent(this);
					break;
				case UNICAST:
					targetCallType.getUnicastContext().addEvent(this);
					break;
				default:
					break;
			}
		}
	}
	
	public int getRequestId() { return 0; } // TODO
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
	
	public EventTask(ConnectionContext aContext, EventType aEventType) {
		super(aContext);
		EVENT_TYPE = aEventType;
	}

}
