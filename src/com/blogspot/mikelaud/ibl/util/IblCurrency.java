package com.blogspot.mikelaud.ibl.util;

public enum IblCurrency {

	USD("USD");
	
	private String mName;
	
	public String getName() {
		return mName;
	}
	
	private IblCurrency(String aName) {
		mName = aName;
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
}
