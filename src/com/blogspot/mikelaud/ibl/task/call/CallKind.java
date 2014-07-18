package com.blogspot.mikelaud.ibl.task.call;

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
	
	@Override
	public String toString() {
		return NAME;
	}
	
}
