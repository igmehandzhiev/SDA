package com.hackbulgaria.programming101.week02;

public class MaxEqualConsecutive {
	public static int maxEqualConsec(int[] items) {
		int len = items.length;
		int max = 1;
		int tempMax = 1;
		for (int i = 0; i < len - 1; i++) {
			if (items[i] == items[i + 1]) {
				tempMax++;
				if (tempMax > max) {
					max = tempMax;
				}
			} else
				tempMax = 1;
		}
		return max;
	}

	public static int maxIncreasingEqualConsec(int[] items) {
		int len = items.length;
		int max = 1;
		int tempMax = 1;
		for (int i = 0; i < len - 1; i++) {
			if (items[i] <= items[i + 1]) {
				tempMax++;
				if (tempMax > max) {
					max = tempMax;
				}
			} else
				tempMax = 1;
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 3, 3, 4, 3, 3 };
		System.out.println(maxIncreasingEqualConsec(arr));
	}

}
