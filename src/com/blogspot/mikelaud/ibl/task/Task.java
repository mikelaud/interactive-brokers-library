package com.blogspot.mikelaud.ibl.task;

import java.util.concurrent.Callable;

import com.blogspot.mikelaud.ibl.Logger;
import com.blogspot.mikelaud.ibl.connection.Connection;
import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.util.IblString;
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
	
	public Task tryCall() {
		Task task = null;
		try {
			call();
		}
		catch (Exception e) {
			Logger.logError(IblString.nvl(e.getMessage()));
		}
		return task;
	}
	
	public Task(ConnectionContext aContext) {
		mContext = aContext;
	}

}
