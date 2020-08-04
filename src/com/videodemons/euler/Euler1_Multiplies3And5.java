package com.videodemons.euler;

import java.util.Scanner;

public class Euler1_Multiplies3And5 {

	/**
	 * Find the sum of all the multiples of 3 or 5 below N
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0; i < t; i++){
			int n = in.nextInt() - 1;
			long c3 = n / 3L;
			long c5 = n / 5L;
			long c15 = n / 15L;
			long sum = (3 * c3 * (c3 + 1) +
			            5 * c5 * (c5 + 1) -
			            15 * c15 * (c15 + 1)) / 2;
			System.out.println(sum);
		}
	}
}
