package com.blogspot.mikelaud.ibl.router.context;

import java.util.HashSet;
import java.util.Set;

import com.blogspot.mikelaud.ibl.task.call.CallTask;
import com.blogspot.mikelaud.ibl.task.event.EventTask;

public class ContextMulticast extends ContextAbstract {

	private Set<CallTask> mCalls = new HashSet<CallTask>();
	
	@Override
	public void addEvent(EventTask aEvent) {
		Set<CallTask> callsCopy = null;
		synchronized (mLock) {
			int callsCount = mCalls.size();
			if (callsCount > 0) {
				callsCopy = new HashSet<CallTask>(callsCount);
				callsCopy.addAll(mCalls);
				mCalls.clear();
			}
		}
		if (null != callsCopy) {
			for (CallTask call : callsCopy) {
				call.getCommand().notifyMe(aEvent);
			}
			callsCopy.clear();
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
