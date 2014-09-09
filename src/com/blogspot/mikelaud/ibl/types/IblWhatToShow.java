package com.blogspot.mikelaud.ibl.types;

import com.blogspot.mikelaud.ibl.types.common.IblEnum;

/**
 * Determines the nature of data being extracted
 * (see reqHistoricalData()).
 */
public enum IblWhatToShow implements IblEnum {

	TRADES,
	MIDPOINT,
	BID,
	ASK,
	BID_ASK,
	HISTORICAL_VOLATILITY,
	OPTION_IMPLIED_VOLATILITY;
	
	private final int ID;
	private final String NAME;
	private final String DESCRIPTION;

	private IblWhatToShow() {
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
