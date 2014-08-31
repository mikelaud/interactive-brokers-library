package com.blogspot.mikelaud.ibl;

import com.blogspot.mikelaud.ibl.types.IblTimeZone;

public class Config {

	//========================================================================
	private static final String HOST = "";
	private static final int PORT = 7496;
	private static final int CLIENT_ID = 0;
	//------------------------------------------------------------------------
	private static final int NO_REQUEST_ID = -1;
	private static final String HISTORICAL_DATA_END_PREFIX = "finished-";
	private static final int DEFAULT_TIMEOUT_SEC = 11;
	private static final IblTimeZone LOCAL_TIME_ZONE = IblTimeZone.MOSCOW;
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
	public static String getHistoricalDataEndPrefix() { return HISTORICAL_DATA_END_PREFIX; }
	public static int getDefaultTimeoutSec() { return DEFAULT_TIMEOUT_SEC; }
	public static IblTimeZone getLocalTimeZone() { return LOCAL_TIME_ZONE; }
	//------------------------------------------------------------------------
	public static int getHistoricalPeriodSec() { return HISTORICAL_PERIOD_SEC; }
	public static String getFileExtension() { return FILE_EXTENSION; }
	public static String getFilesDirectory() { return FILES_DIRECTORY; }
	//========================================================================
	
}
