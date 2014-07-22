package com.blogspot.mikelaud.ibl;

import java.io.PrintStream;

public class Logger {

	public static PrintStream getStream() { return System.out; }
	//
	public static PrintStream getCallStream() { return System.out; }
	public static PrintStream getEventStream() { return System.out; }
	//
	public static PrintStream getErrorStream() { return System.out; }
	public static PrintStream getWarningStream() { return System.out; }
	public static PrintStream getInfoStream() { return System.out; }
	public static PrintStream getDebugStream() { return System.out; }
	
	//------------------------------------------------------------------------
	
	public static void print(final String aMessage) {
		System.out.print(aMessage);
	}
	
	public static void println(final String aMessage) {
		System.out.println(aMessage);
	}
	
	//------------------------------------------------------------------------

	public static void logEvent(final int aRequestId, final String aMessage) {
		System.out.println(String.format("EVNT: [%d]%s", aRequestId, aMessage));
	}

	public static void logCall(final int aRequestId, final String aMessage) {
		System.out.println(String.format("CALL: [%d]%s", aRequestId, aMessage));
	}

	public static void logCommandBegin(final int aRequestId, final String aMessage) {
		System.out.println(String.format("CMD>: [%d]%s", aRequestId, aMessage));
	}

	public static void logCommandEnd(final int aRequestId, final String aMessage) {
		System.out.println(String.format("CMD<: [%d]%s", aRequestId, aMessage));
	}

	public static void logLost(final int aRequestId, final String aMessage) {
		System.out.println(String.format("LOST: [%d]%s", aRequestId, aMessage));
	}

	//------------------------------------------------------------------------

	public static void logError(final String aMessage) {
		System.out.println(String.format("ERRR: %s", aMessage));
	}
	
	public static void logWarning(final String aMessage) {
		System.out.println(String.format("WARN: %s", aMessage));
	}

	public static void logDebug(final String aMessage) {
		System.out.println(String.format("DEBG: %s", aMessage));
	}
	
}
