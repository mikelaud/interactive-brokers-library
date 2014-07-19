package com.blogspot.mikelaud.ibl.task.event.news_bulletins;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;

/**
 * This event is triggered for each new bulletin if the client has subscribed,
 * i.e. by calling the CallReqNewsBulletins call.
 */
public class OnUpdateNewsBulletin
	extends EventTaskEx<OnUpdateNewsBulletin.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The bulletin ID, incrementing for each new bulletin.
		 */
		public final int MSG_ID;
		/**
		 * Specifies the type of bulletin. Valid values include:
		 *     1 = Regular news bulletin
		 *     2 = Exchange no longer available for trading
		 *     3 = Exchange is available for trading
		 */
		public final int MSG_TYPE;
		/**
		 * The bulletin's message text.
		 */
		public final String MESSAGE;
		/**
		 * The exchange from which this message originated.
		 */
		public final String ORIG_EXCHANGE;
		
		public Info
		(	int aMsgId
		,	int aMsgType
		,	String aMessage
		,	String aOrigExchange
		) {
			MSG_ID = aMsgId;
			MSG_TYPE = aMsgType;
			MESSAGE = aMessage;
			ORIG_EXCHANGE = aOrigExchange;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onEvent() throws Exception {
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s(\"%s\") { msgId=\"%d\" msgType=\"%d\" origExchange=\"%s\" }"
		,	super.toString()
		,	INFO.MESSAGE
		,	INFO.MSG_ID
		,	INFO.MSG_TYPE
		,	INFO.ORIG_EXCHANGE
		);
	}
	
	public OnUpdateNewsBulletin(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, new TaskInnerObject(){});
	}

}
