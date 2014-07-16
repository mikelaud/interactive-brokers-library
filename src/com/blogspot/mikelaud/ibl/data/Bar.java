package com.blogspot.mikelaud.ibl.data;

import java.nio.ByteBuffer;

public class Bar {

	private static final int BUFFER_SIZE_B = 4 * Double.BYTES + 2 * Integer.BYTES;
	
	private double mOpen;
	private double mClose;
	//
	private double mHigh;
	private double mLow;
	//
	private int mVolume;
	private int mCount; // also: bar existing flag
	
	public void reset() {
		mOpen = 0.0;
		mClose = 0.0;
		//
		mHigh = 0.0;
		mLow = 0.0;
		//
		mVolume = 0;
		mCount = 0;
		//
		setNotExists();
	}
	
	public void readBuffer(ByteBuffer aBuffer) {
		mOpen = aBuffer.getDouble();
		mClose = aBuffer.getDouble();
		//
		mHigh = aBuffer.getDouble();
		mLow = aBuffer.getDouble();
		//
		mVolume = aBuffer.getInt();
		mCount = aBuffer.getInt();
	}
	
	public void writeBuffer(ByteBuffer aBuffer) {
		aBuffer.putDouble(mOpen);
		aBuffer.putDouble(mClose);
		//
		aBuffer.putDouble(mHigh);
		aBuffer.putDouble(mLow);
		//
		aBuffer.putInt(mVolume);
		aBuffer.putInt(mCount);
	}
	
	public boolean exists() { return (mCount >= 0); }
	public boolean notExists() { return (mCount < 0); }
	
	public void setExists() { mCount = 0; }
	public void setNotExists() { mCount = -1; }
	
	//------------------------------------------------------------------------
	
	public static int getBufferSizeB() { return BUFFER_SIZE_B; }
	
	public double getOpen() { return mOpen; }
	public void setOpen(double aOpen) { mOpen = aOpen; }
	
	public double getClose() { return mClose; }
	public void setClose(double aClose) { mClose = aClose; }

	public double getHigh() { return mHigh; }
	public void setHigh(double aHigh) { mHigh = aHigh; }
	
	public double getLow() { return mLow; }
	public void setLow(double aLow) { mLow = aLow; }

	public int getVolume() { return mVolume; }
	public void setVolume(int aVolume) { mVolume = aVolume; }

	public int getCount() { return mCount; }
	public void setCount(int aCount) { mCount = aCount; }
		
	//------------------------------------------------------------------------
	
	public Bar() {
		reset();
	}
	
}
