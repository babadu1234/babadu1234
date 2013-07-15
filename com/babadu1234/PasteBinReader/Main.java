package com.babadu1234.PasteBinReader;

public class Main {

	public static void main(String[] args) {
		Getter.getLink();
		if (!Getter.pasteBinLink.isEmpty()) {
			Reader.readText();
		}
	}

}
