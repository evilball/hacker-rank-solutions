package com.videodemons.javapractice;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingValleys {

	// Complete the countingValleys function below.
	static int countingValleys(int n, String s) {
		char[] path = s.toCharArray();
		int pos = 0;
		int valleys = 0;
		for (char c : path) {
			if (c == 'D') {
				if (pos == 0) {
					valleys++;
				}
				pos--;
			} else {
				pos++;
			}
		}
		return valleys;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();

		int result = countingValleys(n, s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}