package com.blogspot.mikelaud.ibl.types;

import java.time.temporal.ChronoUnit;

public enum IblBarSize implements IblEnum {

	BAR_1_SEC("1 sec", 1, ChronoUnit.SECONDS),
	BAR_5_SEC("5 secs", 5, ChronoUnit.SECONDS),
	BAR_15_SEC("15 secs", 15, ChronoUnit.SECONDS),
	BAR_30_SEC("30 secs", 30, ChronoUnit.SECONDS),
	BAR_1_MIN("1 min", 1, ChronoUnit.MINUTES),
	BAR_2_MIN("2 mins", 2, ChronoUnit.MINUTES),
	BAR_3_MIN("3 mins", 3, ChronoUnit.MINUTES),
	BAR_5_MIN("5 mins", 5, ChronoUnit.MINUTES),
	BAR_15_MIN("15 mins", 15, ChronoUnit.MINUTES),
	BAR_30_MIN("30 mins", 30, ChronoUnit.MINUTES),
	BAR_1_HOUR("1 hour", 1, ChronoUnit.HOURS),
	BAR_1_DAY("1 day", 1, ChronoUnit.DAYS);
	
	private final int ID;
	private final String VALUE;
	private final String DESCRIPTION;
	private final int CHRONO_VALUE;
	private final ChronoUnit CHRONO_UNIT;
		
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

	public int getChronoValue() {
		return CHRONO_VALUE;
	}

	public ChronoUnit getChronoUnit() {
		return CHRONO_UNIT;
	}

	@Override
	public String toString() {
		String message = String.format
		(	"value=\"%s\""
		,	VALUE
		);
		return message;
	}
	
	private IblBarSize(String aValue, int aChronoValue, ChronoUnit aChronoUnit) {
		ID = this.ordinal();
		VALUE = aValue;
		DESCRIPTION = this.name();
		CHRONO_VALUE = aChronoValue;
		CHRONO_UNIT = aChronoUnit;
	}

}
