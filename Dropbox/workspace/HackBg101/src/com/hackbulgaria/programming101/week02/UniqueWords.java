package com.hackbulgaria.programming101.week02;

public class UniqueWords {
	static int uniqueWords(String[] arr) {
		int equal = 1;
		int prevEqual = 1;
		int len = arr.length;
		for (int i = 0; i < len - 1; ++i) {
			for (int j = i + 1; j < len; ++j) {
				if (arr[i].equals(arr[j]))
					equal++;
				if (equal == len)
					return 1;
			}
			if (equal > prevEqual + 1)
				equal--;
			prevEqual = equal;
		}
		return len - equal + 1;
	}

	public static void main(String[] args) {
		String[] str = { "apple", "apple", "apple", "apple" };
		System.out.println(uniqueWords(str));

	}

}
