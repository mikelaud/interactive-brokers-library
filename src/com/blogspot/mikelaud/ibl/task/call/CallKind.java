package com.blogspot.mikelaud.ibl.task.call;

import com.blogspot.mikelaud.ibl.router.context.Context;
import com.blogspot.mikelaud.ibl.router.context.ContextMulticast;
import com.blogspot.mikelaud.ibl.router.context.ContextNocast;
import com.blogspot.mikelaud.ibl.router.context.ContextUnicast;
import com.blogspot.mikelaud.ibl.types.IblString;

public enum CallKind {

	NOCAST
	(	ContextNocast.class
	),
	UNICAST
	(	ContextUnicast.class
	),
	MULTICAST
	(	ContextMulticast.class
	);
	
	private final String NAME;
	private final String DESCRIPTION;
	private final Class<? extends Context> CONTEXT_CLASS;
	
	private CallKind(Class<? extends Context> aContextClass) {
		NAME = name();
		DESCRIPTION = NAME;
		CONTEXT_CLASS = aContextClass;
	}
	
	public String getName() {
		return NAME;
	}
	
	public String getDescription() {
		return DESCRIPTION;
	}
	
	public Class<?> getContextClass() {
		return CONTEXT_CLASS;
	}
	
	public Context createContext() {
		Context context = null;
		try {
			context = CONTEXT_CLASS.newInstance();
		}
		catch (Exception e) {
			String errorMessage = String.format
			(	"Unable to create context for %s: %s."
			,	getName()
			,	IblString.nvl(e.getMessage())
			);
			throw new Error(errorMessage);
		}
		return context;
	}
	
	@Override
	public String toString() {
		return NAME;
	}
	
}
