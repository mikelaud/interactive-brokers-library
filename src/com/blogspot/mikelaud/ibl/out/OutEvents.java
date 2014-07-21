package com.blogspot.mikelaud.ibl.out;

import com.blogspot.mikelaud.ibl.task.call.CallTask;

public class OutEvents<EVENT_TASK> extends OutAbstract<EVENT_TASK> {

	@Override
	public OutType getOutType() {
		return OutType.EVENTS;
	}

	public OutEvents(CallTask aCallTask, Class<EVENT_TASK> aEventClass) {
		super(aCallTask, aEventClass);
	}

}
