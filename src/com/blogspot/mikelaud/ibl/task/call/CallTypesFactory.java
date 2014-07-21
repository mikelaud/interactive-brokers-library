package com.blogspot.mikelaud.ibl.task.call;

public class CallTypesFactory {

	private static final CallTypes CALL_TYPES = new CallTypes();
	
	public static final CallTypes get() {
		return CALL_TYPES;
	}
	
}
