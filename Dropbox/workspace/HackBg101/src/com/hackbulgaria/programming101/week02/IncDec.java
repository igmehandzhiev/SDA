package com.hackbulgaria.programming101.week02;

public class IncDec {
	public static boolean isIncreasing(int[] sequence) {
		int len = sequence.length;
		for (int i = 0; i < len - 1; i++) {
			if (sequence[i] > sequence[i + 1])
				return false;
		}
		return true;
	}

	public static boolean isDecreasing(int[] sequence) {
		int len = sequence.length;
		for (int i = 0; i < len - 1; i++) {
			if (sequence[i] < sequence[i + 1])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 4, 6, 6, 6, 7, 7, 8, 8 };
		System.out.println(isIncreasing(arr));
	}

}
