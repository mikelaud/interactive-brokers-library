package com.blogspot.mikelaud.ibl;

public class Config {

	//========================================================================
	private static final String HOST = "";
	private static final int PORT = 7496;
	private static final int CLIENT_ID = 0;
	//------------------------------------------------------------------------
	private static final int NO_REQUEST_ID = -1;
	private static final int DEFAULT_TIMEOUT_SEC = 11;
	private static final String DEFAULT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss z";
	//------------------------------------------------------------------------
	private static final int HISTORICAL_PERIOD_SEC = 11;
	private static final String FILE_EXTENSION = "nyse";
	private static final String FILES_DIRECTORY = "data";
	//========================================================================
	public static String getHost() { return HOST; }
	public static int getPort() { return PORT; }
	public static int getClientId() { return CLIENT_ID; }
	//------------------------------------------------------------------------
	public static int getNoRequestId() { return NO_REQUEST_ID; }
	public static int getDefaultTimeoutSec() { return DEFAULT_TIMEOUT_SEC; }
	public static String getDefaultTimeFormat() { return DEFAULT_TIME_FORMAT; }
	//------------------------------------------------------------------------
	public static int getHistoricalPeriodSec() { return HISTORICAL_PERIOD_SEC; }
	public static String getFileExtension() { return FILE_EXTENSION; }
	public static String getFilesDirectory() { return FILES_DIRECTORY; }
	//========================================================================
	
}
