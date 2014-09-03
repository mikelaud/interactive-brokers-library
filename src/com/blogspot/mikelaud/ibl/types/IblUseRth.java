package com.blogspot.mikelaud.ibl.types;

import com.blogspot.mikelaud.ibl.types.common.IblEnum;

/**
 * Determines whether to return all data
 * available during the requested time span,
 * or only data that falls within regular trading hours
 * (see reqHistoricalData()).
 */
public enum IblUseRth implements IblEnum {
	
	/**
	 * Integer(0):
	 *         All data is returned even where the market
	 *         in question was outside of its regular trading hours.
	 * 
	 * Boolean:
	 *     0 = all data available during the time span requested is
	 *         returned, including time intervals when the market in
	 *         question was outside of regular trading hours.
	 */
	ALL_DATA(0, false),
	/**
	 * Integer(1):
	 *         Only data within the regular trading hours is returned,
	 *         even if the requested time span falls partially or completely outside of the RTH.
	 * 
	 * Boolean:
	 *     1 = only data within the regular trading hours for the product
	 *         requested is returned, even if the time time span falls
	 *         partially or completely outside.
	 */
	RTH_DATA(1, true);

	private final int ID;
	private final String NAME;
	private final String DESCRIPTION;
	private final int INTEGER_VALUE;
	private final boolean BOOLEAN_VALUE;
	
	private IblUseRth(int aIntegerValue, boolean aBooleanValue) {
		ID = this.ordinal();
		NAME = this.name();
		DESCRIPTION = NAME;
		INTEGER_VALUE = aIntegerValue;
		BOOLEAN_VALUE = aBooleanValue;
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

	public int getIntegerValue() {
		return INTEGER_VALUE;
	}

	public boolean getBooleanValue() {
		return BOOLEAN_VALUE;
	}

	@Override
	public String toString() {
		String message = String.format
		(	"name=\"%s\" integerValue=\"%d\""
		,	NAME
		,	INTEGER_VALUE
		);
		return message;
	}
	
}
