package com.blogspot.mikelaud.ibl.task.event.market_data;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.event.EventTaskEx;

/**
 * This event is called when the market in an option or its underlier moves.
 * TWS’s option model volatilities, prices, and deltas,
 * along with the present value of dividends expected
 * on that options underlier are received.
 */
public class OnTickOptionComputation
	extends EventTaskEx<OnTickOptionComputation.Info>
{
	//------------------------------------------------------------------------
	public static class Info {
	
		/**
		 * The ticker Id that was specified previously
		 * in the call to CallReqMktData.
		 */
		public final int REQ_ID;
		/**
		 * Specifies the type of option computation.
		 * Pass the field value into TickType.getField(int tickType)
		 * to retrieve the field description.
		 * For example, a field value of 13 will map to modelOptComp, etc.
		 *     10 = Bid
		 *     11 = Ask
		 *     12 = Last
		 */
		public final int FIELD;
		/**
		 * The implied volatility calculated by the TWS option modeler,
		 * using the specified ticktype value.
		 */
		public final double IMPLIED_VOL;
		/**
		 * The option delta value.
		 */
		public final double DELTA;
		/**
		 * The option price.
		 */
		public final double OPT_PRICE;
		/**
		 * The present value of dividends expected on the options underlier.
		 */
		public final double PV_DIVIDEND;
		/**
		 * The option gamma value.
		 */
		public final double GAMMA;
		/**
		 * The option vega value.
		 */
		public final double VEGA;
		/**
		 * The option theta value.
		 */
		public final double THETA;
		/**
		 * The price of the underlying.
		 */
		public final double UND_PRICE;
		
		public Info
		(	int aReqId
		,	int aField
		,	double aImpliedVol
		,	double aDelta
		,	double aOptPrice
		,	double aPvDividend
		,	double aGamma
		,	double aVega
		,	double aTheta
		,	double aUndPrice
		) {
			REQ_ID = aReqId;
			FIELD = aField;
			IMPLIED_VOL = aImpliedVol;
			DELTA = aDelta;
			OPT_PRICE = aOptPrice;
			PV_DIVIDEND = aPvDividend;
			GAMMA = aGamma;
			VEGA = aVega;
			THETA = aTheta;
			UND_PRICE = aUndPrice;
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
		(	"%s { field=\"%d\" impliedVol=\"%f\" delta=\"%f\" optPrice=\"%f\" pvDividend=\"%f\" gamma=\"%f\" vega=\"%f\" theta=\"%f\" undPrice=\"%f\" }"
		,	super.toString()
		,	INFO.FIELD
		,	INFO.IMPLIED_VOL
		,	INFO.DELTA
		,	INFO.OPT_PRICE
		,	INFO.PV_DIVIDEND
		,	INFO.GAMMA
		,	INFO.VEGA
		,	INFO.THETA
		,	INFO.UND_PRICE
		);
	}
	
	public OnTickOptionComputation(ConnectionContext aContext, Info aInfo) {
		super(aContext, aInfo, new TaskInnerObject(){});
	}

}
