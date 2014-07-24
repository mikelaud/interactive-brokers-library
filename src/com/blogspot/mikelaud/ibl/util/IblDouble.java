package com.blogspot.mikelaud.ibl.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class IblDouble {

	private static DecimalFormat DECIMAL_FORMAT = createDecimalFormat();
	
	private static DecimalFormat createDecimalFormat() {
		DecimalFormat decimalFormat = new DecimalFormat(".##");
		decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
		return decimalFormat; 
	}
	
	public static String toString(double aDouble) {
		return DECIMAL_FORMAT.format(aDouble);
	}
	
}
