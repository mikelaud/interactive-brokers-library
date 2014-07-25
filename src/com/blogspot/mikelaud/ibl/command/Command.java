package com.blogspot.mikelaud.ibl.command;

import java.util.concurrent.TimeUnit;

import com.blogspot.mikelaud.ibl.router.Router;
import com.blogspot.mikelaud.ibl.task.call.CallTask;
import com.blogspot.mikelaud.ibl.task.event.EventTask;

public interface Command {

	Router getRouter();
	void notifyMe(EventTask aEvent);
	//
	void callBefore(CallTask aCall) throws Exception;
	void callAfter(CallTask aCall) throws Exception;
	//
	long getTimeout(TimeUnit aTimeoutUnit);
	void setTimeout(long aTimeout, TimeUnit aTimeoutUnit);
	//
	void incrementEvents();
	void incrementHistoricalEvents();
	//
	long getEventsCount();
	long getHistoricalEventsCount();	
	//
	String toString(CallTask aCall);

}
