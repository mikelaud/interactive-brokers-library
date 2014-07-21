package com.blogspot.mikelaud.ibl;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.call.connection_and_server.CallConnect;
import com.blogspot.mikelaud.ibl.task.call.contract_details.CallReqContractDetails;
import com.ib.client.Contract;

public class Program implements Callable<Object> {

	private ConnectionContext mContext;
	
	@Override
	public Object call() throws Exception {
		//
		CallConnect callConnect = new CallConnect
		(	mContext
		,	Config.getHost()
		,	Config.getPort()
		,	Config.getClientId()
		);
		callConnect.getCommand().setTimeout(10, TimeUnit.SECONDS);
		callConnect.call();
		/*
		Contract contract = new Contract();
		{
			contract.m_exchange = "SMART";
			contract.m_currency = "USD";
			contract.m_secType = "STK";
			contract.m_symbol = "JPM";
		}
		CallReqContractDetails.In contractIn = new CallReqContractDetails.In
		(	1
		,	contract
		);
		CallReqContractDetails reqContractDetails = new CallReqContractDetails
		(	mContext
		,	contractIn
		);
		reqContractDetails.getCommand().setTimeout(3, TimeUnit.SECONDS);
		reqContractDetails.call();
		*/
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
