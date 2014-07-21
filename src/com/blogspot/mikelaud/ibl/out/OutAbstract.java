package com.blogspot.mikelaud.ibl.out;

import java.util.concurrent.atomic.AtomicReference;

import com.blogspot.mikelaud.ibl.Logger;
import com.blogspot.mikelaud.ibl.router.Router;
import com.blogspot.mikelaud.ibl.task.call.CallTask;
import com.blogspot.mikelaud.ibl.task.event.EventTask;
import com.blogspot.mikelaud.ibl.task.event.EventType;
import com.blogspot.mikelaud.ibl.task.event.EventTypesFactory;

public abstract class OutAbstract<EVENT_TASK> implements Out {
	
	private Class<EVENT_TASK> mEventClass;
	private EventType mEventType;
	private AtomicReference<EVENT_TASK> mAtomicEventTask;
	
	protected void addEvent(EVENT_TASK aEventTask) {
		if (mAtomicEventTask.compareAndSet(null, aEventTask)) {
			// void
		}
		else {
			Logger.logLost(aEventTask.toString());
		}
	}
	
	public EVENT_TASK getEvent() {
		return mAtomicEventTask.get();
	}

	@Override
	public EventType getEventType() {
		return mEventType;
	}
	
	@Override
	public void notifyMe(EventTask aEvent) {
		if (aEvent.getEventType() == mEventType) {
			EVENT_TASK eventTask = mEventClass.cast(aEvent);
			addEvent(eventTask);
		}
		else {
			Logger.logLost(aEvent.toString());
		}
	}
	
	@Override
	public boolean isDone() {
		return (null != mAtomicEventTask.get());
	}
		
	public OutAbstract(CallTask aCallTask, Class<EVENT_TASK> aEventClass) {
		mEventClass = aEventClass;
		mEventType = EventTypesFactory.get().toType(mEventClass);
		mAtomicEventTask = new AtomicReference<>(null);
		//
		Router router = aCallTask.getRouter(); 
		router.addOut(this);
	}
	
}
