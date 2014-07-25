package com.blogspot.mikelaud.ibl.connection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import com.blogspot.mikelaud.ibl.Config;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.CallKind;
import com.blogspot.mikelaud.ibl.task.call.CallTask;
import com.blogspot.mikelaud.ibl.task.event.EventTask;

public class ConnectionContext {

	private final ConcurrentMap<Integer,CallTask> UNICAST_CALLS;
	private final Connection CONNECTION;
	private final ExecutorService EXECUTOR;
	private final ExecutorCompletionService<Task> SERVICE;
	private final AtomicInteger REQUEST_ID;
	
	private Integer getUnicastId(CallTask aCallTask) {
		Integer key = null;
		if (null != aCallTask) {
			if (CallKind.UNICAST == aCallTask.getCallKind()) {
				key = aCallTask.getRequestId();
				if (null != key) {
					if (key > Config.getNoRequestId()) {
						// found
					}
					else {
						key = null;
					}
				}
			}
		}
		return key;
	}
	
	public void addUnicastCall(CallTask aCallTask) {
		Integer key = getUnicastId(aCallTask);
		if (null != key) {
			UNICAST_CALLS.put(key, aCallTask);
		}
	}
	
	public void removeUnicastCall(CallTask aCallTask) {
		Integer key = getUnicastId(aCallTask);
		if (null != key) {
			UNICAST_CALLS.remove(key);
		}
	}

	public CallTask getUnicastCall(int aRequestId) {
		return UNICAST_CALLS.get(aRequestId);
	}
	
	public Connection getConnection() {
		return CONNECTION;
	}
	
	public int nextRequestId() {
		for (;;) {
			int oldId = REQUEST_ID.get();			
			int newId = (oldId < 0 ? oldId : REQUEST_ID.incrementAndGet());
			if (newId < 0) {
				REQUEST_ID.compareAndSet(newId, 0);
				continue;
			}
			else {
				return newId;
			}
		}
	}
	
	public void onTask(Task aTask) {
		if (null != aTask) {
			SERVICE.submit(aTask);
		}
	}

	public void onEventTask(EventTask aEventTask) {
		if (null != aEventTask) {
			onTask(aEventTask.tryCall());
		}
	}

	public Task nextTask() throws InterruptedException, ExecutionException {
		return SERVICE.take().get();
	}
	
	public ConnectionContext() {
		UNICAST_CALLS = new ConcurrentHashMap<>();
		CONNECTION = new Connection(this);
		EXECUTOR = Executors.newCachedThreadPool();
		SERVICE = new ExecutorCompletionService<Task>(EXECUTOR);
		REQUEST_ID = new AtomicInteger(0);
	}
	
}
