package com.blogspot.mikelaud.ibl.task.event;

public class EventTypesFactory {

	private static final EventTypes EVENT_TYPES = new EventTypes();
	
	public static final EventTypes get() {
		return EVENT_TYPES;
	}
	
}
