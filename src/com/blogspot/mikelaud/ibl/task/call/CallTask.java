package com.blogspot.mikelaud.ibl.task.call;

import java.util.concurrent.TimeUnit;

import com.blogspot.mikelaud.ibl.Logger;
import com.blogspot.mikelaud.ibl.command.Command;
import com.blogspot.mikelaud.ibl.command.CommandImpl;
import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.router.Router;
import com.blogspot.mikelaud.ibl.router.RouterImpl;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTask;

/**
 * EClientSocket calls you use when connecting to TWS.
 */
public abstract class CallTask extends Task {

	private final CallType CALL_TYPE;
	private final Command COMMAND;
	private final Router ROUTER;

	private Integer mRequestId;
		
	public CallType getCallType() {
		return CALL_TYPE;
	}

	public long getTimeout(TimeUnit aTimeoutUnit) {
		return COMMAND.getTimeout(aTimeoutUnit);
	}
	
	public void setTimeout(long aTimeout, TimeUnit aTimeoutUnit) {
		COMMAND.setTimeout(aTimeout, aTimeoutUnit);
	}
	
	public Router getRouter() {
		return ROUTER;
	}
	
	public int getRequestId() {
		if (null == mRequestId) {
			mRequestId = mContext.nextRequestId();
		}
		return mRequestId.intValue();
	}
	
	protected abstract Task onCall() throws Exception;

	@Override
	public Task call() throws Exception {
		COMMAND.callBefore(this);
		Logger.logCall(toString());
		Task task = onCall();
		COMMAND.callAfter(this);
		return task;
	}

	public void notifyMe(EventTask aEvent) {
		ROUTER.notifyMe(aEvent);
		if (ROUTER.isDone()) {
			COMMAND.notifyMe();
		}
	}
	
	@Override
	public String toString() {
		return CALL_TYPE.toString();
	}
	
	public CallTask
	(	ConnectionContext aContext
	,	TaskInnerObject aTaskInnerObject
	) {
		super(aContext);
		CALL_TYPE = CallTypesFactory.get().toType(aTaskInnerObject);
		COMMAND = new CommandImpl();
		ROUTER = new RouterImpl();
		mRequestId = null;
	}

}
