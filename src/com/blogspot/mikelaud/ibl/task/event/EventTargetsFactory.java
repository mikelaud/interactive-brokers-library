package com.blogspot.mikelaud.ibl.task.event;

public class EventTargetsFactory {

	private static final EventTargets EVENT_TARGETS = new EventTargets();
	
	public static final EventTargets get() {
		return EVENT_TARGETS;
	}
	
}
