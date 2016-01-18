package com.hackbulgaria.programming101.week02;

public class LucasSeries {
	public static int nthLucas(int n) {
		if (n == 1)
			return 1;
		if (n == 0)
			return 2;
		return nthLucas(n - 1) + nthLucas(n - 2);
	}

	public static void main(String[] args) {
		System.out.println(nthLucas(4));
	}

}
