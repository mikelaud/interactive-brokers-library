package com.blogspot.mikelaud.ibl.task.call;

import java.util.concurrent.TimeUnit;

import com.blogspot.mikelaud.ibl.Config;
import com.blogspot.mikelaud.ibl.Logger;
import com.blogspot.mikelaud.ibl.command.Command;
import com.blogspot.mikelaud.ibl.command.CommandImpl;
import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.router.Router;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTask;

/**
 * EClientSocket calls you use when connecting to TWS.
 */
public abstract class CallTask extends Task {

	private final Command COMMAND;
	private final CallType CALL_TYPE;
	//
	private CallKind mCallKind;
	private Integer mRequestId;
	
	private CallKind createCallKind() {
		CallKind callKind = CallKind.NOCAST;
		if (COMMAND.getRouter().hasOut()) {
			if (hasRequestId()) {
				callKind = CallKind.UNICAST;
			}
			else {
				callKind = CallKind.MULTICAST;
			}
		}
		else {
			callKind = CallKind.NOCAST;
		}
		return callKind;
	}
	
	public long getTimeout(TimeUnit aTimeoutUnit) {
		return COMMAND.getTimeout(aTimeoutUnit);
	}
	
	public void setTimeout(long aTimeout, TimeUnit aTimeoutUnit) {
		COMMAND.setTimeout(aTimeout, aTimeoutUnit);
	}

	public Router getRouter() {
		return COMMAND.getRouter();
	}

	public CallType getCallType() {
		return CALL_TYPE;
	}

	public CallKind getCallKind() {
		if (null == mCallKind) {
			mCallKind = createCallKind();
		}
		return mCallKind;
	}	
			
	@Override
	public int getRequestId() {
		int requestId;
		if (hasRequestId()) {
			if (null == mRequestId) {
				mRequestId = CONTEXT.nextRequestId();
			}
			requestId = mRequestId.intValue();
		}
		else {
			requestId = Config.getNoRequestId();
		}
		return requestId;
	}
	
	public abstract boolean hasRequestId();
	
	public boolean hasNoRequestId() {
		return ! hasRequestId();
	}

	public void notifyMe(EventTask aEvent) {
		COMMAND.notifyMe(aEvent);
	}

	protected abstract Task onCall() throws Exception;

	@Override
	public Task call() throws Exception {
		COMMAND.callBefore(this);
		Logger.logCall(getRequestId(), toString());
		Task task = onCall();
		COMMAND.callAfter(this);
		return task;
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
		COMMAND = new CommandImpl();
		CALL_TYPE = CallTypesFactory.get().toType(aTaskInnerObject);
		mCallKind = null;
		mRequestId = null;
	}

}
