package com.blogspot.mikelaud.ibl.command;

import java.util.concurrent.TimeUnit;

import com.blogspot.mikelaud.ibl.task.call.CallTask;

public interface Command {

	boolean isDone();
	void notifyMe();
	//
	void callBefore(CallTask aCall) throws Exception;
	void callAfter(CallTask aCall) throws Exception;
	//
	long getTimeout(TimeUnit aTimeoutUnit);
	void setTimeout(long aTimeout, TimeUnit aTimeoutUnit);
	//
	String toString(CallTask aCall);

}
