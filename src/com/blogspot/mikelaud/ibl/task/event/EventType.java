package com.blogspot.mikelaud.ibl.task.event;

import com.blogspot.mikelaud.ibl.task.TaskGroup;
import com.blogspot.mikelaud.ibl.task.TaskType;
import com.blogspot.mikelaud.ibl.task.call.CallType;
import com.blogspot.mikelaud.ibl.task.event.account_and_portfolio.OnAccountDownloadEnd;
import com.blogspot.mikelaud.ibl.task.event.account_and_portfolio.OnAccountSummary;
import com.blogspot.mikelaud.ibl.task.event.account_and_portfolio.OnAccountSummaryEnd;
import com.blogspot.mikelaud.ibl.task.event.account_and_portfolio.OnPosition;
import com.blogspot.mikelaud.ibl.task.event.account_and_portfolio.OnPositionEnd;
import com.blogspot.mikelaud.ibl.task.event.account_and_portfolio.OnUpdateAccountTime;
import com.blogspot.mikelaud.ibl.task.event.account_and_portfolio.OnUpdateAccountValue;
import com.blogspot.mikelaud.ibl.task.event.account_and_portfolio.OnUpdatePortfolio;
import com.blogspot.mikelaud.ibl.task.event.connection_and_server.OnConnectionClosed;
import com.blogspot.mikelaud.ibl.task.event.connection_and_server.OnCurrentTime;
import com.blogspot.mikelaud.ibl.task.event.connection_and_server.OnError;
import com.blogspot.mikelaud.ibl.task.event.connection_and_server.OnErrorException;
import com.blogspot.mikelaud.ibl.task.event.connection_and_server.OnErrorString;
import com.blogspot.mikelaud.ibl.task.event.connection_and_server.OnIsConnected;
import com.blogspot.mikelaud.ibl.task.event.connection_and_server.OnServerVersion;
import com.blogspot.mikelaud.ibl.task.event.connection_and_server.OnTwsConnectionTime;
import com.blogspot.mikelaud.ibl.task.event.contract_details.OnBondContractDetails;
import com.blogspot.mikelaud.ibl.task.event.contract_details.OnContractDetails;
import com.blogspot.mikelaud.ibl.task.event.contract_details.OnContractDetailsEnd;
import com.blogspot.mikelaud.ibl.task.event.executions.OnCommissionReport;
import com.blogspot.mikelaud.ibl.task.event.executions.OnExecDetails;
import com.blogspot.mikelaud.ibl.task.event.executions.OnExecDetailsEnd;
import com.blogspot.mikelaud.ibl.task.event.financial_advisors.OnManagedAccounts;
import com.blogspot.mikelaud.ibl.task.event.financial_advisors.OnReceiveFA;
import com.blogspot.mikelaud.ibl.task.event.fundamental_data.OnFundamentalData;
import com.blogspot.mikelaud.ibl.task.event.historical_data.OnHistoricalData;
import com.blogspot.mikelaud.ibl.task.event.market_data.OnMarketDataType;
import com.blogspot.mikelaud.ibl.task.event.market_data.OnTickEFP;
import com.blogspot.mikelaud.ibl.task.event.market_data.OnTickGeneric;
import com.blogspot.mikelaud.ibl.task.event.market_data.OnTickOptionComputation;
import com.blogspot.mikelaud.ibl.task.event.market_data.OnTickPrice;
import com.blogspot.mikelaud.ibl.task.event.market_data.OnTickSize;
import com.blogspot.mikelaud.ibl.task.event.market_data.OnTickSnapshotEnd;
import com.blogspot.mikelaud.ibl.task.event.market_data.OnTickString;
import com.blogspot.mikelaud.ibl.task.event.market_depth.OnUpdateMktDepth;
import com.blogspot.mikelaud.ibl.task.event.market_depth.OnUpdateMktDepthL2;
import com.blogspot.mikelaud.ibl.task.event.market_scanners.OnScannerData;
import com.blogspot.mikelaud.ibl.task.event.market_scanners.OnScannerDataEnd;
import com.blogspot.mikelaud.ibl.task.event.market_scanners.OnScannerParameters;
import com.blogspot.mikelaud.ibl.task.event.news_bulletins.OnUpdateNewsBulletin;
import com.blogspot.mikelaud.ibl.task.event.orders.OnDeltaNeutralValidation;
import com.blogspot.mikelaud.ibl.task.event.orders.OnNextValidId;
import com.blogspot.mikelaud.ibl.task.event.orders.OnOpenOrder;
import com.blogspot.mikelaud.ibl.task.event.orders.OnOpenOrderEnd;
import com.blogspot.mikelaud.ibl.task.event.orders.OnOrderStatus;
import com.blogspot.mikelaud.ibl.task.event.other.OnSleepDone;
import com.blogspot.mikelaud.ibl.task.event.real_time_bars.OnRealtimeBar;

/**
 * EClientSocket events enum.
 */
public enum EventType implements TaskType {
	
