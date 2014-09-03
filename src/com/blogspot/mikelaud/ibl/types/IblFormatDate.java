package com.blogspot.mikelaud.ibl.types;

import com.blogspot.mikelaud.ibl.types.common.IblEnum;

/**
 * Determines the date format applied to returned bars
 * (see reqHistoricalData()).
 */
public enum IblFormatDate implements IblEnum {
	
	/**
	 * Dates applying to bars returned in the format:
	 * yyyymmdd{space}{space}hh:mm:dd
	 */
	FORMATTED_TIME(1),
	/**
	 * Dates are returned as a long integer specifying the
	 * number of seconds since 1/1/1970 GMT.
	 */
	UNIX_TIME_SEC(2);

	private final int ID;
	private final String NAME;
	private final String DESCRIPTION;
	private final int VALUE;

	private IblFormatDate(int aValue) {
		ID = this.ordinal();
		NAME = this.name();
		DESCRIPTION = NAME;
		VALUE = aValue;
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

	public int getValue() {
		return VALUE;
	}

	@Override
	public String toString() {
		String message = String.format
		(	"name=\"%s\" value=\"%d\""
		,	NAME
		,	VALUE
		);
		return message;
	}
	
}
