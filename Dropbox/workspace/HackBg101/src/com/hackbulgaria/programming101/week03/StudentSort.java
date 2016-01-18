package com.hackbulgaria.programming101.week03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentSort {

	public static void sort(List<Student> list) {
		Map<Integer, String> sortM = new HashMap<>();
		int len = list.size();
		for (int i = 0; i < len; ++i) {// map fill
			sortM.put(list.get(i).getGrade(), list.get(i).getName());
		}
		List<Student> sortedL = list;
		Collections.sort(sortedL);
		for (Student p : sortedL) {
			System.out.println(p.getName() + "\t" + p.getGrade());
		}
	}

	public static void main(String[] args) {
		Student s1 = new Student("Zhivko" +
				"", 2);
		Student s2 = new Student("Georgi", 3);
		Student s3 = new Student("Stefan", 1);
		Student s4 = new Student("Stoyo", 2);
		List<Student> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		sort(list);
	}
}
