package com.babadu1234.TwitchTVBooster;

public class LoopViews {

	public static void loopViews() {
		for (int i = 0; i < Main.numberOfViews; i++) {
			for (int j = 0; j < i; j++) {
				TwitchSocket.twitchSocket();
				System.out.println("Viewing..");
			}
		}
	}

}
