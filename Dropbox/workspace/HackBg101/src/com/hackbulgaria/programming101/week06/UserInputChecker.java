package com.hackbulgaria.programming101.week06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputChecker {
	interface Validator {
		public boolean validate(String input);
	}

	public static boolean validatePersonName(final String name) {

		class PersonNameValidator implements Validator {
			public boolean validate(String name) {
				String regX = "^[\\p{L} .'-]+$";
				Pattern pattern = Pattern.compile(regX,
						Pattern.CASE_INSENSITIVE);
				Matcher matcher = pattern.matcher(name);
				return matcher.find();
			}
		}
		PersonNameValidator pnv = new PersonNameValidator();
		return pnv.validate(name);
	}

	public static boolean validatePhoneNumber(String number) {

		class PhoneNumberValidator implements Validator {
			public boolean validate(String number) {
				String regX = "[0-9]*";
				int len = number.length();
				if (number.charAt(0) == '+' && len == 13
						&& number.substring(1).matches(regX))
					return true;
				else
					return false;
			}
		}
		PhoneNumberValidator pnv = new PhoneNumberValidator();
		return pnv.validate(number);
	}

	public static void main(String... args) {
		System.out.println(validatePersonName("ivan"));
		System.out.println(validatePhoneNumber("+359889133309"));

	}
}
