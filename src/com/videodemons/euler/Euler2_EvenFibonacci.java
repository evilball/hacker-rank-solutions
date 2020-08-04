package com.videodemons.euler;

import java.util.Scanner;

public class Euler2_EvenFibonacci {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			long n = in.nextLong();
			long cur = 2;
			if (n == cur) {
				System.out.println(cur);
			} else if (n < cur){
				System.out.println(0);
			} else {
				long sum = 0;
				long prev1 = 1;
				long prev2 = 2;
				while (n >= cur) {
					if (cur % 2 == 0) {
						sum += cur;
					}
					cur = nextFib(prev1, prev2);
					prev1 = prev2;
					prev2 = cur;
				}
				System.out.println(sum);
			}
		}
	}

	private static long nextFib(long prev, long cur) {
		return prev + cur;
	}
}
