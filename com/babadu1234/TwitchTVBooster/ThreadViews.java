package com.babadu1234.TwitchTVBooster;

public class ThreadViews implements Runnable {

	private int var;

	public ThreadViews(int var) {
		this.var = var;
	}

	@Override
	public void run() {
		StreamWatcher.downloadStream();
	}

}
