package com.blogspot.mikelaud.ibl.out;

import com.blogspot.mikelaud.ibl.task.call.CallTask;

public class OutEvent<EVENT_TASK> extends OutAbstract<EVENT_TASK> {
	
	@Override
	public OutType getOutType() {
		return OutType.EVENT;
	}

	public OutEvent(CallTask aCallTask, Class<EVENT_TASK> aEventClass) {
		super(aCallTask, aEventClass);
	}

}
