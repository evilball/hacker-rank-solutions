package com.videodemons.interviewkit.dictionaries;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoStrings {

	// Complete the twoStrings function below.
	static String twoStrings(String s1, String s2) {
		Map<Character, Integer> first = toMap(s1.toCharArray());
		Map<Character, Integer> second = toMap(s2.toCharArray());
		for (Map.Entry<Character, Integer> e : first.entrySet()) {
			if (second.containsKey(e.getKey())) {
				return "YES";
			}
		}
		return "NO";
	}

	private static Map<Character, Integer> toMap(char[] chars) {
		Map<Character, Integer> map = new HashMap<>();
		for (Character s : chars) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		return map;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s1 = scanner.nextLine();

			String s2 = scanner.nextLine();

			String result = twoStrings(s1, s2);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
