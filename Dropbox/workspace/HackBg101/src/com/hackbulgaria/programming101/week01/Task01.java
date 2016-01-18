package com.hackbulgaria.programming101.week01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task01 {
	boolean isOdd(int n) {
		if (n % 2 == 0)
			return false;
		return true;
	}

	static boolean isPrime(int n) {
		if (n == 1 || n == 2)
			return true;
		if (n % 2 == 0)
			return false;
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	int min(int... array) {
		int min = array[0];
		for (int i = 0; i < array.length; ++i) {
			if (array[i] < min)
				min = array[i];
		}
		return min;
	}

	int kthMin(int k, int[] arr) {
		Arrays.sort(arr);
		return arr[k];
	}

	int average(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; ++i) {
			sum += arr[i];
		}
		return sum / arr.length;
	}

	static long fac(long n) {
		long result = 1;
		while (n > 1) {
			result *= n;
			n--;
		}
		return result;
	}

	static long doubleFac(long n) {
		return fac(fac(n));
	}

	static long kthFac(int k, long n) {
		long result = fac(n);
		while (k > 1) {
			result = fac(result);
			k--;
		}
		return result;
	}

	static long getSmallestMultiple(int upperBound) {
		long result = 1;
		for (int i = 1; i < upperBound; ++i) {

			result = result * (i + 1) / evclid(result, i + 1);
		}
		return result;
	}

	private static long evclid(long m, int n) {
		while (m != n) {
			if (m > n)
				m -= n;
			else
				n -= m;
		}
		return m;
	}

	static long getLargestPalindrome(long n) {
		for (long i = n; i >= 1; --i) {
			if (palindrome(i) == true)
				return i;
		}
		return 1;
	}

	private static boolean palindrome(long n) {
		if (n < 10)
			return true;
		if (n % 10 == 0)
			return false;
		String str = String.valueOf(n);
		String cif[] = str.split("");
		int j = cif.length - 1;
		boolean pali = false;
		for (int i = 0; i < cif.length / 2; ++i) {
			if (cif[i].equals(cif[j]))
				pali = true;
			else
				pali = false;
			if (pali == false)
				return false;
			j--;
		}
		return pali;
	}

	static Map<Short, Integer> histogram(short[][] image) {
		Map<Short, Integer> hashMap = new HashMap<>();
		int iLen = image[0].length;
		int jLen = image.length;
		for (int i = 0; i < iLen; ++i) {
			for (int j = 0; j < jLen; ++j) {
				if (hashMap.containsKey(image[i][j])) {
					hashMap.put(image[i][j], hashMap.get(image[i][j]) + 1);
				} else
					hashMap.put(image[i][j], 1);
			}

		}
		return hashMap;
	}

	long pow(int a, int b) {
		long result = a;
		while (b > 1) {
			result *= a;
			b--;
		}
		return result;
	}

	static int getOddOccurrence(int... arr) {
		Arrays.sort(arr);
		int len = arr.length;
		int count = 1;
		for (int i = 0; i < len - 1; ++i) {
			if (arr[i] == arr[i + 1])
				count++;
			else {
				if (count % 2 != 0)
					return arr[i];
				count = 1;
			}
		}
		return 0;
	}

	long maximalScalarSum(int[] a, int[] b) {
		long maxScal = 0;
		int len = a.length;
		Arrays.sort(a);
		Arrays.sort(b);
		for (int i = 0; i < len; ++i) {
			maxScal += a[i] * b[i];
		}
		return maxScal;
	}

	public static int maxSpan(int[] numbers) {
		int max = 1;
		for (int i = 0; i < numbers.length; ++i) {
			int tempMax = max;
			for (int j = i + 1; j < numbers.length; ++j) {
				if (numbers[i] == numbers[j]) {
					if (j - i + 1 > tempMax)
						max = j - i + 1;
				}
			}
		}
		return max;
	}

	static boolean canBalance(int[] numbers) {
		int sum = 0;
		for (int i : numbers) {
			sum += i;
		}
		if (sum % 2 != 0)
			return false;
		sum = sum / 2;
		int iSum = 0;
		for (int i : numbers) {
			iSum += i;
			if (sum == iSum)
				return true;
			if (sum > iSum)
				return false;
			if (sum < iSum)
				continue;
		}
		return false;
	}

	static int[][] rescale(int[][] original, int newWidth, int newHeight) {
		double jLen = original[0].length;
		double iLen = original.length;
		double iRatio = (newHeight - 1) / (iLen - 1);
		double jRatio = (newWidth - 1) / (jLen - 1);
		int[][] newArr = new int[newHeight][newWidth];
		for (int i = 0; i < newHeight; ++i) {
			for (int j = 0; j < newWidth; ++j) {
				newArr[i][j] = original[(int) Math.round(i / iRatio)][(int) Math
						.round(j / jRatio)];
			}
		}
		return newArr;
	}

	public static void printArray(int matrix[][]) {
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				System.out.print(matrix[row][column] + " ");
			}
			System.out.println();
		}
	}

	static String reverseMe(String argument) {
		String str = "";
		int arLen = argument.length();
		for (int i = arLen - 1; i >= 0; --i) {
			str += argument.charAt(i);
		}
		return str;
	}

	static String reverseEachChar(String arg) {
		String[] str = arg.split(" +");
		String result = "";
		for (String string : str) {
			result += reverseMe(string)+" ";
		}
		return result;
	}

	boolean isPalindrome(String argument){
		
	}
	public static void main(String args[]) {
		// int[] arr = { 1, 2, 3, 4, 5, 1, 2, 3, 1 };
		// int[][] arr = { { 1, 2, 5 }, { 6, 4, 3 } };
		// System.out.println(histogram(arr));
		// System.out.println(canBalance(arr));
		// System.out.println(rescale(arr, 6, 4));
		System.out.println(reverseEachChar("zdrave  ite zriteli"));
	}
}
