package com.blogspot.mikelaud.ibl.router;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.blogspot.mikelaud.ibl.out.Out;
import com.blogspot.mikelaud.ibl.out.OutType;
import com.blogspot.mikelaud.ibl.task.event.EventTask;
import com.blogspot.mikelaud.ibl.task.event.EventType;

public class RouterImpl implements Router {

	private final Map<EventType,Out> OUT_MAP;
	private final List<Out> TERMINATORS; 
	
	@Override
	public boolean hasOut() {
		return (0 != OUT_MAP.size());
	}
	
	@Override
	public boolean hasNoOut() {
		return ! hasOut();
	}
	
	@Override
	public void addOut(Out aOut) {
		EventType key = aOut.getEventType();
		OUT_MAP.put(key, aOut);
		if (OutType.TERMINATOR == aOut.getOutType()) {
			TERMINATORS.add(aOut);
		}
	}

	@Override
	public boolean notifyMe(EventTask aEvent) {
		EventType eventType = aEvent.getEventType();
		Out out = OUT_MAP.get(eventType);
		boolean done = (null != out);
		if (done) {
			out.notifyMe(aEvent);
		}
		else {
			aEvent.logLost();
		}
		return done;
	}
	
	@Override
	public boolean isDone() {
		boolean done = true;
		for (Out terminator: TERMINATORS) {
			if (! terminator.isDone()) {
				done = false;
				break;
			}
		}
		return done;
	}

	public RouterImpl() {
		OUT_MAP = new HashMap<>();
		TERMINATORS = new ArrayList<>(); 
	}
	
}