	//========================================================================
	// Other
	//------------------------------------------------------------------------
	sleepDone
	(	OnSleepDone.class
	,	TaskGroup.Other
	,	"Sleep done."
	),
	//========================================================================
	// Connection and Server
	//------------------------------------------------------------------------
	currentTime
	(	OnCurrentTime.class
	,	TaskGroup.ConnectionAndServer
	,	"Current system time on the server side."
	,	CallType.reqCurrentTime
	),
	error
	(	OnError.class
	,	TaskGroup.ConnectionAndServer
	,	"Error with the communication, or message from the TWS."
	),
	errorException
	(	OnErrorException.class
	,	TaskGroup.ConnectionAndServer
	,	"Exception occurs while handling a request."
	),
	errorString
	(	OnErrorString.class
	,	TaskGroup.ConnectionAndServer
	,	"Error message V1 from the TWS."
	),
	connectionClosed
	(	OnConnectionClosed.class
	,	TaskGroup.ConnectionAndServer
	,	"TWS closes the sockets connection, or TWS is shut down."
	),
	isConnected
	(	OnIsConnected.class
	,	TaskGroup.ConnectionAndServer
	,	"Connection state."
	),
	serverVersion
	(	OnServerVersion.class
	,	TaskGroup.ConnectionAndServer
	,	"Version of the TWS instance to which the API application is connected."
	),
	twsConnectionTime
	(	OnTwsConnectionTime.class
	,	TaskGroup.ConnectionAndServer
	,	"Time the API application made a connection to TWS."
	),
	//========================================================================
	// Market Data
	//------------------------------------------------------------------------
	tickPrice
	(	OnTickPrice.class
	,	TaskGroup.MarketData
	,	"Market data changed, price is updated immediately with no delay."
	),
	tickSize
	(	OnTickSize.class
	,	TaskGroup.MarketData
	,	"Market data changed, size is updated immediately with no delay."
	),
	tickOptionComputation
	(	OnTickOptionComputation.class
	,	TaskGroup.MarketData
	,	"Market in an option or its underlier moves."
	),
	tickGeneric
	(	OnTickGeneric.class
	,	TaskGroup.MarketData
	,	"Market data changed, value is updated immediately with no delay."
	),
	tickString
	(	OnTickString.class
	,	TaskGroup.MarketData
	,	"Market data changed, value is updated immediately with no delay."
	),
	tickEFP
	(	OnTickEFP.class
	,	TaskGroup.MarketData
	,	"Market data changed, value is updated immediately with no delay."
	),
	tickSnapshotEnd
	(	OnTickSnapshotEnd.class
	,	TaskGroup.MarketData
	,	"Snapshot market data subscription has been fully handled, including the timeout case."
	),
	marketDataType
	(	OnMarketDataType.class
	,	TaskGroup.MarketData
	,	"TWS announce that market data has been switched between frozen and real-time."
	),
	//========================================================================
	// Orders
	//------------------------------------------------------------------------
	orderStatus
	(	OnOrderStatus.class
	,	TaskGroup.Orders
	,	"Status of an order changes, or fired after reconnecting to TWS."
	),
	openOrder
	(	OnOpenOrder.class
	,	TaskGroup.Orders
	,	"Feed in open order."
	),
	openOrderEnd
	(	OnOpenOrderEnd.class
	,	TaskGroup.Orders
	,	"End marker after all open orders data are received."
	),
	nextValidId
	(	OnNextValidId.class
	,	TaskGroup.Orders
	,	"Response after a successful connection to TWS."
	),
	deltaNeutralValidation
	(	OnDeltaNeutralValidation.class
	,	TaskGroup.Orders
	,	"Response after Delta-Neutral RFQ, request for quote."
	),
	//========================================================================
	// Account and Portfolio
	//------------------------------------------------------------------------
	updateAccountValue
	(	OnUpdateAccountValue.class
	,	TaskGroup.AccountAndPortfolio
	,	"Response for reqAccountUpdates request."
	),
	updatePortfolio
	(	OnUpdatePortfolio.class
	,	TaskGroup.AccountAndPortfolio
	,	"Response for reqAccountUpdates request."
	),
	updateAccountTime
	(	OnUpdateAccountTime.class
	,	TaskGroup.AccountAndPortfolio
	,	"Response for reqAccountUpdates request."
	),
	accountDownloadEnd
	(	OnAccountDownloadEnd.class
	,	TaskGroup.AccountAndPortfolio
	,	"End marker after a batch updateAccountValue and updatePortfolio is sent."
	),
	accountSummary
	(	OnAccountSummary.class
	,	TaskGroup.AccountAndPortfolio
	,	"Response for reqAccountSummary request."
	),
	accountSummaryEnd
	(	OnAccountSummaryEnd.class
	,	TaskGroup.AccountAndPortfolio
	,	"End marker after all account summary data for reqAccountSummary request are received."
	),
	position
	(	OnPosition.class
	,	TaskGroup.AccountAndPortfolio
	,	"Real-time position response after reqPositions request."
	),
	positionEnd
	(	OnPositionEnd.class
	,	TaskGroup.AccountAndPortfolio
	,	"End marker after all position data for reqPositions request are received."
	),
	//========================================================================
	// Contract Details
	//------------------------------------------------------------------------
	contractDetails
	(	OnContractDetails.class
	,	TaskGroup.ContractDetails
	,	"Response for reqContractDetails request."
	,	CallType.reqContractDetails
	),
	contractDetailsEnd
	(	OnContractDetailsEnd.class
	,	TaskGroup.ContractDetails
	,	"End marker after all contract details for reqContractDetails request are received."
	),
	bondContractDetails
	(	OnBondContractDetails.class
	,	TaskGroup.ContractDetails
	,	"Response for reqContractDetails request."
	),
	//========================================================================
	// Executions
	//------------------------------------------------------------------------
	execDetails
	(	OnExecDetails.class
	,	TaskGroup.Executions
	,	"Response for reqExecutions request, or after an order is filled."
	),
	execDetailsEnd
	(	OnExecDetailsEnd.class
	,	TaskGroup.Executions
	,	"End marker after all executions have been sent to a client in response to reqExecutions."
	),
	commissionReport
	(	OnCommissionReport.class
	,	TaskGroup.Executions
	,	"Response for reqExecutions request, or immediately after a trade execution."
	),
	//========================================================================
	// Market Depth
	//------------------------------------------------------------------------
	updateMktDepth
	(	OnUpdateMktDepth.class
	,	TaskGroup.MarketDepth
	,	"Market data changed."
	),
	updateMktDepthL2
	(	OnUpdateMktDepthL2.class
	,	TaskGroup.MarketDepth
	,	"Level II market data changed."
	),
	//========================================================================
	// News Bulletins
	//------------------------------------------------------------------------
	updateNewsBulletin
	(	OnUpdateNewsBulletin.class
	,	TaskGroup.NewsBulletins
	,	"New bulletin for reqNewsBulletins subscription."
	),
	//========================================================================
	// Financial Advisors
	//------------------------------------------------------------------------
	managedAccounts
	(	OnManagedAccounts.class
	,	TaskGroup.FinancialAdvisors
	,	"Response for reqManagedAccts request, or after a successful connection to TWS."
	),
	receiveFA
	(	OnReceiveFA.class
	,	TaskGroup.FinancialAdvisors
	,	"Response for requested FA configuration information from TWS."
	),
	//========================================================================
	// Historical Data
	//------------------------------------------------------------------------
	historicalData
	(	OnHistoricalData.class
	,	TaskGroup.HistoricalData
	,	"Response for requested historical data."
	),
	//========================================================================
	// Market Scanners
	//------------------------------------------------------------------------
	scannerParameters
	(	OnScannerParameters.class
	,	TaskGroup.MarketScanners
	,	"XML document that describes the valid parameters that a scanner subscription can have."
	),
	scannerData
	(	OnScannerData.class
	,	TaskGroup.MarketScanners
	,	"Requested market scanner data results."
	),
	scannerDataEnd
	(	OnScannerDataEnd.class
	,	TaskGroup.MarketScanners
	,	"End marker after one scan snapshot is received."
	),
	//========================================================================
	// Real Time Bars
	//------------------------------------------------------------------------
	realtimeBar
	(	OnRealtimeBar.class
	,	TaskGroup.RealTimeBars
	,	"Receives the real-time bars data results."
	),
	//========================================================================
	// Fundamental Data
	//------------------------------------------------------------------------
	fundamentalData
	(	OnFundamentalData.class
	,	TaskGroup.FundamentalData
	,	"Receives Reuters global fundamental market data."
	);
	//========================================================================
	
