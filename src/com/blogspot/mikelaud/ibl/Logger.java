package com.blogspot.mikelaud.ibl;

public class Logger {

	public static void print(final String aMessage) {
		System.out.print(aMessage);
	}
	
	public static void println(final String aMessage) {
		System.out.println(aMessage);
	}
	
	//------------------------------------------------------------------------

	private static void log(final String aMessage) {
		long currentTimeSec = System.currentTimeMillis() / 1000;
		String currentDate = Config.getLocalTimeZone().toDate(currentTimeSec);
		System.out.println(String.format("%s %s", currentDate, aMessage));
	}
	
	public static void logEvent(final int aRequestId, final String aMessage) {
		log(String.format("EVNT: [%d]%s", aRequestId, aMessage));
	}

	public static void logHist(final int aRequestId, final String aMessage) {
		log(String.format("HIST: [%d]%s", aRequestId, aMessage));
	}

	public static void logLost(final int aRequestId, final String aMessage) {
		log(String.format("LOST: [%d]%s", aRequestId, aMessage));
	}

	public static void logCall(final int aRequestId, final String aMessage) {
		log(String.format("CALL: [%d]%s", aRequestId, aMessage));
	}

	public static void logCommandBegin(final int aRequestId, final String aMessage) {
		log(String.format("CMD>: [%d]%s", aRequestId, aMessage));
	}

	public static void logCommandEnd(final int aRequestId, final String aMessage) {
		log(String.format("CMD<: [%d]%s", aRequestId, aMessage));
	}

	//------------------------------------------------------------------------

	public static void logError(final String aMessage) {
		log(String.format("ERRR: %s", aMessage));
	}
	
	public static void logWarning(final String aMessage) {
		log(String.format("WARN: %s", aMessage));
	}

	public static void logDebug(final String aMessage) {
		log(String.format("DEBG: %s", aMessage));
	}
	
}
