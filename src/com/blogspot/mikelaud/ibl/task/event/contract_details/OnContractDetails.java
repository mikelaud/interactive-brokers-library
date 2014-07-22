package com.blogspot.mikelaud.ibl.task.event.contract_details;

import com.blogspot.mikelaud.ibl.Utils;
import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;
import com.ib.client.ContractDetails;

/**
 * This event is called only when CallReqContractDetails call
 * on the EClientSocket object has been called.
 */
public class OnContractDetails
	extends EventTaskEx<OnContractDetails.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The ID of the data request. Ensures that responses are matched
		 * to requests if several requests are in process.
		 */
		public final int REQ_ID;
		/**
		 * This structure contains a full description
		 * of the contract being looked up.
		 */
		public final ContractDetails CONTRACT_DETAILS;
		
		public Info(int aReqId, ContractDetails aContractDetails) {
			REQ_ID = aReqId;
			CONTRACT_DETAILS = aContractDetails;
		}
		
		public String getSymbol() {
			String str = "";
			if (null != CONTRACT_DETAILS) {
				if (null != CONTRACT_DETAILS.m_summary) {
					str = CONTRACT_DETAILS.m_summary.m_symbol;
				}
			}
			return Utils.nvl(str);
		}
		
		public String getSecurityType() {
			String str = "";
			if (null != CONTRACT_DETAILS) {
				if (null != CONTRACT_DETAILS.m_summary) {
					str = CONTRACT_DETAILS.m_summary.m_secType;
				}
			}
			return Utils.nvl(str);
		}
		
		public String getCurrency() {
			String str = "";
			if (null != CONTRACT_DETAILS) {
				if (null != CONTRACT_DETAILS.m_summary) {
					str = CONTRACT_DETAILS.m_summary.m_currency;
				}
			}
			return Utils.nvl(str);
		}
		
		public String getExchange() {
			String str = "";
			if (null != CONTRACT_DETAILS) {
				if (null != CONTRACT_DETAILS.m_summary) {
					str = CONTRACT_DETAILS.m_summary.m_exchange;
				}
			}
			return Utils.nvl(str);
		}
		
		public String getPrimaryExchange() {
			String str = "";
			if (null != CONTRACT_DETAILS) {
				if (null != CONTRACT_DETAILS.m_summary) {
					str = CONTRACT_DETAILS.m_summary.m_primaryExch;
				}
			}
			return Utils.nvl(str);
		}
		
		public String getSector() { // yes: Sector == m_industry
			String str = "";
			if (null != CONTRACT_DETAILS) {
				str = CONTRACT_DETAILS.m_industry;  
			}
			return Utils.nvl(str);
		}
		
		public String getIndustry() { // yes: Industry == m_category
			String str = "";
			if (null != CONTRACT_DETAILS) {
				str = CONTRACT_DETAILS.m_category;  
			}
			return Utils.nvl(str);
		}
		
		public String getCategory() { // yes: Category == m_subcategory
			String str = "";
			if (null != CONTRACT_DETAILS) {
				str = CONTRACT_DETAILS.m_subcategory;  
			}
			return Utils.nvl(str);
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	public int getRequestId() {
		return INFO.REQ_ID;
	}

	@Override
	protected Task onEvent() throws Exception {
		return null;
	}
		
	@Override
	public String toString() {
		return String.format
		(	"%s(\"%s/%s/%s/%s/%s\") { sector=\"%s\" industry=\"%s\" category=\"%s\" }"
		,	super.toString()
		,	INFO.getSymbol()
		,	INFO.getSecurityType()
		,	INFO.getCurrency()
		,	INFO.getExchange()
		,	INFO.getPrimaryExchange()
		,	INFO.getSector()
		,	INFO.getIndustry()
		,	INFO.getCategory()
		);
	}
	
	public OnContractDetails(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, new TaskInnerObject(){});
	}

}
