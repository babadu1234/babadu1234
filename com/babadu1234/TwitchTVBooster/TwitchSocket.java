package com.babadu1234.TwitchTVBooster;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TwitchSocket {

	public static void twitchSocket() {
		try {
			InetAddress ia = InetAddress.getByName("www-cdn.jtvnw.net");
			Socket socket = new Socket(ia, 80); // Port for https is 443
			BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream(), "UTF8"));
			buffer.write("GET /widgets/live_facebook_embed_player.swf?channel="
					+ Main.twitchUsername + " HTTP/1.1" + "\r\n");
			buffer.write("Host: jtvnw.net" + "\r\n");
			buffer.write("Connection: keep-alive" + "\r\n");
			buffer.write("\r\n");
			buffer.flush();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			while (reader.read() != -1)
				;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
