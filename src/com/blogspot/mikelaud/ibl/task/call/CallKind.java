package com.blogspot.mikelaud.ibl.task.call;

import com.blogspot.mikelaud.ibl.router.context.Context;
import com.blogspot.mikelaud.ibl.router.context.ContextMulticast;
import com.blogspot.mikelaud.ibl.router.context.ContextNocast;
import com.blogspot.mikelaud.ibl.router.context.ContextUnicast;

public enum CallKind {

	NOCAST
	(	"NOCAST"
	),
	UNICAST
	(	"UNICAST"
	),
	MULTICAST
	(	"MULTICAST"
	);
	
	private final String NAME;
	
	private CallKind(String aName) {
		NAME = aName;
	}
	
	public String getName() { return NAME; }
	
	public static Context createContext(CallKind aKind) {
		Context context;
		switch (aKind) {
		case NOCAST:
			context = new ContextNocast();
			break;
		case UNICAST:
			context = new ContextUnicast();
			break;
		case MULTICAST:
			context = new ContextMulticast();
			break;
		default:
			context = new ContextNocast();
			break;
		}
		return context;
	}
	
	@Override
	public String toString() {
		return NAME;
	}
	
}
