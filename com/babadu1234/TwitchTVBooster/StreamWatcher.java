package com.babadu1234.TwitchTVBooster;

import java.io.InputStream;
import java.net.URL;

public class StreamWatcher {

	public static void downloadStream() {
		try {
			URL twitchURL = new URL(Main.hostAndGet + Main.twitchUsername);
			InputStream inStreamVideo = twitchURL.openStream();
			System.out.println("Reached");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
