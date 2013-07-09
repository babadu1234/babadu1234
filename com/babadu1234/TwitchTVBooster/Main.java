package com.babadu1234.TwitchTVBooster;

public class Main {

	public static final String hostAndGet = "http://www-cdn.jtvnw.net/widgets/live_facebook_embed_player.swf?channel=";
	public static String twitchUsername = "propels";
	public static int numberOfViews = 60;

	public static void main(String[] args) {
		ThreadViews threadViews = new ThreadViews(numberOfViews);
		Thread t = new Thread(threadViews);
		t.start();
	}

}
