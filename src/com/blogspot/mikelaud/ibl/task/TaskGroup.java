package com.blogspot.mikelaud.ibl.task;

public enum TaskGroup {
	
	Other,
	ConnectionAndServer,
	MarketData,
	Orders,
	AccountAndPortfolio,
	ContractDetails,
	Executions,
	MarketDepth,
	NewsBulletins,
	FinancialAdvisors,
	HistoricalData,
	MarketScanners,
	RealTimeBars,
	FundamentalData;
	
	private final String NAME;
	private final String DESCRIPTION;
	
	private TaskGroup() {
		NAME = name();
		DESCRIPTION = NAME;
	}
	
	public String getName() {
		return NAME;
	}
	
	public String getDescription() {
		return DESCRIPTION;
	}
	
	@Override
	public String toString() {
		return NAME;
	}

}
