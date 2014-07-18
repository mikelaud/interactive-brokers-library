package com.blogspot.mikelaud.ibl.test_command;

import com.blogspot.mikelaud.ibl.connection.ConnectionContext;
import com.blogspot.mikelaud.ibl.task.call.CallKind;
import com.blogspot.mikelaud.ibl.task.call.CallTask;
import com.blogspot.mikelaud.ibl.task.call.CallType;

public class CommandFactory {

	public static Command createCommand(ConnectionContext aContext, CallTask aCall) {
		Command command;
		CallType callType = aCall.getCallType();
		CallKind callKind = callType.getKind();
		switch (callKind) {
			case NOCAST:
				command = new NocastCommand(aContext, aCall);
				break;
			case UNICAST:
				command = new UnicastCommand(aContext, aCall);
				break;
			case MULTICAST:
				command = new MulticastCommand(aContext, aCall);
				break;
			default:
				command = new NopCommand(aContext, aCall);
				break;
		}
		return command;
	}
	
}
