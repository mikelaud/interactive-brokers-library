package com.blogspot.mikelaud.ibl.task.command;

import java.util.concurrent.TimeUnit;

import com.blogspot.mikelaud.ibl.Logger;
import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallTask;
import com.blogspot.mikelaud.ibl.task.event.EventTask;

public abstract class Command extends Task {

	protected Object mTimeoutLock;
	protected long mTimeoutMs;
	//
	protected CallTask mCall;
	protected EventTask mEvent;
	//
	protected long mBeginTimeMs;
	protected long mWaitTimeMs;
		
	protected abstract void addToContext();
	protected abstract void removeFromContext();
	
	protected abstract Task onCall() throws Exception;

	protected Task callWithTimeout() throws Exception {
		addToContext();
		mCall.call();
		resetTimeout();
		for (;;) {
			if (reachTimeout()) {
				removeFromContext();
				break;
			}
			synchronized (mTimeoutLock) {
				if (null != mEvent) break;
				mTimeoutLock.wait(mWaitTimeMs);
			}
		}
		return null;
	}
	
	protected void resetTimeout() {
		mBeginTimeMs = System.currentTimeMillis();
		mWaitTimeMs = mTimeoutMs;
	}

	protected boolean reachTimeout() {
		long timeMs = System.currentTimeMillis();
		if (timeMs < mBeginTimeMs) { // guard
			timeMs = mBeginTimeMs;
		}
		long deltaTimeMs = timeMs - mBeginTimeMs;
		if (deltaTimeMs >= mTimeoutMs) {
			mWaitTimeMs = 0;
			return true;
		}
		else {
			mWaitTimeMs = mTimeoutMs - deltaTimeMs;
			return false;
		}
	}
	
	public void setTimeout(long aTimeout, TimeUnit aTimeoutUnit) {
		mTimeoutMs = TimeUnit.MILLISECONDS.convert(aTimeout, aTimeoutUnit);
	}

	public CallTask getCall() { return mCall; }
	public EventTask getEvent() { return mEvent; }

	@Override
	public Task call() throws Exception {
		Logger.logCommandBegin(toString());
		Task nextTask = onCall();
		Logger.logCommandEnd(toString());
		return nextTask;
	}
	
	public void notifyMe(EventTask aEvent) {
		synchronized (mTimeoutLock) {
			if (null == mEvent) {
				mEvent = aEvent;
				mTimeoutLock.notifyAll();
			}
		}
	}

	@Override
	public String toString() {
		return String.format("%s.%s", mCall.getCallType().getKind().toString(), mCall.toString());
	}
	
	public Command(ConnectionContext aContext, CallTask aCall) {
		super(aContext);
		mTimeoutLock = new Object();
		mTimeoutMs = 0;
		//
		mCall = aCall;
		mEvent = null;
		//
		resetTimeout();
	}

}
