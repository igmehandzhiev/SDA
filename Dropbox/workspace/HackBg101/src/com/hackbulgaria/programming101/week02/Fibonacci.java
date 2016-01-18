package com.hackbulgaria.programming101.week02;

public class Fibonacci {
	public static String fibNumber(int n) {
		String str = "";
		for (int i = 1; i <= n; ++i) {
			str += fibRecursion(i);
		}
		return str;
	}

	public static int fibRecursion(int n) {
		if (n == 1 || n == 2)
			return 1;
		return fibRecursion(n - 1) + fibRecursion(n - 2);
	}

	public static void main(String args[]) {
		System.out.println(fibNumber(3));
	}
}
