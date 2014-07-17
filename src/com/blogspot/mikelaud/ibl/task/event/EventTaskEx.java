package com.blogspot.mikelaud.ibl.task.event;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;

/**
 * EWrapper events you can use when connecting to TWS.
 */
public abstract class EventTaskEx<T> extends EventTask {

	protected final T INFO;
		
	public T getInfo() {
		return INFO; 
	}

	public EventTaskEx(ConnectionContext aContext, T aInfo, EventType aEventType) {
		super(aContext, aEventType);
		INFO = aInfo;
	}

}
