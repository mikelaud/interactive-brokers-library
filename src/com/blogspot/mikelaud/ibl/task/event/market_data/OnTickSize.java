package com.blogspot.mikelaud.ibl.task.event.market_data;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;

/**
 * This event is called when the market data changes.
 * Sizes are updated immediately with no delay.
 */
public class OnTickSize
	extends EventTaskEx<OnTickSize.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The ticker Id that was specified previously in the CallReqMktData.
		 */
		public final int REQ_ID;
		/**
		 * Specifies the type of price.
		 * Pass the field value into TickType.getField(int tickType)
		 * to retrieve the field description.
		 * For example, a field value of 0 will map to bidSize,
		 * a field value of 3 will map to askSize, etc.
		 *     0 = bid size
		 *     3 = ask size
		 *     5 = last size
		 *     8 = volume
		 */
		public final int FIELD;
		/**
		 * Specifies the size for the specified field.
		 */
		public final int SIZE;
		
		public Info(int aReqId, int aField, int aSize) {
			REQ_ID = aReqId;
			FIELD = aField;
			SIZE = aSize;
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
		(	"%s(%d) { field=\"%d\" }"
		,	super.toString()
		,	INFO.SIZE
		,	INFO.FIELD
		);
	}
	
	public OnTickSize(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, new TaskInnerObject(){});
	}

}
