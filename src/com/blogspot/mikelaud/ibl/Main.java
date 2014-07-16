package com.blogspot.mikelaud.ibl;


public class Main {

	public static void main(String[] args) {
		try {
			Program program = new Program();
			program.call();
		}
		catch (Throwable t) {
			t.printStackTrace(Logger.getStream());
		}
		finally {
			Logger.println("Done.");
		}
	}

}
