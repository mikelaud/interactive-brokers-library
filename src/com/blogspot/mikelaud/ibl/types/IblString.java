package com.blogspot.mikelaud.ibl.types;

public class IblString {

	public static String nvl(String aString) {
		return (null == aString ? "" : aString);
	}
	
	public static String nvl(Object aArgument) {
		return (null == aArgument ? "" : aArgument.toString());
	}
	
}
