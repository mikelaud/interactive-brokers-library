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
	
	private final String mName;
	private final String mDescription;
	
	private TaskGroup() {
		mName = name();
		mDescription = mName;
	}
	
	public String getName() {
		return mName;
	}
	
	public String getDescription() {
		return mDescription;
	}
	
	@Override
	public String toString() {
		return mName;
	}

}
