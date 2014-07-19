package com.blogspot.mikelaud.ibl.task.event.market_depth;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;

/**
 * This event is called when the Level II market depth changes.
 */
public class OnUpdateMktDepthL2
	extends EventTaskEx<OnUpdateMktDepthL2.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The ticker Id that was specified previously 
		 * in the call to CallReqMktDepth.
		 */
		public final int TICKER_ID;
		/**
		 * Specifies the row id of this market depth entry.
		 */
		public final int POSITION;
		/**
		 * Specifies the exchange hosting this order.
		 */
		public final String MARKET_MAKER;
		/**
		 * Identifies the how this order should be applied
		 * to the market depth. Valid values are:
		 *     0 = insert (insert this new order into the row
		 *                 identified by 'position')·
		 *     1 = update (update the existing order in the row
		 *                 identified by 'position')·
		 *     2 = delete (delete the existing order at the row
		 *                 identified by 'position').
		 */
		public final int OPERATION;
		/**
		 * Identifies the side of the book that this order belongs to.
		 * Valid values are:
		 *     0 = ask
		 *     1 = bid
		 */
		public final int SIDE;
		/**
		 * The order price.
		 */
		public final double PRICE;
		/**
		 * The order size.
		 */
		public final int SIZE;
		
		public Info
		(	int aTickerId
		,	int aPosition
		,	String aMarketMaker
		,	int aOperation
		,	int aSide
		,	double aPrice
		,	int aSize
		) {
			TICKER_ID = aTickerId;
			POSITION = aPosition;
			MARKET_MAKER = aMarketMaker;
			OPERATION = aOperation;
			SIDE = aSide;
			PRICE = aPrice;
			SIZE = aSize;
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
		(	"%s[%d] { position=\"%d\" marketMaker=\"%s\" operation=\"%d\" side=\"%d\" price=\"%f\" size=\"%d\" }"
		,	super.toString()
		,	INFO.TICKER_ID
		,	INFO.POSITION
		,	INFO.MARKET_MAKER
		,	INFO.OPERATION
		,	INFO.SIDE
		,	INFO.PRICE
		,	INFO.SIZE
		);
	}
	
	public OnUpdateMktDepthL2(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, new TaskInnerObject(){});
	}

}
