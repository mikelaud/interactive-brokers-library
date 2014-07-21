package com.blogspot.mikelaud.ibl.router;

import com.blogspot.mikelaud.ibl.out.Out;
import com.blogspot.mikelaud.ibl.task.event.EventTask;

public interface Router {

	void addOut(Out aOut);
	void notifyMe(EventTask aEvent);
	boolean isDone();
	
}
