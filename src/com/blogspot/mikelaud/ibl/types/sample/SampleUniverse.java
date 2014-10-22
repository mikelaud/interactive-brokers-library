package com.blogspot.mikelaud.ibl.types.sample;

import java.awt.Color;

import com.blogspot.mikelaud.ibl.types.common.IblSymbol;
import com.blogspot.mikelaud.ibl.types.common.IblUniverse;
import com.blogspot.mikelaud.ibl.types.common.IblUniverseInstance;

public enum SampleUniverse implements IblUniverse {

	MISC(SampleSymbol.class, "MISC", new Color(0, 0, 0));
	
	private final IblUniverseInstance INSTANCE;
	
	private SampleUniverse
	(	Class<? extends Enum<? extends IblSymbol>> aUniverseClass
	,	String aDescription
	,	Color aColor
	) {
		INSTANCE = new IblUniverseInstance
		(	aUniverseClass
		,	this.ordinal()
		,	this.name()
		,	aDescription
		,	aColor
		);
	}
		
	@Override
	public IblUniverseInstance getInstance() {
		return INSTANCE;
	}

	@Override
	public String toString() {
		return INSTANCE.toString();
	}

}
