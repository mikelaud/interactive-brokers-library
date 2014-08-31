package com.blogspot.mikelaud.ibl.types;

public enum IblCurrency implements IblEnum {

	USD;
	
	private final int ID;
	private final String VALUE;
	private final String DESCRIPTION;

	@Override
	public int getId() {
		return ID;
	}

	public String getValue() {
		return VALUE;
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
	
	@Override
	public String toString() {
		String message = String.format
		(	"value=\"%s\""
		,	VALUE
		);
		return message;
	}

	private IblCurrency() {
		ID = this.ordinal();
		VALUE = this.name();
		DESCRIPTION = VALUE; 
	}
		
}
