package com.blogspot.mikelaud.ibl.command;

import java.util.concurrent.TimeUnit;

import com.blogspot.mikelaud.ibl.Config;
import com.blogspot.mikelaud.ibl.Logger;
import com.blogspot.mikelaud.ibl.task.call.CallKind;
import com.blogspot.mikelaud.ibl.task.call.CallTask;

public class CommandImpl implements Command {

	private Object mTimeoutLock = new Object();
	private long mTimeoutMs;
	//
	private long mBeginTimeMs = 0;
	private long mWaitTimeMs = 0;
	//
	private boolean mDone = false;
	
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
	public boolean isDone() {
		return mDone;
	}
	
	@Override
	public void notifyMe() {
		synchronized (mTimeoutLock) {
			if (! mDone) {
				mDone = true;
				mTimeoutLock.notifyAll();
			}
		}
	}
	
	@Override
	public void callBefore(CallTask aCall) throws Exception {
		Logger.logCommandBegin(aCall.getRequestId(), toString(aCall));
		if (CallKind.NOCAST != aCall.getCallType().getKind()) {
			aCall.getCallType().getContext().addCommand(aCall);
		}
	}
	
	@Override
	public void callAfter(CallTask aCall) throws Exception {
		if (CallKind.NOCAST != aCall.getCallType().getKind()) {
			resetTimeout();
			for (;;) {
				if (reachTimeout()) {
					break;
				}
				synchronized (mTimeoutLock) {
					if (mDone) break;
					mTimeoutLock.wait(mWaitTimeMs);
				}
			}
			aCall.getCallType().getContext().removeCommand(aCall);
		}
		Logger.logCommandEnd(aCall.getRequestId(), toString(aCall));
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
		return String.format
		(	"%s.%s"
		,	aCall.getCallType().getKind().toString()
		,	aCall.toString()
		);
	}
	
	public CommandImpl() {
		int timeoutSec = Config.getCallTimeoutSec();
		mTimeoutMs = TimeUnit.MILLISECONDS.convert(timeoutSec, TimeUnit.SECONDS);
		resetTimeout();
	}
	
}
