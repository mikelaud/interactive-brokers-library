package com.blogspot.mikelaud.ibl.types.common;

import java.awt.Color;

public interface IblUniverse extends IblEnumInstance<IblUniverseInstance> {

	default Class<? extends Enum<? extends IblSymbol>> getUniverseClass() {
		return getInstance().getUniverseClass();
	}
	
	default Color getColor() {
		return getInstance().getColor();
	}

	default IblSymbol[] getSymbols() {
		return getInstance().getSymbols();
	}
	
}
