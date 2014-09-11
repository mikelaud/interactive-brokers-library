package com.blogspot.mikelaud.ibl.types;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import com.blogspot.mikelaud.ibl.types.common.IblEnum;

public enum IblBarSize implements IblEnum {

	BAR_1_SEC("1 secs", 1, ChronoUnit.SECONDS, IblDuration.DURATION_30_MINUTE),
	BAR_5_SEC("5 secs", 5, ChronoUnit.SECONDS, IblDuration.DURATION_2_HOUR),
	BAR_10_SEC("10 secs", 10, ChronoUnit.SECONDS, IblDuration.DURATION_4_HOUR),
	BAR_15_SEC("15 secs", 15, ChronoUnit.SECONDS, IblDuration.DURATION_4_HOUR),
	BAR_30_SEC("30 secs", 30, ChronoUnit.SECONDS, IblDuration.DURATION_1_DAY), // JPM since 2004-01-23
	BAR_1_MIN("1 min", 1, ChronoUnit.MINUTES, IblDuration.DURATION_1_WEEK), // JPM since 2004-01-23
	BAR_2_MIN("2 mins", 2, ChronoUnit.MINUTES, IblDuration.DURATION_1_WEEK),
	BAR_3_MIN("3 mins", 3, ChronoUnit.MINUTES, IblDuration.DURATION_1_WEEK),
	BAR_5_MIN("5 mins", 5, ChronoUnit.MINUTES, IblDuration.DURATION_1_WEEK),
	BAR_10_MIN("10 mins", 10, ChronoUnit.MINUTES, IblDuration.DURATION_1_WEEK),
	BAR_15_MIN("15 mins", 15, ChronoUnit.MINUTES, IblDuration.DURATION_2_WEEK),
	BAR_20_MIN("20 mins", 20, ChronoUnit.MINUTES, IblDuration.DURATION_2_WEEK),
	BAR_30_MIN("30 mins", 30, ChronoUnit.MINUTES, IblDuration.DURATION_1_MONTH), // JPM since 2004-01-23
	BAR_1_HOUR("1 hour", 1, ChronoUnit.HOURS, IblDuration.DURATION_1_MONTH), // JPM since 2004-01-23
	BAR_2_HOUR("2 hours", 2, ChronoUnit.HOURS, IblDuration.DURATION_1_MONTH),
	BAR_3_HOUR("3 hours", 3, ChronoUnit.HOURS, IblDuration.DURATION_1_MONTH),
	BAR_4_HOUR("4 hours", 4, ChronoUnit.HOURS, IblDuration.DURATION_1_MONTH), // JPM since 2004-01-23
	BAR_1_DAY("1 day", 1, ChronoUnit.DAYS, IblDuration.DURATION_5_YEAR), // JPM since 1980-03-17
	BAR_1_WEEK("1W", 1, ChronoUnit.WEEKS, IblDuration.DURATION_5_YEAR), // JPM since 1980-03-21
	BAR_1_MONTH("1M", 1, ChronoUnit.MONTHS, IblDuration.DURATION_5_YEAR); // JPM since 1980-03-31
	
	private final int ID;
	private final String NAME;
	private final String DESCRIPTION;
	private final int DURATION_VALUE;
	private final ChronoUnit DURATION_UNIT;
	private final Duration DURATION;
	private final IblDuration HISTORICAL_LIMIT;
		
	private IblBarSize
	(	String aName
	,	int aDurationValue
	,	ChronoUnit aDurationUnit
	,	IblDuration aHistoricalLimit
	) {
		ID = this.ordinal();
		NAME = aName;
		DESCRIPTION = this.name();
		DURATION_VALUE = aDurationValue;
		DURATION_UNIT = aDurationUnit;
		DURATION = DURATION_UNIT.getDuration().multipliedBy(DURATION_VALUE);
		HISTORICAL_LIMIT = aHistoricalLimit;
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
		return DURATION_VALUE;
	}
	
	public ChronoUnit getChronoUnit() {
		return DURATION_UNIT;
	}
	
	public Duration getDuration() {
		return DURATION;
	}

	public IblDuration getHistoricalLimit() {
		return HISTORICAL_LIMIT;
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
