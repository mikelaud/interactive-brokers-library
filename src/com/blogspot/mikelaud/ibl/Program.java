package com.blogspot.mikelaud.ibl;

import java.util.concurrent.Callable;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.call.connection_and_server.CallConnect;
import com.blogspot.mikelaud.ibl.task.call.connection_and_server.CallDisconnect;
import com.blogspot.mikelaud.ibl.task.call.contract_details.CallReqContractDetails;
import com.blogspot.mikelaud.ibl.task.call.historical_data.CallReqHistoricalData;
import com.blogspot.mikelaud.ibl.types.IblBarSize;
import com.blogspot.mikelaud.ibl.types.IblDuration;
import com.blogspot.mikelaud.ibl.types.IblEndDateTime;
import com.blogspot.mikelaud.ibl.types.IblTimeZone;

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
		IblEndDateTime endDateTime = IblTimeZone.NEW_YORK.getEndDateTime(2014, 8, 28, 11, 30);
		CallReqHistoricalData reqHistoricalData =
			//new CallReqHistoricalData(mContext, "JPM", "STK", "SMART", "NYSE", endDateTime);
			//new CallReqHistoricalData(mContext, IblDuration.DURATION_1_YEAR, IblBarSize.BAR_1_DAY, "JPM", "STK", "SMART", "NYSE", endDateTime);
			//new CallReqHistoricalData(mContext, IblDuration.DURATION_2_DAYS, IblBarSize.BAR_1_MIN, "JPM", "STK", "SMART", "NYSE", endDateTime);
			new CallReqHistoricalData(mContext, IblDuration.DURATION_2_HOURS, IblBarSize.BAR_5_SEC, "JPM", "STK", "SMART", "NYSE", endDateTime);
		reqHistoricalData.call();
		//--------------------------------------------------------------------
		//CallReqNewsBulletins reqNewsBulletins =
		//	new CallReqNewsBulletins(mContext, true);
		//reqNewsBulletins.call();
		//--------------------------------------------------------------------
		/*
		Contract contract = new Contract();
		contract.m_symbol = "JPM";
		contract.m_secType = "STK";
		contract.m_exchange = "SMART";
		contract.m_primaryExch = "NYSE";
		CallReqRealTimeBars reqRealTimeBars = new CallReqRealTimeBars(mContext, contract, 5, "TRADES", false);
		reqRealTimeBars.call();
		//
		Contract contract2 = new Contract();
		contract2.m_symbol = "ORCL";
		contract2.m_secType = "STK";
		contract2.m_exchange = "SMART";
		contract2.m_primaryExch = "NYSE";
		CallReqRealTimeBars reqRealTimeBars2 = new CallReqRealTimeBars(mContext, contract2, 5, "TRADES", false);
		reqRealTimeBars2.call();
		//
		Thread.sleep(1000 * 1000);
		*/
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
