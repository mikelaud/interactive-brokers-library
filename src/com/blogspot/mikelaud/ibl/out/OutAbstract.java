package com.blogspot.mikelaud.ibl.out;

import java.util.concurrent.atomic.AtomicReference;

import com.blogspot.mikelaud.ibl.router.Router;
import com.blogspot.mikelaud.ibl.task.call.CallTask;
import com.blogspot.mikelaud.ibl.task.event.EventTask;
import com.blogspot.mikelaud.ibl.task.event.EventType;
import com.blogspot.mikelaud.ibl.task.event.EventTypesFactory;

public abstract class OutAbstract<EVENT_TASK extends EventTask> implements Out {
	
	private final Class<EVENT_TASK> EVENT_CLASS;
	private final EventType EVENT_TYPE;
	private final AtomicReference<EVENT_TASK> ATOMIC_EVENT_TASK;
	
	protected boolean setEvent(EVENT_TASK aEventTask) {
		return ATOMIC_EVENT_TASK.compareAndSet(null, aEventTask);
	}
	
	protected void addEvent(EVENT_TASK aEventTask) {
		if (setEvent(aEventTask)) {
			// void
		}
		else {
			aEventTask.logLost();
		}
	}
	
	public EVENT_TASK getEvent() {
		return ATOMIC_EVENT_TASK.get();
	}

	@Override
	public EventType getEventType() {
		return EVENT_TYPE;
	}
	
	@Override
	public void notifyMe(EventTask aEvent) {
		if (aEvent.getEventType() == EVENT_TYPE) {
			EVENT_TASK eventTask = EVENT_CLASS.cast(aEvent);
			addEvent(eventTask);
		}
		else {
			aEvent.logLost();
		}
	}
	
	@Override
	public boolean isDone() {
		return (null != ATOMIC_EVENT_TASK.get());
	}
		
	public OutAbstract(CallTask aCallTask, Class<EVENT_TASK> aEventClass) {
		EVENT_CLASS = aEventClass;
		EVENT_TYPE = EventTypesFactory.get().toType(EVENT_CLASS);
		ATOMIC_EVENT_TASK = new AtomicReference<>(null);
		//
		Router router = aCallTask.getRouter(); 
		router.addOut(this);
	}
	
}
