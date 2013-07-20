package com.babadu1234.TextReader;

import java.io.File;
import java.util.Scanner;

public class InputScanner {

	public static void textParser() {
		File inputFile = new File("Input.txt");
		try {
			Scanner scanner = new Scanner(inputFile);
			int numberOfQuestions = Integer.parseInt(scanner.next());
			for (int i = 1; i <= numberOfQuestions; i++) {
				int firstInt = Integer.parseInt(scanner.next());
				String operationSign = scanner.next();
				int secondInt = Integer.parseInt(scanner.next());
				if (operationSign.contains("+")) {
					int answer = firstInt + secondInt;
					System.out.println("Equation " + i + " : " + firstInt
							+ " + " + secondInt + " = " + answer);
				} else if (operationSign.contains("-")) {
					int answer = firstInt - secondInt;
					System.out.println("Equation " + i + " : " + firstInt
							+ " - " + secondInt + " = " + answer);
				} else if (operationSign.contains("/")) {
					int answer = firstInt / secondInt;
					System.out.println("Equation " + i + " : " + firstInt
							+ " / " + secondInt + " = " + answer);
				} else if (operationSign.contains("*")) {
					int answer = firstInt * secondInt;
					System.out.println("Equation " + i + " : " + firstInt
							+ " * " + secondInt + " = " + answer);
				} else if (operationSign.contains("%")) {
					int answer = firstInt % secondInt;
					System.out.println("Equation " + i + " : " + firstInt
							+ " % " + secondInt + " = " + answer);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
