package com.hackbulgaria.programming101.week06;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FunnyArraySorter {
	private Integer pivot;

	public FunnyArraySorter(Integer pivot) {
		this.pivot = pivot;
	}

	interface Sort {
		public LinkedList<Integer> funnySort(LinkedList<Integer> listToSort);
	}

	public LinkedList<Integer> reverseSort(List<Integer> list) {
		LinkedList<Integer> ls = new LinkedList<>();
		Sort reverseSort = new Sort() {
			LinkedList<Integer> sortedList = new LinkedList<>();

			@Override
			public LinkedList<Integer> funnySort(LinkedList<Integer> listToSort) {
				Collections.sort(listToSort);
				int len = listToSort.size();
				for (int i = len - 1; i >= 0; i--) {
					sortedList.add(listToSort.get(i));
					System.out.println(sortedList.get(len - i - 1));
				}
				return sortedList;
			}
		};
		ls = reverseSort.funnySort((LinkedList<Integer>) list);
		return ls;
	}

	public LinkedList<Integer> pivotSubstractionSort(List<Integer> list) {
		LinkedList<Integer> sortedList = new LinkedList<>();
		Sort pivotSort = new Sort() {
			@Override
			public LinkedList<Integer> funnySort(LinkedList<Integer> listToSort) {
				LinkedList<Integer> ls = new LinkedList<>();
				int len = listToSort.size();
				int lenJ = len;
				for (int i = 0; i < len - 1; ++i) {
					int min = listToSort.get(i);
					for (int j = i; j < lenJ; ++j) {
						if (isGreater(min, listToSort.get(j))) {
							int temp = min;
							min = listToSort.get(j);
							listToSort.set(i, min);
							listToSort.set(j, temp);
						}
					}
					ls.add(min);
					System.out.println(ls.get(i));
				}
				return ls;
			}

			public boolean isGreater(Integer a, Integer b) {
				if (a - pivot > b)
					return true;
				else
					return false;
			}
		};
		sortedList = pivotSort.funnySort((LinkedList<Integer>) list);
		return sortedList;
	}

	public LinkedList<Integer> pivotDivisonSort(List<Integer> list) {
		LinkedList<Integer> sortedList = new LinkedList<>();
		Sort pivotSort = new Sort() {
			@Override
			public LinkedList<Integer> funnySort(LinkedList<Integer> listToSort) {
				LinkedList<Integer> ls = new LinkedList<>();
				int len = listToSort.size();
				int lenJ = len;
				for (int i = 0; i < len - 1; ++i) {
					int min = listToSort.get(i);
					for (int j = i; j < lenJ; ++j) {
						if (isGreater(min, listToSort.get(j))) {
							int temp = min;
							min = listToSort.get(j);
							listToSort.set(i, min);
							listToSort.set(j, temp);
						}
					}
					ls.add(min);
					System.out.println(ls.get(i));
				}
				return ls;
			}

			public boolean isGreater(Integer a, Integer b) {
				if (a / pivot > b)
					return true;
				else
					return false;
			}
		};
		sortedList = pivotSort.funnySort((LinkedList<Integer>) list);
		return sortedList;
	}

	public static void main(String... args) {
		FunnyArraySorter fas = new FunnyArraySorter(10);
		LinkedList<Integer> ls = new LinkedList<>();
		ls.add(5);
		ls.add(15);
		ls.add(55);
		ls.add(1445);
		ls.add(5155);
		ls.add(1);
		ls.add(555);
		// fas.reverseSort(ls);
		fas.pivotSubstractionSort(ls);
		fas.pivotDivisonSort(ls);
	}
}
