package com.blogspot.mikelaud.ibl.test_file;

import java.nio.ByteBuffer;

public class Day {

	private static final int BARS_COUNT = 390;
	private static final int BUFFER_SIZE_B = BARS_COUNT * Bar.getBufferSizeB() + Integer.BYTES;
	
	private Bar[] mBars;
	private int mExistingBarsCount; // also: day existing flag
	
	public void reset() {
		for (int i = 0; i < BARS_COUNT; i++) {
			mBars[i].reset();
		}
		mExistingBarsCount = 0;
		//
		setNotExists();
	}
	
	public void readBuffer(ByteBuffer aBuffer) {
		for (int i = 0; i < BARS_COUNT; i++) {
			mBars[i].readBuffer(aBuffer);
		}
		mExistingBarsCount = aBuffer.getInt();
	}
	
	public void writeBuffer(ByteBuffer aBuffer) {
		for (int i = 0; i < BARS_COUNT; i++) {
			mBars[i].writeBuffer(aBuffer);
		}
		aBuffer.putInt(mExistingBarsCount);
	}
	
	public boolean exists() { return (mExistingBarsCount >= 0); }
	public boolean notExists() { return (mExistingBarsCount < 0); }
	
	public void setExists() { mExistingBarsCount = 0; }
	public void setNotExists() { mExistingBarsCount = -1; }
	
	//------------------------------------------------------------------------
	
	public static int getBarsCount() { return BARS_COUNT;  }
	public static int getBufferSizeB() { return BUFFER_SIZE_B;  }
	
	public Bar[] getBars() { return mBars; }
	
	public int getExistingBarsCount() { return mExistingBarsCount; }
	public void setExistingBarsCount(int aCount) { mExistingBarsCount = aCount; }
	
	//------------------------------------------------------------------------
	
	public Day() {
		mBars = new Bar[BARS_COUNT];
		for (int i = 0; i < BARS_COUNT; i++) {
			mBars[i] = new Bar();
		}
		reset();
	}
	
}
