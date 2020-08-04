package com.videodemons.interviewkit.dictionaries;

import java.util.*;

public class CheckMagazine {

	// Complete the checkMagazine function below.
	static void checkMagazine(String[] magazine, String[] note) {
		Map<String, Integer> m = toMap(magazine);
		Map<String, Integer> n = toMap(note);
		for (Map.Entry<String, Integer> e : n.entrySet()) {
			if (m.containsKey(e.getKey())) {
				if (m.get(e.getKey()) < e.getValue()) {
					System.out.println("No");
					return;
				}
			} else {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
	}

	private static Map<String, Integer> toMap(String[] magazine) {
		Map<String, Integer> map = new HashMap<>();
		for (String s : magazine) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		return map;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] mn = scanner.nextLine().split(" ");

		int m = Integer.parseInt(mn[0]);

		int n = Integer.parseInt(mn[1]);

		String[] magazine = new String[m];

		String[] magazineItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		String[] note = new String[n];

		String[] noteItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		checkMagazine(magazine, note);

		scanner.close();
	}
}

