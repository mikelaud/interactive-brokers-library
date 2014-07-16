package com.blogspot.mikelaud.ibl.task.call;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;

/**
 * EClientSocket calls you use when connecting to TWS.
 */
public abstract class CallTaskEx<T> extends CallTask {

	protected final T INFO;

	public T getInfo() { return INFO;  }
		
	public CallTaskEx(ConnectionContext aContext, T aInfo, CallType aCallType) {
		super(aContext, aCallType);
		INFO = aInfo;
	}

}
