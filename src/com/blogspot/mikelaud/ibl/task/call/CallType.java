package com.blogspot.mikelaud.ibl.task.call;

import com.blogspot.mikelaud.ibl.router.context.Context;
import com.blogspot.mikelaud.ibl.task.TaskGroup;

/**
 * EClientSocket calls enum.
 */
public enum CallType {

	//========================================================================
	// Other
	//------------------------------------------------------------------------
	sleep
	(	"sleep"
	,	TaskGroup.Other
	,	CallKind.NOCAST
	,	"Create pause."
	),
	//========================================================================
	// Connection and Server
	//------------------------------------------------------------------------
	connect
	(	"connect"
	,	TaskGroup.ConnectionAndServer
	,	CallKind.MULTICAST
	,	"Establish the connection with TWS."
	),
	disconnect
	(	"disconnect"
	,	TaskGroup.ConnectionAndServer
	,	CallKind.NOCAST
	,	"Terminate the connection with TWS."
	),
	isConnected
	(	"isConnected"
	,	TaskGroup.ConnectionAndServer
	,	CallKind.NOCAST
	,	"Check if there is a connection with TWS."
	),
	setServerLogLevel
	(	"setServerLogLevel"
	,	TaskGroup.ConnectionAndServer
	,	CallKind.NOCAST
	,	"Set server log level."
	),
	reqCurrentTime
	(	"reqCurrentTime"
	,	TaskGroup.ConnectionAndServer
	,	CallKind.MULTICAST
	,	"Request current system time on the server side."
	),
	serverVersion
	(	"serverVersion"
	,	TaskGroup.ConnectionAndServer
	,	CallKind.NOCAST
	,	"Get version of the TWS instance to which the API application is connected."
	),
	twsConnectionTime
	(	"twsConnectionTime"
	,	TaskGroup.ConnectionAndServer
	,	CallKind.NOCAST
	,	"Get time the API application made a connection to TWS."
	),
	//========================================================================
	// Market Data
	//------------------------------------------------------------------------
	reqMktData
	(	"reqMktData"
	,	TaskGroup.MarketData
	,	CallKind.NOCAST
	,	"Request market data."
	),
	cancelMktData
	(	"cancelMktData"
	,	TaskGroup.MarketData
	,	CallKind.NOCAST
	,	"Stop flowing market data for the specified Id."
	),
	calculateImpliedVolatility
	(	"calculateImpliedVolatility"
	,	TaskGroup.MarketData
	,	CallKind.NOCAST
	,	"Calculate volatility for a supplied option price and underlying price."
	),
	cancelCalculateImpliedVolatility
	(	"cancelCalculateImpliedVolatility"
	,	TaskGroup.MarketData
	,	CallKind.NOCAST
	,	"Cancel a request to calculate volatility for a supplied option price and underlying price."
	),
	calculateOptionPrice
	(	"calculateOptionPrice"
	,	TaskGroup.MarketData
	,	CallKind.NOCAST
	,	"Calculate option price and greek values for a supplied volatility and underlying price."
	),
	cancelCalculateOptionPrice
	(	"cancelCalculateOptionPrice"
	,	TaskGroup.MarketData
	,	CallKind.NOCAST
	,	"Cancel a request to calculate the option price and greek values for a supplied volatility and underlying price."
	),
	reqMarketDataType
	(	"reqMarketDataType"
	,	TaskGroup.MarketData
	,	CallKind.NOCAST
	,	"Telling TWS to automatically switch to frozen market data after the close."
	),
	//========================================================================
	// Orders
	//------------------------------------------------------------------------
	placeOrder
	(	"placeOrder"
	,	TaskGroup.Orders
	,	CallKind.NOCAST
	,	"Place an order."
	),
	cancelOrder
	(	"cancelOrder"
	,	TaskGroup.Orders
	,	CallKind.NOCAST
	,	"Cancel an order."
	),
	reqOpenOrders
	(	"reqOpenOrders"
	,	TaskGroup.Orders
	,	CallKind.NOCAST
	,	"Request any open orders that were placed from this API client."
	),
	reqAllOpenOrders
	(	"reqAllOpenOrders"
	,	TaskGroup.Orders
	,	CallKind.NOCAST
	,	"Request all open orders that were placed from all API clients linked to one TWS, and also from the TWS."
	),
	reqAutoOpenOrders
	(	"reqAutoOpenOrders"
	,	TaskGroup.Orders
	,	CallKind.NOCAST
	,	"Request that newly created TWS orders be implicitly associated with the client."
	),
	reqIDs
	(	"reqIDs"
	,	TaskGroup.Orders
	,	CallKind.NOCAST
	,	"Request the next valid ID that can be used when placing an order."
	),
	exerciseOptions
	(	"exerciseOptions"
	,	TaskGroup.Orders
	,	CallKind.NOCAST
	,	"Exercise options."
	),
	reqGlobalCancel
	(	"reqGlobalCancel"
	,	TaskGroup.Orders
	,	CallKind.NOCAST
	,	"Cancel all open orders globally: both API and TWS open orders."
	),
	//========================================================================
	// Account and Portfolio
	//------------------------------------------------------------------------
	reqAccountUpdates
	(	"reqAccountUpdates"
	,	TaskGroup.AccountAndPortfolio
	,	CallKind.NOCAST
	,	"Start getting account values, portfolio, and last update time information."
	),
	reqAccountSummary
	(	"reqAccountSummary"
	,	TaskGroup.AccountAndPortfolio
	,	CallKind.NOCAST
	,	"Request and keep up to date the data that appears on the TWS Account Window Summary tab."
	),
	cancelAccountSummary
	(	"cancelAccountSummary"
	,	TaskGroup.AccountAndPortfolio
	,	CallKind.NOCAST
	,	"Cancels the request for Account Window Summary tab data."
	),
	reqPositions
	(	"reqPositions"
	,	TaskGroup.AccountAndPortfolio
	,	CallKind.NOCAST
	,	"Requests real-time position data for all accounts."
	),
	cancelPositions
	(	"cancelPositions"
	,	TaskGroup.AccountAndPortfolio
	,	CallKind.NOCAST
	,	"Cancels real-time position updates."
	),
	//========================================================================
	// Contract Details
	//------------------------------------------------------------------------
	reqContractDetails
	(	"reqContractDetails"
	,	TaskGroup.ContractDetails
	,	CallKind.UNICAST
	,	"Download all details for a particular contract."
	),
	//========================================================================
	// Executions
	//------------------------------------------------------------------------
	reqExecutions
	(	"reqExecutions"
	,	TaskGroup.Executions
	,	CallKind.NOCAST
	,	"Request execution reports from the last 24 hours that meet the filter criteria."
	),
	//========================================================================
	// Market Depth
	//------------------------------------------------------------------------
	reqMktDepth
	(	"reqMktDepth"
	,	TaskGroup.MarketDepth
	,	CallKind.NOCAST
	,	"Request market depth for a specific contract."
	),
	cancelMktDepth
	(	"cancelMktDepth"
	,	TaskGroup.MarketDepth
	,	CallKind.NOCAST
	,	"Stop flowing market depth data for the specified Id."
	),
	//========================================================================
	// News Bulletins
	//------------------------------------------------------------------------
	reqNewsBulletins
	(	"reqNewsBulletins"
	,	TaskGroup.NewsBulletins
	,	CallKind.NOCAST
	,	"Start receiving news bulletins."
	),
	cancelNewsBulletins
	(	"cancelNewsBulletins"
	,	TaskGroup.NewsBulletins
	,	CallKind.NOCAST
	,	"Stop receiving news bulletins."
	),
	//========================================================================
	// Financial Advisors
	//------------------------------------------------------------------------
	reqManagedAccts
	(	"reqManagedAccts"
	,	TaskGroup.FinancialAdvisors
	,	CallKind.NOCAST
	,	"Request the list of managed accounts."
	),
	requestFA
	(	"requestFA"
	,	TaskGroup.FinancialAdvisors
	,	CallKind.NOCAST
	,	"Request FA configuration information from TWS."
	),
	replaceFA
	(	"replaceFA"
	,	TaskGroup.FinancialAdvisors
	,	CallKind.NOCAST
	,	"Request new FA configuration information from TWS."
	),
	//========================================================================
	// Historical Data
	//------------------------------------------------------------------------
	reqHistoricalData
	(	"reqHistoricalData"
	,	TaskGroup.HistoricalData
	,	CallKind.NOCAST
	,	"Start receiving historical data results."
	),
	cancelHistoricalData
	(	"cancelHistoricalData"
	,	TaskGroup.HistoricalData
	,	CallKind.NOCAST
	,	"Stop receiving historical data results."
	),
	//========================================================================
	// Market Scanners
	//------------------------------------------------------------------------
	reqScannerParameters
	(	"reqScannerParameters"
	,	TaskGroup.MarketScanners
	,	CallKind.NOCAST
	,	"Request an XML document that describes the valid parameters that a scanner subscription can have."
	),
	reqScannerSubscription
	(	"reqScannerSubscription"
	,	TaskGroup.MarketScanners
	,	CallKind.NOCAST
	,	"Start receiving market scanner results."
	),
	cancelScannerSubscription
	(	"cancelScannerSubscription"
	,	TaskGroup.MarketScanners
	,	CallKind.NOCAST
	,	"Stop receiving market scanner results."
	),
	//========================================================================
	// Real Time Bars
	//------------------------------------------------------------------------
	reqRealTimeBars
	(	"reqRealTimeBars"
	,	TaskGroup.RealTimeBars
	,	CallKind.NOCAST
	,	"Start receiving real time bar results."
	),
	cancelRealTimeBars
	(	"cancelRealTimeBars"
	,	TaskGroup.RealTimeBars
	,	CallKind.NOCAST
	,	"Stop receiving real time bar results."
	),
	//========================================================================
	// Fundamental Data
	//------------------------------------------------------------------------
	reqFundamentalData
	(	"reqFundamentalData"
	,	TaskGroup.FundamentalData
	,	CallKind.NOCAST
	,	"Start receiving Reuters global fundamental data."
	),
	cancelFundamentalData
	(	"cancelFundamentalData"
	,	TaskGroup.FundamentalData
	,	CallKind.NOCAST
	,	"Stop receiving Reuters global fundamental data."
	),
	//========================================================================
	// Display Groups
	//------------------------------------------------------------------------
	queryDisplayGroups
	(	"queryDisplayGroups"
	,	TaskGroup.DisplayGroups
	,	CallKind.NOCAST
	,	"Query display groups."
	),
	subscribeToGroupEvents
	(	"subscribeToGroupEvents"
	,	TaskGroup.DisplayGroups
	,	CallKind.NOCAST
	,	"Subscribe to group events."
	),
	updateDisplayGroup
	(	"updateDisplayGroup"
	,	TaskGroup.DisplayGroups
	,	CallKind.NOCAST
	,	"Update display group."
	),
	unsubscribeFromGroupEvents
	(	"unsubscribeFromGroupEvents"
	,	TaskGroup.DisplayGroups
	,	CallKind.NOCAST
	,	"Unsubscribe from group events."
	);
	//========================================================================
	
	private final String NAME;
	private final TaskGroup GROUP;
	private final CallKind KIND;
	private final String DESCRIPTION;
	private final Context CONTEXT;
	
	private CallType(String aName, TaskGroup aGroup, CallKind aKind, String aDescription) {
		NAME = aName;
		GROUP = aGroup;
		KIND = aKind;
		DESCRIPTION = aDescription;
		CONTEXT = CallKind.createContext(aKind);
	}
	
	public String getName() { return NAME; }
	public TaskGroup getGroup() { return GROUP; }	
	public CallKind getKind() { return KIND; }	
	public String getDescription() { return DESCRIPTION; }
	public Context getContext() { return CONTEXT; }
	
	@Override
	public String toString() {
		return String.format("%s.%s", GROUP, NAME);
	}

}
