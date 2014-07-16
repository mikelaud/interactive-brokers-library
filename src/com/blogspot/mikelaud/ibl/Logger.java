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

	public static void logEvent(final String aMessage) {
		System.out.println(String.format("EVENT: %s", aMessage));
	}

	public static void logCall(final String aMessage) {
		System.out.println(String.format("CALL: %s", aMessage));
	}

	public static void logCommandBegin(final String aMessage) {
		System.out.println(String.format("CMD>: %s", aMessage));
	}

	public static void logCommandEnd(final String aMessage) {
		System.out.println(String.format("CMD<: %s", aMessage));
	}

	//------------------------------------------------------------------------

	public static void logError(final String aMessage) {
		System.out.println(String.format("ERROR: %s", aMessage));
	}
	
	public static void logWarning(final String aMessage) {
		System.out.println(String.format("WARNING: %s", aMessage));
	}
	
	public static void logInfo(final String aMessage) {
		System.out.println(String.format("INFO: %s", aMessage));
	}
	
	public static void logDebug(final String aMessage) {
		System.out.println(String.format("DEBUG: %s", aMessage));
	}
	
}
