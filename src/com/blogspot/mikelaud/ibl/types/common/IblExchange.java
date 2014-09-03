package com.blogspot.mikelaud.ibl.types.common;

import java.time.LocalDate;

import com.blogspot.mikelaud.ibl.types.IblEndDateTime;
import com.blogspot.mikelaud.ibl.types.IblTimeZone;
import com.blogspot.mikelaud.ibl.types.IblTradingHours;

public interface IblExchange extends IblEnumInstance<IblExchangeInstance> {

	default IblTimeZone getTimeZone() {
		return getInstance().getTimeZone();
	}
	
	default IblTradingHours getTradingHours() {
		return getInstance().getTradingHours();
	}
	
	default IblEndDateTime getEndDateTime2h(LocalDate aLocalDate) {
		return getInstance().getEndDateTime2h(aLocalDate);
	}
	
	default IblEndDateTime getEndDateTime2h(int aYear, int aMonth, int aDayOfMonth) {
		return getInstance().getEndDateTime2h(aYear, aMonth, aDayOfMonth);
	}	

}
