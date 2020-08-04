package com.videodemons.javapractice;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class RepeatedString {

	// Complete the repeatedString function below.
	static long repeatedString(String s, long n) {
		Pattern p = Pattern.compile("a");
		Matcher m = Pattern.compile("a").matcher(s);
		int aCount = 0;
		while (m.find()) {
			aCount++;
		}
		long totalCount = (n / s.length()) * aCount;
		long tailLen = n % s.length();
		if (tailLen > 0) {
			Matcher mTail = p.matcher(s.substring(0, (int) tailLen));
			while (mTail.find()) {
				totalCount++;
			}
		}
		return totalCount;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		long n = scanner.nextLong();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long result = repeatedString(s, n);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
