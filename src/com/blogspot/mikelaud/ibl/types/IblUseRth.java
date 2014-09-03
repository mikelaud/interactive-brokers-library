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
	 * All data is returned even where the market
	 * in question was outside of its regular trading hours.
	 */
	ALL_DATA(0),
	/**
	 * Only data within the regular trading hours is returned,
	 * even if the requested time span falls partially or completely outside of the RTH.
	 */
	RTH_DATA(1);

	private final int ID;
	private final String NAME;
	private final String DESCRIPTION;
	private final int VALUE;
	
	private IblUseRth(int aValue) {
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
