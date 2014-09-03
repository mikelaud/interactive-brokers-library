package com.blogspot.mikelaud.ibl.types.common;

import java.awt.Color;

public class IblUniverseInstance extends IblEnumCommon<IblUniverseInstance> implements IblUniverse {

	private final Class<? extends Enum<? extends IblSymbol>> UNIVERSE_CLASS;
	private final Color COLOR;
	
	@Override
	public IblUniverseInstance getInstance() {
		return this;
	}

	@Override  
	public Class<? extends Enum<? extends IblSymbol>> getUniverseClass() {
		return UNIVERSE_CLASS;
	}
	
	@Override
	public Color getColor() {
		return COLOR;
	}

	public IblUniverseInstance
	(	Class<? extends Enum<? extends IblSymbol>> aUniverseClass
	,	int aId
	,	String aName
	,	String aDescription
	,	Color aColor
	) {
		super(aId, aName, aDescription);
		UNIVERSE_CLASS = aUniverseClass;
		COLOR = aColor;
	}

}
