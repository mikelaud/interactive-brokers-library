package com.blogspot.mikelaud.ibl.task.call.contract_details;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.out.OutEvents;
import com.blogspot.mikelaud.ibl.out.OutTerminator;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.blogspot.mikelaud.ibl.task.event.contract_details.OnBondContractDetails;
import com.blogspot.mikelaud.ibl.task.event.contract_details.OnContractDetails;
import com.blogspot.mikelaud.ibl.task.event.contract_details.OnContractDetailsEnd;
import com.blogspot.mikelaud.ibl.util.IblCurrency;
import com.blogspot.mikelaud.ibl.util.IblString;
import com.ib.client.Contract;

/**
 * Call this call to download all details for a particular contract.
 * The contract details will be received
 * via the OnContractDetails method on the EWrapper.
 */
public class CallReqContractDetails
	extends CallTaskEx<CallReqContractDetails.In>
{
	/**
	 * The ID of the data request. Ensures that responses are matched
	 * to requests if several requests are in process.
	 */
	@Override
	public boolean hasRequestId() {
		return true;
	}
	//------------------------------------------------------------------------
	public static class In {
	
		/**
		 * This class contains attributes used to describe the contract.
		 */
		public final Contract CONTRACT;
		
		public In(Contract aContract) {
			CONTRACT = aContract;
		}
		
	}
	//------------------------------------------------------------------------

	public final OutEvents<OnContractDetails> OUT_CONTRACT_DETAILS;
	public final OutEvents<OnBondContractDetails> OUT_BOND_CONTRACT_DETAILS;
	public final OutTerminator<OnContractDetailsEnd> OUT_CONTRACT_DETAILS_END;
	
	//------------------------------------------------------------------------
	
	@Override
	protected Task onCall() throws Exception {
		getClientSocket().reqContractDetails
		(	getRequestId()
		,	IN.CONTRACT
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s { \"%s/%s/%s/%s/%s\" }"
		,	super.toString()
		,	IblString.nvl(IN.CONTRACT.m_symbol)
		,	IblString.nvl(IN.CONTRACT.m_secType)
		,	IblString.nvl(IN.CONTRACT.m_currency)
		,	IblString.nvl(IN.CONTRACT.m_exchange)
		,	IblString.nvl(IN.CONTRACT.m_primaryExch)
		);
	}

	public CallReqContractDetails(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
		OUT_CONTRACT_DETAILS = new OutEvents<>(this, OnContractDetails.class);
		OUT_BOND_CONTRACT_DETAILS = new OutEvents<>(this, OnBondContractDetails.class);
		OUT_CONTRACT_DETAILS_END = new OutTerminator<>(this, OnContractDetailsEnd.class);
	}

	public CallReqContractDetails
	(	ConnectionContext aContext
	,	Contract aContract
	) {
		this(aContext, new In(aContract));
	}

	public CallReqContractDetails
	(	ConnectionContext aContext
	,	String aSymbol
	,	String aSecurityType
	,	String aExchange
	,	String aPrimaryExchange
	) {
		this(aContext, new Contract());
		IN.CONTRACT.m_symbol = IblString.nvl(aSymbol);
		IN.CONTRACT.m_secType = IblString.nvl(aSecurityType);
		IN.CONTRACT.m_currency = IblCurrency.USD.toString();
		IN.CONTRACT.m_exchange = IblString.nvl(aExchange);
		IN.CONTRACT.m_primaryExch = IblString.nvl(aPrimaryExchange);
	}

}
