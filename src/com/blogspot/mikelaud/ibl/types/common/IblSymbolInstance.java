package com.blogspot.mikelaud.ibl.types.common;

import java.time.LocalDate;
import java.util.Objects;

import com.blogspot.mikelaud.ibl.types.IblCurrency;
import com.blogspot.mikelaud.ibl.types.IblEndDateTime;
import com.blogspot.mikelaud.ibl.types.IblSecurityType;
import com.blogspot.mikelaud.ibl.types.IblString;
import com.blogspot.mikelaud.ibl.types.IblTimeZone;

public class IblSymbolInstance extends IblEnumCommon<IblSymbolInstance> implements IblSymbol {

	private final IblSecurityType SECURITY_TYPE;
	private final IblExchange EXCHANGE;
	private final IblExchange PRIMARY_EXCHANGE;
	private final IblCurrency CURRENCY;
	private final IblUniverse UNIVERSE;
	
	private IblTimeZone getTimeZone() {
		return getPrimaryExchange().getTimeZone();
	}
	
	@Override
	public IblSymbolInstance getInstance() {
		return this;
	}

	@Override
	public IblSecurityType getSecurityType() {
		return SECURITY_TYPE;
	}

	@Override
	public IblExchange getExchange() {
		return EXCHANGE;
	}
	
	@Override
	public IblExchange getPrimaryExchange() {
		return PRIMARY_EXCHANGE;
	}
	
	@Override
	public IblCurrency getCurrency() {
		return CURRENCY;
	}
	
	@Override
	public IblUniverse getUniverse() {
		return UNIVERSE;
	}

	public IblEndDateTime getEndDateTimeNow() {
		return getTimeZone().getEndDateTimeNow();
	}

	public IblEndDateTime getEndDateTime(LocalDate aLocalDate) {
		return getTimeZone().getEndDateTime(aLocalDate);
	}
	
	public IblEndDateTime getEndDateTime(int aYear, int aMonth, int aDayOfMonth) {
		return getTimeZone().getEndDateTime(aYear, aMonth, aDayOfMonth);
	}
	
	public IblEndDateTime getEndDateTime2h(LocalDate aLocalDate) {
		return getPrimaryExchange().getEndDateTime2h(aLocalDate);
	}
	
	public IblEndDateTime getEndDateTime2h(int aYear, int aMonth, int aDayOfMonth) {
		return getPrimaryExchange().getEndDateTime2h(aYear, aMonth, aDayOfMonth);
	}
	
	@Override
	public boolean equals(Object aOtherObject) {
		if (this == aOtherObject) return true;
		if (null == aOtherObject) return false;
		if (getClass() != aOtherObject.getClass()) return false;
		IblSymbolInstance other = (IblSymbolInstance) aOtherObject;
		return Objects.equals(getName(), other.getName())
			&& Objects.equals(getExchange(), other.getExchange());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getExchange());
	}
	
	@Override
	public int compareTo(IblSymbolInstance aOther) {
		String name1 = IblString.nvl(getName());
		String name2 = IblString.nvl(aOther.getName());
		int nameCmp = name1.compareTo(name2);
		//
		IblExchangeInstance primaryExchange1 = getPrimaryExchange().getInstance();  
		IblExchangeInstance primaryExchange2 = aOther.getPrimaryExchange().getInstance();  
		int primaryExchangeCmp = primaryExchange1.compareTo(primaryExchange2);
		//
		if (0 == primaryExchangeCmp) {
			return nameCmp;
		}
		else {
			return primaryExchangeCmp;
		}
	}

	@Override
	public String toString() {
		String message = String.format
		(	"%s securityType={%s} exchange={%s} primaryExchange={%s} currency={%s}"
		,	super.toString()
		,	SECURITY_TYPE.getName()
		,	EXCHANGE.getName()
		,	PRIMARY_EXCHANGE.getName()
		,	CURRENCY.getName()
		);
		return message;
	}

	public IblSymbolInstance
	(	int aId
	,	String aName
	,	String aDescription
	//
	,	IblSecurityType aSecurityType
	,	IblExchange aExchange
	,	IblExchange aPrimaryExchange
	,	IblCurrency aCurrency
	,	IblUniverse aUniverse
	) {
		super(aId, aName, aDescription);
		SECURITY_TYPE = aSecurityType;
		EXCHANGE = aExchange;
		PRIMARY_EXCHANGE = aPrimaryExchange;
		CURRENCY = aCurrency;
		UNIVERSE = aUniverse;
	}

}
