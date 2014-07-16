package com.blogspot.mikelaud.ibl.task;

import java.util.concurrent.TimeUnit;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.call.other.CallSleep;

public class TestFlow extends Task {

	@Override
	public Task call() throws Exception {
		new CallSleep(mContext, new CallSleep.Info(1, TimeUnit.SECONDS)).call();
		//new TestCommand(mContext, 1000).call();
		//new TestCommand(mContext, 2000).call();
		//new TestCommand(mContext, 1500).call();
		//new TestCommand(mContext, 3000).call();
		return null;
	}

	public TestFlow(ConnectionContext aContext) {
		super(aContext);
	}

}
