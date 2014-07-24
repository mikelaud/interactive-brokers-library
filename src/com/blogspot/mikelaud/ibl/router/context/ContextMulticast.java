package com.blogspot.mikelaud.ibl.router.context;

import java.util.HashSet;
import java.util.Set;

import com.blogspot.mikelaud.ibl.task.call.CallTask;
import com.blogspot.mikelaud.ibl.task.event.EventTask;

public class ContextMulticast extends ContextAbstract {

	private Set<CallTask> mCalls = new HashSet<CallTask>();
	
	@Override
	public void addEvent(EventTask aEvent) {
		CallTask[] callsCopy = null;
		synchronized (mLock) {
			int callsCount = mCalls.size();
			if (callsCount > 0) {
				callsCopy = new CallTask[callsCount];
				callsCopy = mCalls.toArray(callsCopy);
			}
		}
		if (null != callsCopy) {
			for (CallTask call : callsCopy) {
				call.notifyMe(aEvent);
			}
		}
	}
	
	@Override
	public void addCommand(CallTask aCall) {
		synchronized (mLock) {
			mCalls.add(aCall);
		}
	}
	
	@Override
	public void removeCommand(CallTask aCall) {
		synchronized (mLock) {
			mCalls.remove(aCall);
		}
	}
	
}
