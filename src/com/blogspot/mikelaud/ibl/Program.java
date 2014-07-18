package com.blogspot.mikelaud.ibl;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.connection_and_server.CallConnect;

public class Program implements Callable<Object> {

	private ConnectionContext mContext;
	
	@Override
	public Object call() throws Exception {
		//
		CallConnect callConnect = new CallConnect
		(	mContext
		,	Config.getHost()
		,	Config.getPort()
		,	Config.getClientId()
		);
		callConnect.getCommand().setTimeout(2, TimeUnit.SECONDS);
		mContext.onTask(callConnect);
		//
		for (;;) {
			Task task = mContext.nextTask();
			if (null != task) {
				mContext.onTask(task);
			}
		}
		//
		//return null;
	}

	public Program() {
		mContext = new ConnectionContext();
	}
	
}
