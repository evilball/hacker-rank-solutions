package com.videodemons.interviewkit.arrays;

import java.io.*;
import java.util.*;

public class ArrayManipulation {

	// Complete the arrayManipulation function below.
	static long arrayManipulation(int n, int[][] queries) {
		long[] arr = new long[n];
		for (int[] query : queries) {
			int left = query[0] - 1;
			int right = query[1];
			int operation = query[2];
			arr[left] += operation;
			if (right < n) {
				arr[right] -= operation;
			}
		}

		long max = Long.MIN_VALUE;
		long acc = 0;
		for (long l : arr) {
			acc += l;
			if (acc > max) {
				max = acc;
			}
		}
		return max;
	}


	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new FileReader(new File(System.getenv("INPUT_PATH"))));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		int[][] queries = new int[m][3];

		for (int i = 0; i < m; i++) {
			String[] queriesRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 3; j++) {
				int queriesItem = Integer.parseInt(queriesRowItems[j]);
				queries[i][j] = queriesItem;
			}
		}

		long result = arrayManipulation(n, queries);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
