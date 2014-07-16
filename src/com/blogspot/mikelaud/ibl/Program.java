package com.blogspot.mikelaud.nyse;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import com.blogspot.mikelaud.nyse.connection.ConnectionContext;
import com.blogspot.mikelaud.nyse.task.Task;
import com.blogspot.mikelaud.nyse.task.call.connection_and_server.CallConnect;
import com.blogspot.mikelaud.nyse.task.call.connection_and_server.CallDisconnect;
import com.blogspot.mikelaud.nyse.task.call.connection_and_server.CallReqCurrentTime;
import com.blogspot.mikelaud.nyse.task.call.contract_details.CallReqContractDetails;
import com.blogspot.mikelaud.nyse.task.call.other.CallSleep;
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
		CallReqContractDetails.Info contractInfo = new CallReqContractDetails.Info(0, contract);
		mContext.onTask(new CallReqContractDetails(mContext, contractInfo).getCommand(10, TimeUnit.SECONDS));
		//
		mContext.onTask(new CallReqCurrentTime(mContext).getCommand(10, TimeUnit.SECONDS));
		//
		//new CallDisconnect(mContext).callCommand();
		//new CallDisconnect(mContext).callCommand();

		/*
		new CallSleep(mContext, new CallSleep.Info(3, TimeUnit.SECONDS)).call();
		mContext.onTask(new CallServerVersion(mContext));
		//
		new CallSleep(mContext, new CallSleep.Info(1, TimeUnit.SECONDS)).call();
		mContext.onTask(new CallTwsConnectionTime(mContext));
		//
		new CallSleep(mContext, new CallSleep.Info(1, TimeUnit.SECONDS)).call();
		mContext.onTask(new CallReqCurrentTime(mContext));
		//
		TestCommand testCommand = new TestCommand(mContext, 1);
		mContext.onTask(testCommand);
		*/
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
