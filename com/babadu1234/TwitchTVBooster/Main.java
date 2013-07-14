package com.babadu1234.TwitchTVBooster;

public class Main {

	public static final String hostAndGet = "http://www-cdn.jtvnw.net/widgets/live_facebook_embed_player.swf?channel=";
	public static String twitchUsername = "";
	public static int numberOfViews = 60;

	public static void main(String[] args) {

		for (int i = 0; i < numberOfViews; i++) {
			System.out.println("Reset");
			for (int j = 0; j < i; j++) {
				ThreadViews threadViews = new ThreadViews(numberOfViews);
				Thread t = new Thread(threadViews);
				t.start();
			}
		}

	}

}
