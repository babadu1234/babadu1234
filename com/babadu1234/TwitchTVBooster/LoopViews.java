package com.babadu1234.TwitchTVBooster;

public class LoopViews {

	public static void loopViews() {
		for (int i = 0; i < Main.numberOfViews; i++) {
			TwitchSocket.twitchSocket();
		}
		while (true)
			;
	}

}
