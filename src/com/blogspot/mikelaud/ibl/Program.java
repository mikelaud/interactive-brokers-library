package com.blogspot.mikelaud.ibl;

import java.util.concurrent.Callable;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.call.connection_and_server.CallConnect;
import com.blogspot.mikelaud.ibl.task.call.connection_and_server.CallDisconnect;
import com.blogspot.mikelaud.ibl.task.call.contract_details.CallReqContractDetails;
import com.blogspot.mikelaud.ibl.task.call.historical_data.CallReqHistoricalData;
import com.blogspot.mikelaud.ibl.types.IblBarSize;
import com.blogspot.mikelaud.ibl.types.IblDuration;
import com.blogspot.mikelaud.ibl.types.sample.SampleSymbols;

public class Program implements Callable<Object> {

	private ConnectionContext mContext;
	
	@Override
	public Object call() throws Exception {
		//--------------------------------------------------------------------
		CallConnect callConnect = new CallConnect(mContext);
		callConnect.call();
		//--------------------------------------------------------------------
		CallReqContractDetails reqContractDetails = new CallReqContractDetails
		(	mContext
		,	SampleSymbols.JPM
		);
		reqContractDetails.call();
		//--------------------------------------------------------------------
		CallReqHistoricalData reqHistoricalDataYear = new CallReqHistoricalData
		(	mContext
		,	IblBarSize.BAR_1_DAY
		,	IblDuration.DURATION_1_YEAR
		,	SampleSymbols.JPM
		,	SampleSymbols.JPM.getEndDateTimeNow()
		);
		CallReqHistoricalData reqHistoricalDataMin = new CallReqHistoricalData
		(	mContext
		,	IblBarSize.BAR_1_MIN
		,	IblDuration.DURATION_2_DAYS
		,	SampleSymbols.JPM
		,	SampleSymbols.JPM.getEndDateTime(2014, 8, 29)
		);
		CallReqHistoricalData reqHistoricalDataSec = new CallReqHistoricalData
		(	mContext
		,	IblBarSize.BAR_5_SEC
		,	IblDuration.DURATION_2_HOURS
		,	SampleSymbols.JPM
		,	SampleSymbols.JPM.getEndDateTime2h(2014, 8, 28)
		);
		reqHistoricalDataYear.call();
		//reqHistoricalDataMin.call();
		//reqHistoricalDataSec.call();
		//--------------------------------------------------------------------
		//Thread.sleep(1000 * 1000);
		//--------------------------------------------------------------------
		CallDisconnect callDisconnect = new CallDisconnect(mContext);
		callDisconnect.call();
		//--------------------------------------------------------------------
		/*
		mContext.onTask(callConnect);
		for (;;) {
			Task task = mContext.nextTask();
			if (null != task) {
				mContext.onTask(task);
			}
		}
		*/
		return null;
	}

	public Program() {
		mContext = new ConnectionContext();
	}
	
}
