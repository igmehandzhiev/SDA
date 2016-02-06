package sda.project;

import java.util.Scanner;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws WrongExpression {
		MiniMathematica mm = new MiniMathematica();
		Scanner input;
		input = new Scanner(System.in);
		final String expression = input.nextLine();
		System.out.println(mm.calculate(expression));
	}
}