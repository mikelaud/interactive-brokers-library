package com.blogspot.mikelaud.ibl.task.call;

import com.blogspot.mikelaud.ibl.Logger;
import com.blogspot.mikelaud.ibl.command.Command;
import com.blogspot.mikelaud.ibl.command.CommandImpl;
import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.router.Router;
import com.blogspot.mikelaud.ibl.task.Task;

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
	
	public Command getCommand() {
		return COMMAND;
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

	@Override
	public String toString() {
		return CALL_TYPE.toString();
	}
	
	public CallTask(ConnectionContext aContext, CallType aCallType) {
		super(aContext);
		CALL_TYPE = aCallType;
		COMMAND = new CommandImpl();
		ROUTER = null;
		mRequestId = null;
	}

}
