package com.blogspot.mikelaud.ibl.types;

import java.time.temporal.ChronoUnit;

/**
Minimum Bar Size Settings for Historical Data Requests:
Duration        Minimum Bar Size
--------        ----------------
 1 min	         1 second
 5 mins	         1 second
15 mins	         1 second
 1 hour	         5 seconds
 2 hours	     5 seconds
 4 hours	    10 seconds
 1 day	        30 seconds
 2 days	         1 minute
 1 week	        10 minutes
 2 weeks	    15 minutes
 1 month	    30 minutes
 3 months	     1 day
Everything else	 1 day
 */
public enum IblDuration implements IblEnum {
                                    						// Valid Duration and Bar Size Settings for Historical Data Requests:
	DURATION_1_YEAR("1 Y", 1, ChronoUnit.YEARS),			// Bar Size: 1 day
	DURATION_6_MONTHS("6 M", 6, ChronoUnit.MONTHS),			// Bar Size: 1 day
	DURATION_3_MONTHS("3 M", 3, ChronoUnit.MONTHS),			// Bar Size: 1 day
	DURATION_1_MONTH("1 M", 1, ChronoUnit.MONTHS),			// Bar Size: 1 day, 1 hour
	DURATION_1_WEEK("1 W", 1, ChronoUnit.WEEKS),			// Bar Size: 1 day, 1 hour, 30 mins, 15 mins
	DURATION_2_DAYS("2 D", 2, ChronoUnit.DAYS),				// Bar Size: 1 hour, 30 mins, 15 mins, 3 mins, 2 mins, 1 min
	DURATION_1_DAY("1 D", 1, ChronoUnit.DAYS),				// Bar Size: 1 hour, 30 mins, 15 mins, 5 mins, 3 mins, 2 mins, 1 min, 30 secs
	DURATION_4_HOURS("14400 S", 4, ChronoUnit.HOURS),		// Bar Size: 1 hour, 30 mins, 15 mins, 5 mins, 3 mins, 2 mins, 1 min, 30 secs, 15 secs
	DURATION_2_HOURS("7200 S", 2, ChronoUnit.HOURS),		// Bar Size: 1 hour, 30 mins, 15 mins, 5mins, 3 mins, 2 mins, 1 min, 30 secs, 15 secs, 5 secs
	DURATION_1_HOUR("3600 S", 1, ChronoUnit.HOURS),			// Bar Size: 15 mins, 5 mins, 3 mins,  2 mins, 1 min, 30 secs, 15 secs, 5 secs
	DURATION_30_MINUTES("1800 S", 30, ChronoUnit.MINUTES),	// Bar Size: 15 mins, 5 mins, 3 mins, 2 mins, 1 min, 30 secs, 15 secs, 5 secs, 1 secs
	DURATION_15_MINUTES("960 S", 15, ChronoUnit.MINUTES),	// Bar Size: 5 mins, 3 mins, 2 mins, 1 min, 30 secs, 15 secs, 5 secs, 1 secs
	DURATION_5_MINUTES("300 S", 5, ChronoUnit.MINUTES),		// Bar Size: 3 mins, 2 mins, 1 min, 30 secs, 15 secs, 5 secs, 1 secs
	DURATION_1_MINUTE("60 S", 1, ChronoUnit.MINUTES);		// Bar Size: 30 secs, 15 secs, 5 secs, 1 secs
	
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
	
	private IblDuration(String aValue, int aChronoValue, ChronoUnit aChronoUnit) {
		ID = this.ordinal();
		VALUE = aValue;
		DESCRIPTION = this.name(); 
		CHRONO_VALUE = aChronoValue;
		CHRONO_UNIT = aChronoUnit;
	}
	
}
