package com.blogspot.mikelaud.ibl.types;

import java.time.Duration;
import java.time.LocalTime;

public class IblTradingHours {

	private final LocalTime OPEN;
	private final LocalTime OPEN_PLUS_2H;
	private final LocalTime CLOSE;
	private final Duration DURATION;
	private final Duration DURATION_TO_OPEN;
	private final Duration DURATION_TO_CLOSE;
	
	private static LocalTime getOpenDefault() { return LocalTime.of(9, 30); }
	private static LocalTime getCloseDefault() { return LocalTime.of(16, 0); }

	public LocalTime getOpen() { return OPEN; }
	public LocalTime getOpenPlus2h() { return OPEN_PLUS_2H; }	
	public LocalTime getClose() { return CLOSE; }
	public Duration getDuration() { return DURATION; }
	public Duration getDurationToOpen() { return DURATION_TO_OPEN; }
	public Duration getDurationToClose() { return DURATION_TO_CLOSE; }
	
	public IblTradingHours toDuration(Duration aDuration) {
		LocalTime openTime = getOpen();
		LocalTime closeTime = openTime.plus(aDuration);
		return new IblTradingHours(openTime, closeTime);
	}

	@Override
	public String toString() {
		return DURATION.toString();
	}	

	public IblTradingHours(LocalTime aOpen, LocalTime aClose) {
		OPEN = aOpen;
		OPEN_PLUS_2H = OPEN.plusHours(2); 
		CLOSE = aClose;
		DURATION = Duration.between(OPEN, CLOSE);
		LocalTime dayBegin = LocalTime.ofSecondOfDay(0);
		DURATION_TO_OPEN = Duration.between(dayBegin, OPEN);
		DURATION_TO_CLOSE = Duration.between(dayBegin, CLOSE);
	}

	public IblTradingHours(Duration aDuration) {
		this(getOpenDefault(), getOpenDefault().plus(aDuration));
	}
	
	public IblTradingHours() {
		this(getOpenDefault(), getCloseDefault());
	}
	
}
