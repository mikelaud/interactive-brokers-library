package com.blogspot.mikelaud.ibl.types;

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
	
	private IblWhatToShow() {
		ID = this.ordinal();
		VALUE = this.name();
		DESCRIPTION = VALUE;
	}
	
}
