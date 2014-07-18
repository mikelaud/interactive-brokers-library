package com.blogspot.mikelaud.ibl.command;

import java.util.concurrent.TimeUnit;

import com.blogspot.mikelaud.ibl.task.call.CallTask;
import com.blogspot.mikelaud.ibl.task.event.EventTask;

public interface Command {

	void callBefore(CallTask aCall) throws Exception;
	void callAfter(CallTask aCall) throws Exception;
	//
	void notifyMe(EventTask aEvent);
	//
	long getTimeout(TimeUnit aTimeoutUnit);
	void setTimeout(long aTimeout, TimeUnit aTimeoutUnit);
	//
	String toString(CallTask aCall);

}
