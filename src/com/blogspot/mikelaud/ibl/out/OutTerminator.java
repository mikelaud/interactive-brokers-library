package com.blogspot.mikelaud.ibl.out;

import com.blogspot.mikelaud.ibl.task.call.CallTask;

public class OutTerminator<EVENT_TASK> extends OutEvent<EVENT_TASK> {

	@Override
	public OutType getOutType() {
		return OutType.TERMINATOR;
	}
	
	public OutTerminator(CallTask aCallTask, Class<EVENT_TASK> aEventClass) {
		super(aCallTask, aEventClass);
	}

}
