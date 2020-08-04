package com.videodemons.interviewkit.arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class MinimumBribes {

	// Complete the minimumBribes function below.
	static void minimumBribes(int[] q) {
		int countBribes = 0;
		for (int i = q.length - 1; i >= 0; i--) {
			if (q[i] - i >= 4) {
				System.out.println("Too chaotic");
				return;
			}
			for (int j = Math.max(0, q[i] - 2); j < i; j++)
				if (q[j] > q[i]) {
					countBribes++;
				}
		}
		System.out.println(countBribes);
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new FileReader(new File(System.getenv("INPUT_PATH"))));
		int t = scanner.nextInt();
		
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
		}

		scanner.close();
	}
}
