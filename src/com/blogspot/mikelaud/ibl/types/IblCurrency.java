package com.blogspot.mikelaud.ibl.types;

import com.blogspot.mikelaud.ibl.types.common.IblEnum;

public enum IblCurrency implements IblEnum {

	USD;
	
	private final int ID;
	private final String NAME;
	private final String DESCRIPTION;

	private IblCurrency() {
		ID = this.ordinal();
		NAME = this.name();
		DESCRIPTION = NAME; 
	}

	@Override
	public int getId() {
		return ID;
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
	
	@Override
	public String toString() {
		String message = String.format
		(	"name={%s}"
		,	NAME
		);
		return message;
	}
		
}
