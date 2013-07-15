package com.babadu1234.PasteBinReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Reader {

	public static String linkTitle;
	public static String linkText;

	public static Document doc;

	public static void readText() {
		try {
			doc = Jsoup.connect(Getter.pasteBinLink).get();
			linkTitle = doc.title();
			System.out.println("Title: " + linkTitle);
			linkText = doc.text();
			System.out.println("Text: " + linkText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
