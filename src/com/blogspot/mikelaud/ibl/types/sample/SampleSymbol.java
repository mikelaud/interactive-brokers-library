package com.blogspot.mikelaud.ibl.types.sample;

import com.blogspot.mikelaud.ibl.types.IblCurrency;
import com.blogspot.mikelaud.ibl.types.IblSecurityType;
import com.blogspot.mikelaud.ibl.types.common.IblExchange;
import com.blogspot.mikelaud.ibl.types.common.IblSymbol;
import com.blogspot.mikelaud.ibl.types.common.IblSymbolInstance;

public enum SampleSymbol implements IblSymbol {

	JPM(SampleExchange.NYSE),
	XXX123(SampleExchange.NYSE);
	
	private final IblSymbolInstance INSTANCE;
	
	private SampleSymbol(IblExchange aPrimaryExchange) {
		INSTANCE = new IblSymbolInstance
		(	this.ordinal()
		,	this.name()
		,	this.name()
		//
		,	IblSecurityType.STK
		,	SampleExchange.SMART
		,	aPrimaryExchange
		,	IblCurrency.USD
		//
		,	SampleUniverse.MISC
		);
	}

	@Override
	public IblSymbolInstance getInstance() {
		return INSTANCE;
	}
	
	@Override
	public String toString() {
		return INSTANCE.toString();
	}

}
