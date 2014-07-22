package com.blogspot.mikelaud.ibl.task;

import java.util.concurrent.Callable;

import com.blogspot.mikelaud.ibl.connection.Connection;
import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.ib.client.EClientSocket;

public abstract class Task implements Callable<Task> {

	protected ConnectionContext mContext;
	
	public abstract int getRequestId();
	
	public ConnectionContext getContext() {
		return mContext;
	}
	
	public Connection getConnection() {
		return mContext.getConnection();
	}
	
	public EClientSocket getClientSocket() {
		return mContext.getConnection().getClientSocket();
	}
	
	public Task(ConnectionContext aContext) {
		mContext = aContext;
	}

}
