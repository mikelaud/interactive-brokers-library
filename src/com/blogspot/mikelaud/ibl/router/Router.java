package com.blogspot.mikelaud.ibl.router;

import com.blogspot.mikelaud.ibl.out.Out;
import com.blogspot.mikelaud.ibl.task.event.EventTask;
import com.blogspot.mikelaud.ibl.task.event.connection_and_server.OnError;

public interface Router {

	boolean hasError();
	boolean hasNoError();
	OnError getError();
	//
	boolean hasOut();
	boolean hasNoOut();
	//
	void addOut(Out aOut);	
	boolean notifyMe(EventTask aEvent);
	boolean isDone();
	
}
