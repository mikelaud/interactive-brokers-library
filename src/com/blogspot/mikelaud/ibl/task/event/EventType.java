package com.blogspot.mikelaud.nyse.task.event;

import com.blogspot.mikelaud.nyse.task.TaskGroup;
import com.blogspot.mikelaud.nyse.task.call.CallType;

/**
 * EClientSocket events enum.
 */
public enum EventType {
	
	//========================================================================
	// Other
	//------------------------------------------------------------------------
	sleepDone
	(	"sleepDone"
	,	TaskGroup.Other
	,	"Sleep done."
	),
	//========================================================================
	// Connection and Server
	//------------------------------------------------------------------------
	currentTime
	(	"currentTime"
	,	TaskGroup.ConnectionAndServer
	,	"Current system time on the server side."
	,	CallType.reqCurrentTime
	),
	error
	(	"error"
	,	TaskGroup.ConnectionAndServer
	,	"Error with the communication, or message from the TWS."
	),
	errorException
	(	"errorException"
	,	TaskGroup.ConnectionAndServer
	,	"Exception occurs while handling a request."
	),
	errorString
	(	"errorString"
	,	TaskGroup.ConnectionAndServer
	,	"Error message V1 from the TWS."
	),
	connectionClosed
	(	"connectionClosed"
	,	TaskGroup.ConnectionAndServer
	,	"TWS closes the sockets connection, or TWS is shut down."
	),
	isConnected
	(	"isConnected"
	,	TaskGroup.ConnectionAndServer
	,	"Connection state."
	),
	serverVersion
	(	"serverVersion"
	,	TaskGroup.ConnectionAndServer
	,	"Version of the TWS instance to which the API application is connected."
	),
	twsConnectionTime
	(	"twsConnectionTime"
	,	TaskGroup.ConnectionAndServer
	,	"Time the API application made a connection to TWS."
	),
	//========================================================================
	// Market Data
	//------------------------------------------------------------------------
	tickPrice
	(	"tickPrice"
	,	TaskGroup.MarketData
	,	"Market data changed, price is updated immediately with no delay."
	),
	tickSize
	(	"tickSize"
	,	TaskGroup.MarketData
	,	"Market data changed, size is updated immediately with no delay."
	),
	tickOptionComputation
	(	"tickOptionComputation"
	,	TaskGroup.MarketData
	,	"Market in an option or its underlier moves."
	),
	tickGeneric
	(	"tickGeneric"
	,	TaskGroup.MarketData
	,	"Market data changed, value is updated immediately with no delay."
	),
	tickString
	(	"tickString"
	,	TaskGroup.MarketData
	,	"Market data changed, value is updated immediately with no delay."
	),
	tickEFP
	(	"tickEFP"
	,	TaskGroup.MarketData
	,	"Market data changed, value is updated immediately with no delay."
	),
	tickSnapshotEnd
	(	"tickSnapshotEnd"
	,	TaskGroup.MarketData
	,	"Snapshot market data subscription has been fully handled, including the timeout case."
	),
	marketDataType
	(	"marketDataType"
	,	TaskGroup.MarketData
	,	"TWS announce that market data has been switched between frozen and real-time."
	),
	//========================================================================
	// Orders
	//------------------------------------------------------------------------
	orderStatus
	(	"orderStatus"
	,	TaskGroup.Orders
	,	"Status of an order changes, or fired after reconnecting to TWS."
	),
	openOrder
	(	"openOrder"
	,	TaskGroup.Orders
	,	"Feed in open order."
	),
	openOrderEnd
	(	"openOrderEnd"
	,	TaskGroup.Orders
	,	"End marker after all open orders data are received."
	),
	nextValidId
	(	"nextValidId"
	,	TaskGroup.Orders
	,	"Response after a successful connection to TWS."
	),
	deltaNeutralValidation
	(	"deltaNeutralValidation"
	,	TaskGroup.Orders
	,	"Response after Delta-Neutral RFQ, request for quote."
	),
	//========================================================================
	// Account and Portfolio
	//------------------------------------------------------------------------
	updateAccountValue
	(	"updateAccountValue"
	,	TaskGroup.AccountAndPortfolio
	,	"Response for reqAccountUpdates request."
	),
	updatePortfolio
	(	"updatePortfolio"
	,	TaskGroup.AccountAndPortfolio
	,	"Response for reqAccountUpdates request."
	),
	updateAccountTime
	(	"updateAccountTime"
	,	TaskGroup.AccountAndPortfolio
	,	"Response for reqAccountUpdates request."
	),
	accountDownloadEnd
	(	"accountDownloadEnd"
	,	TaskGroup.AccountAndPortfolio
	,	"End marker after a batch updateAccountValue and updatePortfolio is sent."
	),
	accountSummary
	(	"accountSummary"
	,	TaskGroup.AccountAndPortfolio
	,	"Response for reqAccountSummary request."
	),
	accountSummaryEnd
	(	"accountSummaryEnd"
	,	TaskGroup.AccountAndPortfolio
	,	"End marker after all account summary data for reqAccountSummary request are received."
	),
	position
	(	"position"
	,	TaskGroup.AccountAndPortfolio
	,	"Real-time position response after reqPositions request."
	),
	positionEnd
	(	"positionEnd"
	,	TaskGroup.AccountAndPortfolio
	,	"End marker after all position data for reqPositions request are received."
	),
	//========================================================================
	// Contract Details
	//------------------------------------------------------------------------
	contractDetails
	(	"contractDetails"
	,	TaskGroup.ContractDetails
	,	"Response for reqContractDetails request."
	,	CallType.reqContractDetails
	),
	contractDetailsEnd
	(	"contractDetailsEnd"
	,	TaskGroup.ContractDetails
	,	"End marker after all contract details for reqContractDetails request are received."
	),
	bondContractDetails
	(	"bondContractDetails"
	,	TaskGroup.ContractDetails
	,	"Response for reqContractDetails request."
	),
	//========================================================================
	// Executions
	//------------------------------------------------------------------------
	execDetails
	(	"execDetails"
	,	TaskGroup.Executions
	,	"Response for reqExecutions request, or after an order is filled."
	),
	execDetailsEnd
	(	"execDetailsEnd"
	,	TaskGroup.Executions
	,	"End marker after all executions have been sent to a client in response to reqExecutions."
	),
	commissionReport
	(	"commissionReport"
	,	TaskGroup.Executions
	,	"Response for reqExecutions request, or immediately after a trade execution."
	),
	//========================================================================
	// Market Depth
	//------------------------------------------------------------------------
	updateMktDepth
	(	"updateMktDepth"
	,	TaskGroup.MarketDepth
	,	"Market data changed."
	),
	updateMktDepthL2
	(	"updateMktDepthL2"
	,	TaskGroup.MarketDepth
	,	"Level II market data changed."
	),
	//========================================================================
	// News Bulletins
	//------------------------------------------------------------------------
	updateNewsBulletin
	(	"updateNewsBulletin"
	,	TaskGroup.NewsBulletins
	,	"New bulletin for reqNewsBulletins subscription."
	),
	//========================================================================
	// Financial Advisors
	//------------------------------------------------------------------------
	managedAccounts
	(	"managedAccounts"
	,	TaskGroup.FinancialAdvisors
	,	"Response for reqManagedAccts request, or after a successful connection to TWS."
	),
	receiveFA
	(	"receiveFA"
	,	TaskGroup.FinancialAdvisors
	,	"Response for requested FA configuration information from TWS."
	),
	//========================================================================
	// Historical Data
	//------------------------------------------------------------------------
	historicalData
	(	"historicalData"
	,	TaskGroup.HistoricalData
	,	"Response for requested historical data."
	),
	//========================================================================
	// Market Scanners
	//------------------------------------------------------------------------
	scannerParameters
	(	"scannerParameters"
	,	TaskGroup.MarketScanners
	,	"XML document that describes the valid parameters that a scanner subscription can have."
	),
	scannerData
	(	"scannerData"
	,	TaskGroup.MarketScanners
	,	"Requested market scanner data results."
	),
	scannerDataEnd
	(	"scannerDataEnd"
	,	TaskGroup.MarketScanners
	,	"End marker after one scan snapshot is received."
	),
	//========================================================================
	// Real Time Bars
	//------------------------------------------------------------------------
	realtimeBar
	(	"realtimeBar"
	,	TaskGroup.RealTimeBars
	,	"Receives the real-time bars data results."
	),
	//========================================================================
	// Fundamental Data
	//------------------------------------------------------------------------
	fundamentalData
	(	"fundamentalData"
	,	TaskGroup.FundamentalData
	,	"Receives Reuters global fundamental market data."
	),
	//========================================================================
	// Display Groups
	//------------------------------------------------------------------------
	displayGroupList
	(	"displayGroupList"
	,	TaskGroup.DisplayGroups
	,	"One-time response for queryDisplayGroups request."
	),
	displayGroupUpdated
	(	"displayGroupUpdated"
	,	TaskGroup.DisplayGroups
	,	"TWS response for subscribeToGroupEvents request, or selected contract in the subscribed display group has changed."
	);
	//========================================================================
	
	private final String NAME;
	private final TaskGroup GROUP;
	private final String DECRIPTION;
	private final CallType TARGET_CALL_TYPE;
	
	private EventType(String aName, TaskGroup aGroup, String aDescription, CallType aTargetCallType) {
		NAME = aName;
		GROUP = aGroup;
		DECRIPTION = aDescription;
		TARGET_CALL_TYPE = aTargetCallType;
	}
	
	private EventType(String aName, TaskGroup aGroup, String aDescription) {
		this(aName, aGroup, aDescription, null);
	}
	
	public String getName() { return NAME; }
	public TaskGroup getGroup() { return GROUP; }	
	public String getDescription() { return DECRIPTION; }
	public CallType getTargetCallType() { return TARGET_CALL_TYPE; }
		
	@Override
	public String toString() {
		return String.format("%s.%s", GROUP, NAME);
	}

}
