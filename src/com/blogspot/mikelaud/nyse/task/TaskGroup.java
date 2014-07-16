package com.blogspot.mikelaud.nyse.task;

public enum TaskGroup {
	
	Other
	(	"Other"
	,	"Other"
	),
	ConnectionAndServer
	(	"ConnectionAndServer"
	,	"Connection and Server"
	),
	MarketData
	(	"MarketData"
	,	"Market Data"
	),
	Orders
	(	"Orders"
	,	"Orders"
	),
	AccountAndPortfolio
	(	"AccountAndPortfolio"
	,	"Account and Portfolio"
	),
	ContractDetails
	(	"ContractDetails"
	,	"Contract Details"
	),
	Executions
	(	"Executions"
	,	"Executions"
	),
	MarketDepth
	(	"MarketDepth"
	,	"Market Depth"
	),
	NewsBulletins
	(	"NewsBulletins"
	,	"News Bulletins"
	),
	FinancialAdvisors
	(	"FinancialAdvisors"
	,	"Financial Advisors"
	),
	HistoricalData
	(	"HistoricalData"
	,	"Historical Data"
	),
	MarketScanners
	(	"MarketScanners"
	,	"Market Scanners"
	),
	RealTimeBars
	(	"RealTimeBars"
	,	"Real Time Bars"
	),
	FundamentalData
	(	"FundamentalData"
	,	"Fundamental Data"
	),
	DisplayGroups
	(	"DisplayGroups"
	,	"Display Groups"
	);
	
	private final String mName;
	private final String mDescription;
	
	private TaskGroup(String aName, String aDescription) {
		mName = aName;
		mDescription = aDescription;
	}
	
	public String getName() { return mName; }
	public String getDescription() { return mDescription; }
	
	@Override
	public String toString() {
		return mName;
	}

}
