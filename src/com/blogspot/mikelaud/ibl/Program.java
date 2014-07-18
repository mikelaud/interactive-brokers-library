package com.blogspot.mikelaud.ibl;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.connection_and_server.CallConnect;
import com.blogspot.mikelaud.ibl.task.call.connection_and_server.CallReqCurrentTime;
import com.blogspot.mikelaud.ibl.task.call.contract_details.CallReqContractDetails;
import com.ib.client.Contract;

public class Program implements Callable<Object> {

	private ConnectionContext mContext;
	
	@Override
	public Object call() throws Exception {
		
		new CallConnect
		(	mContext
		,	Config.getHost()
		,	Config.getPort()
		,	Config.getClientId()
		).callCommand();
		//
		Contract contract = new Contract();
		contract.m_symbol = "JPM";
		contract.m_secType = "STK";
		contract.m_exchange = "SMART";
		contract.m_primaryExch = "SMART";
		contract.m_currency = "USD";
		CallReqContractDetails.In contractInfo = new CallReqContractDetails.In(0, contract);
		mContext.onTask(new CallReqContractDetails(mContext, contractInfo).getCommand(10, TimeUnit.SECONDS));
		//
		mContext.onTask(new CallReqCurrentTime(mContext).getCommand(10, TimeUnit.SECONDS));
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
