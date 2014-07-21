package com.blogspot.mikelaud.ibl.router.context;

import java.util.HashMap;
import java.util.Map;

import com.blogspot.mikelaud.ibl.task.call.CallTask;
import com.blogspot.mikelaud.ibl.task.event.EventTask;

public class ContextUnicast extends ContextAbstract {

	private Map<Long,CallTask> mCalls = new HashMap<Long,CallTask>();
	
	@Override
	public void addEvent(EventTask aEvent) {
		long requestId = aEvent.getRequestId();
		CallTask call;
		synchronized (mLock) {
			call = mCalls.get(requestId);
		}
		if (null != call) {
			call.notifyMe(aEvent);	
		}
	}
	
	@Override
	public void addCommand(CallTask aCall) {
		long requestId = aCall.getRequestId();
		synchronized (mLock) {
			mCalls.put(requestId, aCall);
		}
	}
	
	@Override
	public void removeCommand(CallTask aCall) {
		long requestId = aCall.getRequestId();
		synchronized (mLock) {
			mCalls.remove(requestId);
		}
	}
	
}
