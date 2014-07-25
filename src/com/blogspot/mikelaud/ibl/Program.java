package com.blogspot.mikelaud.ibl;

import java.util.concurrent.Callable;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.connection_and_server.CallConnect;
import com.blogspot.mikelaud.ibl.task.call.contract_details.CallReqContractDetails;
import com.blogspot.mikelaud.ibl.task.call.historical_data.CallReqHistoricalData;

public class Program implements Callable<Object> {

	private ConnectionContext mContext;
	
	@Override
	public Object call() throws Exception {
		//--------------------------------------------------------------------
		CallConnect callConnect = new CallConnect(mContext);
		callConnect.call();
		//--------------------------------------------------------------------
		CallReqContractDetails reqContractDetails =
			new CallReqContractDetails(mContext, "JPM", "STK", "SMART", "NYSE");
		reqContractDetails.call();
		//--------------------------------------------------------------------
		CallReqHistoricalData reqHistoricalData =
			new CallReqHistoricalData(mContext, "JPM2", "STK", "SMART", "NYSE", "20140722  23:59:59");
		reqHistoricalData.call();
		//--------------------------------------------------------------------
		//mContext.onTask(callConnect);
		//
		for (;;) {
			Task task = mContext.nextTask();
			if (null != task) {
				mContext.onTask(task);
			}
		}
		//
		//return null;
	}

	public Program() {
		mContext = new ConnectionContext();
	}
	
}
