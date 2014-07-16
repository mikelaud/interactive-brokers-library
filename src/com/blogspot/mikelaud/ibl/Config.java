package com.blogspot.mikelaud.nyse;

public class Config {

	private static final int HISTORICAL_PERIOD_SEC = 11; 
	private static final String HOST = "";
	private static final int PORT = 7496;
	private static final int CLIENT_ID = 0; 
	private static final String FILE_EXTENSION = "nyse";
	private static final String FILES_DIRECTORY = "data";	
	
	public static int getHistoricalPeriodSec() { return HISTORICAL_PERIOD_SEC; }
	public static String getHost() { return HOST; }
	public static int getPort() { return PORT; }	
	public static int getClientId() { return CLIENT_ID; }
	public static String getFileExtension() { return FILE_EXTENSION; }
	public static String getFilesDirectory() { return FILES_DIRECTORY; }
	
}
