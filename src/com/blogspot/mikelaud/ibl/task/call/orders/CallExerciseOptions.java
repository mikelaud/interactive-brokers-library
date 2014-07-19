package com.blogspot.mikelaud.ibl.task.call.orders;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.Task;
import com.blogspot.mikelaud.ibl.task.TaskInnerObject;
import com.blogspot.mikelaud.ibl.task.call.CallTaskEx;
import com.ib.client.Contract;

/**
 * Call the CallExerciseOptions call to exercise options.
 * 
 * Note: SMART is not an allowed exchange in CallExerciseOptions calls,
 *       and TWS does a request for the position in question
 *       whenever any API initiated exercise or lapse is attempted.
 */
public class CallExerciseOptions
	extends CallTaskEx<CallExerciseOptions.In>
{
	//------------------------------------------------------------------------
	public static class In {
	
		/**
		 * The Id for the exercise request.
		 */
		public final int TICKER_ID;
		/**
		 * This class contains attributes used to describe the contract.
		 */
		public final Contract CONTRACT;
		/**
		 * Specifies whether to exercise the specified option
		 * or let the option lapse. Valid values are:
		 *     1 = exercise
		 *     2 = lapse
		 */
		public final int EXERCISE_ACTION;
		/**
		 * The number of contracts to be exercised.
		 */
		public final int EXERCISE_QUANTITY;
		/**
		 * For institutional orders. Specifies the IB account.
		 */
		public final String ACCOUNT;
		/**
		 * Specifies whether your setting will override the system's
		 * natural action. For example, if your action is "exercise"
		 * and the option is not in-the-money, by natural action the option
		 * would not exercise. If you have override set to "yes"
		 * the natural action would be overridden and the out-of-the money
		 * option would be exercised. Values are:
		 *     0 = do not override
		 *     1 = override
		 */
		public final int OVERRIDE;
		
		public In
		(	int aTickerId
		,	Contract aContract
		,	int aExerciseAction
		,	int aExerciseQuantity
		,	String aAccount
		,	int aOverride
		) {
			TICKER_ID = aTickerId;
			CONTRACT = aContract;
			EXERCISE_ACTION = aExerciseAction;
			EXERCISE_QUANTITY = aExerciseQuantity;
			ACCOUNT = aAccount;
			OVERRIDE = aOverride;
		}
		
	}
	//------------------------------------------------------------------------

	@Override
	protected Task onCall() throws Exception {
		getClientSocket().exerciseOptions
		(	IN.TICKER_ID
		,	IN.CONTRACT
		,	IN.EXERCISE_ACTION
		,	IN.EXERCISE_QUANTITY
		,	IN.ACCOUNT
		,	IN.OVERRIDE
		);
		return null;
	}

	@Override
	public String toString() {
		return String.format
		(	"%s[%d] { exerciseAction=\"%d\" exerciseQuantity=\"%d\" account=\"%s\" override=\"%d\" }"
		,	super.toString()
		,	IN.TICKER_ID
		,	IN.EXERCISE_ACTION
		,	IN.EXERCISE_QUANTITY
		,	IN.ACCOUNT
		,	IN.OVERRIDE
		);
	}

	public CallExerciseOptions(ConnectionContext aContext, In aIn) {
		super(aContext, aIn, new TaskInnerObject(){});
	}

	public CallExerciseOptions
	(	ConnectionContext aContext
	,	int aTickerId
	,	Contract aContract
	,	int aExerciseAction
	,	int aExerciseQuantity
	,	String aAccount
	,	int aOverride
	) {
		this(aContext, new In
		(	aTickerId
		,	aContract
		,	aExerciseAction
		,	aExerciseQuantity
		,	aAccount
		,	aOverride
		));
	}

}
