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
	
	@Override
	public EventType getEventType() {
		return mEventType;
	}
	
	@Override
	public void notifyMe(EventTask aEvent) {
		if (aEvent.getEventType() == mEventType) {
			@SuppressWarnings("unchecked")
			EVENT_TASK eventTask = (EVENT_TASK) aEvent;
			if (mAtomicEventTask.compareAndSet(null, eventTask)) {
				// void
			}
			else {
				Logger.logLost(aEvent.toString());
			}
		}
		else {
			Logger.logLost(aEvent.toString());
		}
	}
	
	@Override
	public boolean isDone() {
		return (null != mAtomicEventTask.get());
	}
	
	public EVENT_TASK getEvent() {
		return mAtomicEventTask.get();
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
