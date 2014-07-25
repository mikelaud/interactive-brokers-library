package com.blogspot.mikelaud.ibl.task;

import java.util.concurrent.Callable;

import com.blogspot.mikelaud.ibl.Logger;
import com.blogspot.mikelaud.ibl.connection.Connection;
import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.util.IblString;
import com.ib.client.EClientSocket;

public abstract class Task implements Callable<Task> {

	protected final ConnectionContext CONTEXT;
	
	public abstract int getRequestId();
		
	public ConnectionContext getContext() {
		return CONTEXT;
	}
	
	public Connection getConnection() {
		return CONTEXT.getConnection();
	}
	
	public EClientSocket getClientSocket() {
		return CONTEXT.getConnection().getClientSocket();
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
		CONTEXT = aContext;
	}

}
