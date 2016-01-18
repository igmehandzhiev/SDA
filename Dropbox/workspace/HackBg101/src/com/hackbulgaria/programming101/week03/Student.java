package com.hackbulgaria.programming101.week03;

public class Student implements Comparable<Student> {
	private String name;
	private int grade;

	public Student(String name, int grade) {
		this.grade = grade;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public int compareTo(Student other) {
		if (this.grade == other.getGrade())
			return this.getName().compareTo(other.getName());
		if (this.grade < other.getGrade())
			return -1;
		else
			return 1;
	}
}
