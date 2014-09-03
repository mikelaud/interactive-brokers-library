package com.blogspot.mikelaud.ibl.types;

import com.blogspot.mikelaud.ibl.types.common.IblEnum;

public enum IblSecurityType implements IblEnum {

	IND("index"),
	STK("stock");
	
	private final int ID;
	private final String NAME;
	private final String DESCRIPTION;
	
	private IblSecurityType(String aDescription) {
		ID = this.ordinal();
		NAME = this.name();
		DESCRIPTION = aDescription;
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
		(	"name=\"%s\" description=\"%s\""
		,	NAME
		,	DESCRIPTION
		);
		return message;
	}
	
}
