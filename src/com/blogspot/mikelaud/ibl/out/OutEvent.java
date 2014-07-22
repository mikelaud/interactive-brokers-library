package com.blogspot.mikelaud.ibl.out;

import com.blogspot.mikelaud.ibl.task.call.CallTask;
import com.blogspot.mikelaud.ibl.task.event.EventTask;

public class OutEvent<EVENT_TASK extends EventTask> extends OutAbstract<EVENT_TASK> {
	
	@Override
	public OutType getOutType() {
		return OutType.EVENT;
	}

	public OutEvent(CallTask aCallTask, Class<EVENT_TASK> aEventClass) {
		super(aCallTask, aEventClass);
	}

}
