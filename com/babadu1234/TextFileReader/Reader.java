package com.babadu1234.TextFileReader;

import java.io.BufferedReader;
import java.io.FileReader;

public class Reader {

	public static void textReader() {
		try {
			Variables.fileName = new FileReader("C:/Users/Jon/fileName.txt");
			Variables.reader = new BufferedReader(Variables.fileName);
			Variables.currentLine = Variables.reader.readLine();
			while (Variables.currentLine != null) {
				System.out.println(Variables.currentLine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
