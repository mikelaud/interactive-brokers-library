package com.blogspot.mikelaud.ibl.types.sample;

import com.blogspot.mikelaud.ibl.types.IblTimeZone;
import com.blogspot.mikelaud.ibl.types.IblTradingHours;
import com.blogspot.mikelaud.ibl.types.common.IblExchange;
import com.blogspot.mikelaud.ibl.types.common.IblExchangeInstance;

public enum SampleExchange implements IblExchange {

	NYSE("New York Stock Exchange"),
	SMART("SMART Exchange");
	
	private final IblExchangeInstance INSTANCE;
	
	private SampleExchange(String aDescription) {
		INSTANCE = new IblExchangeInstance
		(	this.ordinal()
		,	this.name()
		,	aDescription
		//
		,	IblTimeZone.NEW_YORK
		,	new IblTradingHours()
		);
	}

	@Override
	public IblExchangeInstance getInstance() {
		return INSTANCE;
	}

	@Override
	public String toString() {
		return INSTANCE.toString();
	}

}
