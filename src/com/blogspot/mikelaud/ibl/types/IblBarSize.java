package com.blogspot.mikelaud.ibl.types;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import com.blogspot.mikelaud.ibl.types.common.IblEnum;

public enum IblBarSize implements IblEnum {

	BAR_1_SEC("1 secs", 1, ChronoUnit.SECONDS),
	BAR_5_SEC("5 secs", 5, ChronoUnit.SECONDS),
	BAR_15_SEC("15 secs", 15, ChronoUnit.SECONDS),
	BAR_30_SEC("30 secs", 30, ChronoUnit.SECONDS),
	BAR_1_MIN("1 min", 1, ChronoUnit.MINUTES),
	BAR_2_MIN("2 mins", 2, ChronoUnit.MINUTES),
	BAR_3_MIN("3 mins", 3, ChronoUnit.MINUTES),
	BAR_5_MIN("5 mins", 5, ChronoUnit.MINUTES),
	BAR_10_MIN("10 mins", 10, ChronoUnit.MINUTES),
	BAR_15_MIN("15 mins", 15, ChronoUnit.MINUTES),
	BAR_20_MIN("20 mins", 20, ChronoUnit.MINUTES),
	BAR_30_MIN("30 mins", 30, ChronoUnit.MINUTES),
	BAR_1_HOUR("1 hour", 1, ChronoUnit.HOURS),
	BAR_2_HOUR("2 hour", 2, ChronoUnit.HOURS),
	BAR_3_HOUR("3 hour", 3, ChronoUnit.HOURS),
	BAR_4_HOUR("4 hour", 4, ChronoUnit.HOURS),
	BAR_5_HOUR("8 hour", 8, ChronoUnit.HOURS),
	BAR_1_DAY("1 day", 1, ChronoUnit.DAYS),
	BAR_1_WEEK("1W", 1, ChronoUnit.WEEKS),
	BAR_1_MONTH("1M", 1, ChronoUnit.MONTHS);
	
	private final int ID;
	private final String NAME;
	private final String DESCRIPTION;
	private final int CHRONO_VALUE;
	private final ChronoUnit CHRONO_UNIT;
	private final Duration DURATION;
		
	private IblBarSize(String aName, int aChronoValue, ChronoUnit aChronoUnit) {
		ID = this.ordinal();
		NAME = aName;
		DESCRIPTION = this.name();
		CHRONO_VALUE = aChronoValue;
		CHRONO_UNIT = aChronoUnit;
		DURATION = CHRONO_UNIT.getDuration().multipliedBy(CHRONO_VALUE);
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

	public int getChronoValue() {
		return CHRONO_VALUE;
	}

	public ChronoUnit getChronoUnit() {
		return CHRONO_UNIT;
	}

	public Duration getDuration() {
		return DURATION;
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
