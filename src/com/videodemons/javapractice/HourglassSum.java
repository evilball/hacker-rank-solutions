package com.videodemons.javapractice;

import java.io.*;
import java.util.*;

public class HourglassSum {

	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = 0; j < arr.length - 2; j++) {
				int sum = calculate(arr, i, j);
				if (sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}

	private static int calculate(int[][] arr, int i, int j) {
		System.out.print(arr[i][j] + " ");
		System.out.print(arr[i + 1][j] + " ");
		System.out.println(arr[i + 2][j]);
		System.out.print("   " + arr[i + 1][j + 1] + "   ");
		System.out.println(arr[i ][j]);
		System.out.println(arr[i][j]);
		return arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 1][j + 1] + arr[i][j + 2] + arr[i + 1][j + 2] + arr[i + 2][j + 2];
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int[][] arr = new int[6][6];

		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}

		int result = hourglassSum(arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
