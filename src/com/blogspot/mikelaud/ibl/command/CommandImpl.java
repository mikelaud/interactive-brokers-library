package com.blogspot.mikelaud.ibl.command;

import java.util.concurrent.TimeUnit;

import com.blogspot.mikelaud.ibl.Logger;
import com.blogspot.mikelaud.ibl.task.call.CallKind;
import com.blogspot.mikelaud.ibl.task.call.CallTask;
import com.blogspot.mikelaud.ibl.task.event.EventTask;

public class CommandImpl implements Command {

	private Object mTimeoutLock = new Object();
	private long mTimeoutMs = 0;
	//
	private long mBeginTimeMs = 0;
	private long mWaitTimeMs = 0;
	//
	private EventTask mEvent = null;
	
	private void resetTimeout() {
		mBeginTimeMs = System.currentTimeMillis();
		mWaitTimeMs = mTimeoutMs;
	}
	
	private boolean reachTimeout() {
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

	@Override
	public void callBefore(CallTask aCall) throws Exception {
		if (CallKind.NOCAST == aCall.getCallType().getKind()) return;
		Logger.logCommandBegin(toString(aCall));
		aCall.getCallType().getContext().addCommand(aCall);
	}
	
	@Override
	public void callAfter(CallTask aCall) throws Exception {
		if (CallKind.NOCAST == aCall.getCallType().getKind()) return;
		resetTimeout();
		for (;;) {
			if (reachTimeout()) {
				aCall.getCallType().getContext().removeCommand(aCall);
				break;
			}
			synchronized (mTimeoutLock) {
				if (null != mEvent) break;
				mTimeoutLock.wait(mWaitTimeMs);
			}
		}
		Logger.logCommandEnd(toString(aCall));
	}
	
	@Override
	public void notifyMe(EventTask aEvent) {
		synchronized (mTimeoutLock) {
			if (null == mEvent) {
				mEvent = aEvent;
				mTimeoutLock.notifyAll();
			}
		}
	}
	
	@Override
	public long getTimeout(TimeUnit aTimeoutUnit) {
		return aTimeoutUnit.convert(mTimeoutMs, TimeUnit.MILLISECONDS);
	}

	@Override
	public void setTimeout(long aTimeout, TimeUnit aTimeoutUnit) {
		mTimeoutMs = TimeUnit.MILLISECONDS.convert(aTimeout, aTimeoutUnit);
	}

	@Override
	public String toString(CallTask aCall) {
		return String.format("%s.%s", aCall.getCallType().getKind().toString(), aCall.toString());
	}
	
	public CommandImpl() {
		resetTimeout();
	}
	
}
