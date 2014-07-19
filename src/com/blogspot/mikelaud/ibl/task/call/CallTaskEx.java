package com.blogspot.mikelaud.ibl.task.call;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;

/**
 * EClientSocket calls you use when connecting to TWS.
 */
public abstract class CallTaskEx<T> extends CallTask {

	protected final T IN;

	public T getInfo() {
		return IN;
	}
		
	public CallTaskEx
	(	ConnectionContext aContext
	,	T aIn
	,	TaskInnerObject aTaskInnerObject
	) {
		super(aContext, aTaskInnerObject);
		IN = aIn;
	}

}