	private final Class<? extends EventTask> TASK_CLASS;
	private final String NAME;
	private final TaskGroup GROUP;
	private final String DECRIPTION;
	private final CallType TARGET_CALL_TYPE;
	
	private EventType
	(	Class<? extends EventTask> aEventClass
	,	TaskGroup aGroup
	,	String aDescription
	,	CallType aTargetCallType
	) {
		TASK_CLASS = aEventClass;
		NAME = name();
		GROUP = aGroup;
		DECRIPTION = aDescription;
		TARGET_CALL_TYPE = aTargetCallType;
	}
	
	private EventType
	(	Class<? extends EventTask> aEventClass
	,	TaskGroup aGroup
	,	String aDescription
	) {
		this(aEventClass, aGroup, aDescription, null);
	}
	
	@Override
	public Class<? extends EventTask> getTaskClass() {
		return TASK_CLASS;
	}
	
	@Override
	public TaskGroup getGroup() {
		return GROUP;
	}	

	@Override
	public String getName() {
		return NAME;
	}
	
	@Override
	public String getDescription() {
		return DECRIPTION;
	}
		
	public CallType getTargetCallType() {
		return TARGET_CALL_TYPE;
	}
		
	@Override
	public String toString() {
		return String.format("%s.%s", GROUP, NAME);
	}

}
