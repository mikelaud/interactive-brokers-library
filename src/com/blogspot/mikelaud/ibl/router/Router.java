package com.blogspot.mikelaud.ibl.router;

import com.blogspot.mikelaud.ibl.out.Out;
import com.blogspot.mikelaud.ibl.task.event.EventTask;

public interface Router {

	boolean hasOut();
	boolean hasNoOut();
	//
	void addOut(Out aOut);	
	boolean notifyMe(EventTask aEvent);
	boolean isDone();
	
}
