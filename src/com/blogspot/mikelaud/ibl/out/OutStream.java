package com.blogspot.mikelaud.ibl.out;

import com.blogspot.mikelaud.ibl.task.call.CallTask;
import com.blogspot.mikelaud.ibl.task.event.EventTask;

public class OutStream<EVENT_TASK extends EventTask> extends OutAbstract<EVENT_TASK> {

	@Override
	public void notifyMe(EventTask aEvent) {
		aEvent.logStream();
	}

	@Override
	public OutType getOutType() {
		return OutType.STREAM;
	}
	
	public OutStream(CallTask aCallTask, Class<EVENT_TASK> aEventClass) {
		super(aCallTask, aEventClass);
	}

}
