package com.blogspot.mikelaud.ibl.types.sample;

import com.blogspot.mikelaud.ibl.types.IblCurrency;
import com.blogspot.mikelaud.ibl.types.IblSecurityType;
import com.blogspot.mikelaud.ibl.types.common.IblExchange;
import com.blogspot.mikelaud.ibl.types.common.IblSymbol;
import com.blogspot.mikelaud.ibl.types.common.IblSymbolInstance;

public enum SampleSymbols implements IblSymbol {

	JPM(SampleExchanges.NYSE),
	ORCL(SampleExchanges.NYSE);
	
	private final IblSymbolInstance INSTANCE;
	
	private SampleSymbols(IblExchange aPrimaryExchange) {
		INSTANCE = new IblSymbolInstance
		(	this.ordinal()
		,	this.name()
		,	this.name()
		//
		,	IblSecurityType.STK
		,	SampleExchanges.SMART
		,	aPrimaryExchange
		,	IblCurrency.USD
		//
		,	SampleUniverses.MISC
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
