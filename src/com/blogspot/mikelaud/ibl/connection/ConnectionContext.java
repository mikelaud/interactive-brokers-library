package com.blogspot.mikelaud.nyse.connection;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import com.blogspot.mikelaud.nyse.task.Task;

public class ConnectionContext {

	private Connection mConnection;
	private ExecutorService mExecutor;
	private ExecutorCompletionService<Task> mService;
	private AtomicInteger mRequestId;
	
	public Connection getConnection() { return mConnection; }
	
	public int nextRequestId() {
		for (;;) {
			int oldId = mRequestId.get();			
			int newId = (oldId < 0 ? oldId : mRequestId.incrementAndGet());
			if (newId < 0) {
				mRequestId.compareAndSet(newId, 0);
				continue;
			}
			else {
				return newId;
			}
		}
	}
	
	public void onTask(Task aTask) {
		if (null != aTask) {
			mService.submit(aTask);
		}
	}

	public Task nextTask() throws InterruptedException, ExecutionException {
		return mService.take().get();
	}
	
	public ConnectionContext() {
		mConnection = new Connection(this);
		mExecutor = Executors.newCachedThreadPool();
		mService = new ExecutorCompletionService<Task>(mExecutor);
		mRequestId = new AtomicInteger(0);
	}
	
}
