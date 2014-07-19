package com.blogspot.mikelaud.ibl.task.event;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;

/**
 * EWrapper events you can use when connecting to TWS.
 */
public abstract class EventTaskEx<T> extends EventTask {

	protected final T INFO;
		
	public T getInfo() {
		return INFO; 
	}

	public EventTaskEx
	(	ConnectionContext aContext
	,	T aInfo
	,	TaskInnerObject aTaskInnerObject
	) {
		super(aContext, aTaskInnerObject);
		INFO = aInfo;
	}

}
