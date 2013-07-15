package com.babadu1234.PasteBinReader;

import java.util.Scanner;

public class Getter {

	public static String pasteBinLink;
	public static String lastFewCharacters;

	public static Scanner in = new Scanner(System.in);

	public static void getLink() {
		System.out.println("What is the pastebin link? (Not raw)");
		pasteBinLink = in.nextLine();
		System.out.println("So it's: " + pasteBinLink);
		lastFewCharacters = pasteBinLink.substring(pasteBinLink.length() - 8);
		pasteBinLink = "http://pastebin.com/raw.php?i=" + lastFewCharacters;
	}

}
