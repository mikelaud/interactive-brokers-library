package com.blogspot.mikelaud.ibl.types.common;

import java.time.LocalDate;

import com.blogspot.mikelaud.ibl.types.IblCurrency;
import com.blogspot.mikelaud.ibl.types.IblEndDateTime;
import com.blogspot.mikelaud.ibl.types.IblSecurityType;

public interface IblSymbol extends IblEnumInstance<IblSymbolInstance> {

	default IblSecurityType getSecurityType() {
		return getInstance().getSecurityType();
	}
		
	default IblExchange getExchange() {
		return getInstance().getExchange();
	}
	
	default IblExchange getPrimaryExchange() {
		return getInstance().getPrimaryExchange();
	}

	default IblCurrency getCurrency() {
		return getInstance().getCurrency();
	}
	
	default IblUniverse getUniverse() {
		return getInstance().getUniverse();
	}
	
	default IblEndDateTime getEndDateTimeNow() {
		return getInstance().getEndDateTimeNow();
	}

	default IblEndDateTime getEndDateTime(LocalDate aLocalDate) {
		return getInstance().getEndDateTime(aLocalDate);
	}
	
	default IblEndDateTime getEndDateTime(int aYear, int aMonth, int aDayOfMonth) {
		return getInstance().getEndDateTime(aYear, aMonth, aDayOfMonth);
	}
	
	default IblEndDateTime getEndDateTime2h(LocalDate aLocalDate) {
		return getInstance().getEndDateTime2h(aLocalDate);
	}
	
	default IblEndDateTime getEndDateTime2h(int aYear, int aMonth, int aDayOfMonth) {
		return getInstance().getEndDateTime2h(aYear, aMonth, aDayOfMonth);
	}
	
}
