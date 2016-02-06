package com.hackbulgaria.programming101.week06;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class User {
	private enum Type {
		simple, complex
	};

	public User(String userName, int age, Integer id) {
		new BankAccount(0, 0., Type.simple);
	}

	class BankAccount {
		private Integer balance;
		private Double interest;

		public BankAccount(Integer balance, Double interest, Type type) {
			this.balance = balance;
			this.interest = interest;
		}

		public Integer getBalance() {
			return balance;
		}

		public void setBalance(Integer balance) {
			this.balance = balance;
		}

		public Double getInterest() {
			return interest;
		}

		public void setInterest(Double interest) {
			this.interest = interest;
		}

		public String getType() {
			return "type";
		}

		public void setType(Type type) {
		}
	}

	static class FooException extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public FooException() {
			super();
		}

		public FooException(String message) {
			super(message);
		}

		public FooException(String message, Throwable cause) {
			super(message, cause);
		}

		public FooException(Throwable cause) {
			super(cause);

		}
	}

	public static void main(String... args) throws IOException {
		HashMap<String, User> users = new HashMap<>();
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String name = sc.nextLine();
			if (!name.contains(" ") && !name.matches("^[0-9]")) {
				throw new FooException();
			}
			int age = sc.nextInt();
			Integer id = sc.nextInt();
			users.put(name, new User(name, age, id));
		} catch (FooException fe) {
			System.out.println("TEST");
		} catch (NumberFormatException e) {
			e.getMessage();
		}
	}
}
