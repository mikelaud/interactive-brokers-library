package com.blogspot.mikelaud.ibl.router;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.blogspot.mikelaud.ibl.Logger;
import com.blogspot.mikelaud.ibl.out.Out;
import com.blogspot.mikelaud.ibl.out.OutType;
import com.blogspot.mikelaud.ibl.task.event.EventTask;
import com.blogspot.mikelaud.ibl.task.event.EventType;

public class RouterImpl implements Router {

	private Map<EventType,Out> mOutMap = new HashMap<>();
	private List<Out> mTerminators = new ArrayList<>(); 
	
	@Override
	public void addOut(Out aOut) {
		EventType key = aOut.getEventType();
		mOutMap.put(key, aOut);
		if (OutType.TERMINATOR == aOut.getOutType()) {
			mTerminators.add(aOut);
		}
	}

	@Override
	public void notifyMe(EventTask aEvent) {
		EventType eventType = aEvent.getEventType();
		Out out = mOutMap.get(eventType);
		if (null == out) {
			Logger.logLost(aEvent.toString());
		}
		else {
			out.notifyMe(aEvent);
		}
	}
	
	@Override
	public boolean isDone() {
		boolean done = true;
		for (Out terminator: mTerminators) {
			if (terminator.isDone()) {
				continue;
			}
			else {
				done = false;
				break;
			}
		}
		return done;
	}

}
