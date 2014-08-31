package com.blogspot.mikelaud.ibl;

import com.blogspot.mikelaud.ibl.types.IblString;

public class Main {

	public static void main(String[] args) {
		try {
			Program program = new Program();
			program.call();
		}
		catch (Throwable t) {
			Logger.logError(IblString.nvl(t.getMessage()));
		}
		finally {
			Logger.println("Done.");
		}
	}

}
