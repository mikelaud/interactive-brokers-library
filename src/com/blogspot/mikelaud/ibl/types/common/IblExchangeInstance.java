package com.blogspot.mikelaud.ibl.types.common;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.blogspot.mikelaud.ibl.types.IblEndDateTime;
import com.blogspot.mikelaud.ibl.types.IblTimeZone;
import com.blogspot.mikelaud.ibl.types.IblTradingHours;

public class IblExchangeInstance extends IblEnumCommon<IblExchangeInstance> implements IblExchange {

	private final IblTimeZone TIME_ZONE;
	private final IblTradingHours TRADING_HOURS;
	private final LocalTime END_TIME_2H;

	@Override
	public IblExchangeInstance getInstance() {
		return this;
	}
	
	@Override
	public IblTimeZone getTimeZone() {
		return TIME_ZONE;
	}
	
	@Override
	public IblTradingHours getTradingHours() {
		return TRADING_HOURS;
	}

	@Override
	public IblEndDateTime getEndDateTime(Duration aDuration, LocalDate aLocalDate) {
		LocalDateTime localDateTime;
		int compareDuration = aDuration.compareTo(TRADING_HOURS.getDuration());
		if (compareDuration < 0) {
			LocalTime endTime = TRADING_HOURS.getOpen().plus(aDuration);
			localDateTime = LocalDateTime.of(aLocalDate, endTime);
		}
		else {
			LocalDate endDate = aLocalDate.plusDays(1);
			LocalTime endTime = LocalTime.of(0, 0);
			localDateTime = LocalDateTime.of(endDate, endTime);
		}
		IblEndDateTime endDateTime = new IblEndDateTime(localDateTime, TIME_ZONE.getZoneId());
		return endDateTime;
	}

	@Override
	public IblEndDateTime getEndDateTime(Duration aDuration, int aYear, int aMonth, int aDayOfMonth) {
		LocalDate localDate = LocalDate.of(aYear, aMonth, aDayOfMonth);
		IblEndDateTime endDateTime = getEndDateTime(aDuration, localDate);
		return endDateTime;
	}
	
	@Override
	public IblEndDateTime getEndDateTime2h(LocalDate aLocalDate) {
		LocalDateTime localDateTime = LocalDateTime.of(aLocalDate, END_TIME_2H);
		IblEndDateTime endDateTime2h = new IblEndDateTime(localDateTime, TIME_ZONE.getZoneId());
		return endDateTime2h;
	}

	@Override
	public IblEndDateTime getEndDateTime2h(int aYear, int aMonth, int aDayOfMonth) {
		LocalDate localDate = LocalDate.of(aYear, aMonth, aDayOfMonth);
		IblEndDateTime endDateTime2h = getEndDateTime2h(localDate);
		return endDateTime2h;
	}
	
	public IblExchangeInstance
	(	int aId
	,	String aName
	,	String aDescription
	//
	,	IblTimeZone aTimeZone
	,	IblTradingHours aTradingHours
	) {
		super(aId, aName, aDescription);
		TIME_ZONE = aTimeZone;
		TRADING_HOURS = aTradingHours;
		END_TIME_2H = TRADING_HOURS.getOpenPlus2h(); 
	}
	
}
