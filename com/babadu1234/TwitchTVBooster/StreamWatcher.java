package com.babadu1234.TwitchTVBooster;

import java.io.InputStream;
import java.net.URL;

public class StreamWatcher {

	public static String parsedIp;
	public static String parsedPort;

	public static void downloadStream() {
		try {
			for (int i = 0; i < 20; i++) {
				System.setProperty("http.proxyHost", "");
				System.setProperty("http.proxyPort", "");
				URL twitchURL = new URL(Main.hostAndGet + Main.twitchUsername);
				InputStream inStreamVideo = twitchURL.openStream();
				System.out.println("Reached");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
