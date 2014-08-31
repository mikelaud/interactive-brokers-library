package com.blogspot.mikelaud.ibl.types;

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
	private final int VALUE;
	private final String DESCRIPTION;
	
	@Override
	public int getId() {
		return ID;
	}

	public int getValue() {
		return VALUE;
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	public String toString() {
		String message = String.format
		(	"value=\"%d\""
		,	VALUE
		);
		return message;
	}
	
	private IblFormatDate(int aValue) {
		ID = this.ordinal();
		VALUE = aValue;
		DESCRIPTION = this.name();
	}
	
}
