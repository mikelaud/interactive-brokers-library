package com.blogspot.mikelaud.ibl;

import java.util.concurrent.Callable;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.call.connection_and_server.CallConnect;
import com.blogspot.mikelaud.ibl.task.call.connection_and_server.CallDisconnect;
import com.blogspot.mikelaud.ibl.task.call.connection_and_server.CallReqCurrentTime;
import com.blogspot.mikelaud.ibl.task.call.contract_details.CallReqContractDetails;
import com.blogspot.mikelaud.ibl.task.call.historical_data.CallReqHistoricalData;
import com.blogspot.mikelaud.ibl.types.IblBarSize;
import com.blogspot.mikelaud.ibl.types.sample.SampleSymbol;

public class Program implements Callable<Object> {

	private ConnectionContext mContext;
	
	@Override
	public Object call() throws Exception {
		//--------------------------------------------------------------------
		CallConnect connect = new CallConnect(mContext);
		connect.call();
		//--------------------------------------------------------------------
		CallReqCurrentTime reqCurrentTime = new CallReqCurrentTime(mContext);
		reqCurrentTime.call();
		//--------------------------------------------------------------------
		CallReqContractDetails reqContractDetails = new CallReqContractDetails
		(	mContext
		,	SampleSymbol.JPM
		);
		reqContractDetails.call();
		//--------------------------------------------------------------------
		CallReqHistoricalData reqHistoricalDataYear = new CallReqHistoricalData
		(	mContext
		,	IblBarSize.BAR_1_DAY
		,	SampleSymbol.JPM
		,	SampleSymbol.JPM.getEndDateTimeNow()
		);
		/*
		CallReqHistoricalData reqHistoricalDataMin = new CallReqHistoricalData
		(	mContext
		,	IblBarSize.BAR_1_MIN
		,	SampleSymbol.JPM
		,	SampleSymbol.JPM.getEndDateTime(2014, 8, 29)
		);
		*/
		/*
		CallReqHistoricalData reqHistoricalDataSec = new CallReqHistoricalData
		(	mContext
		,	IblBarSize.BAR_5_SEC
		,	SampleSymbol.JPM
		,	SampleSymbol.JPM.getEndDateTime2h(2014, 8, 28)
		);
		*/
		reqHistoricalDataYear.call();
		//reqHistoricalDataMin.call();
		//reqHistoricalDataSec.call();
		//--------------------------------------------------------------------
		/*
		CallReqRealTimeBars reqRealTimeBars = new CallReqRealTimeBars
		(	mContext
		,	SampleSymbol.JPM
		);
		//reqRealTimeBars.call();
		//Thread.sleep(1000 * 5 * 10);
		 */
		//--------------------------------------------------------------------
		CallDisconnect disconnect = new CallDisconnect(mContext);
		disconnect.call();
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
		//--------------------------------------------------------------------
		return null;
	}

	public Program() {
		mContext = new ConnectionContext();
	}
	
}
