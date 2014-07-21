package com.blogspot.mikelaud.ibl.out;

import com.blogspot.mikelaud.ibl.task.event.EventTask;
import com.blogspot.mikelaud.ibl.task.event.EventType;

public interface Out {
	
	EventType getEventType();
	OutType getOutType();
	//
	void notifyMe(EventTask aEvent);
	boolean isDone();
	
}
