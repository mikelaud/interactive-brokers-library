package com.blogspot.mikelaud.ibl.types;

import java.util.Objects;

public class IblString {

	public static String nvl(Object aArgument) {
		return Objects.toString(aArgument, "");
	}
		
}
