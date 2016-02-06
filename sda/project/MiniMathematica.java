package sda.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
//**********************************************************
//Assignment: SDA Project
//Account: 61798
//
//Author: Ivan Mehandzhiev
//
//Completion time: 09:33
//
//Honor Code: I pledge that this program represents my own
//program code. I received help from stackoverflow.com and 
//github in designing and debugging my program.
//*********************************************************

public class MiniMathematica {
	/**
	 * 
	 * 
	 * @author Ivan Mehandzhiev 61798
	 * @since 05.02.2015
	 */
	private final transient Stack<String> postfix;
	private final transient Stack<Double> result;
	/*
	 * Brackets used for operations. Used to find mismatched parentheses.
	 */
	private final transient String[] BRACKETS = { "(", ")" };
	/*
	 * Creating CONSTANTS array, where the items when found as a token are put
	 * as a variable in the postfix stack.
	 */
	private final transient String[] CONSTANTS = { "pi", "e" };
	/*
	 * Creating Map for operators including arithmetics, functions and their
	 * precedence.
	 */
	private final transient String IGNORE_SYMBOL = ",";
	private final transient Map<String, Integer> OPERATOR;
	{
		OPERATOR = new HashMap<String, Integer>();
		OPERATOR.put("+", 1);
		OPERATOR.put("-", 1);
		OPERATOR.put("*", 2);
		OPERATOR.put("/", 2);
		OPERATOR.put("log", 3);
		OPERATOR.put("pow", 3);
		OPERATOR.put("sqrt", 3);
		OPERATOR.put("sin", 3);
		OPERATOR.put("cos", 3);
		OPERATOR.put("tan", 3);
		OPERATOR.put("cotg", 3);
		OPERATOR.put("nSqrt", 3);
	}

	/*
	 * Creating postfix stack used to put tokens from the infix expression.
	 * 
	 * Creating result stack where the result should be retained.
	 */
	public MiniMathematica() {
		postfix = new Stack<String>();
		result = new Stack<Double>();
	}

	Double calculate(final String expression) throws WrongExpression {
		return reversePolishNotation(shuntingYardAlgo(splitter(expression)));
	}

	private List<String> splitter(final String expression) {
		final StringBuffer tokens = new StringBuffer();
		tokens.append(expression.replaceAll("\\s+", ""));
		boolean firstSymbol = true;
		final ArrayList<String> parts = new ArrayList<>();
		final StringBuffer merge = new StringBuffer();
		merge.append("");
		for (int i = 0; i < tokens.length(); i++) {
			if (merge.length() == 0 && tokens.charAt(i) == '-' && firstSymbol) {
				merge.append(tokens.charAt(i));
				firstSymbol = false;
			} else if (tokens.charAt(i) >= 'a' && tokens.charAt(i) <= 'z'
					|| tokens.charAt(i) >= 'A' && tokens.charAt(i) <= 'Z'
					|| tokens.charAt(i) >= '0' && tokens.charAt(i) <= '9'
					|| tokens.charAt(i) == '.') {
				merge.append(tokens.charAt(i));
				firstSymbol = false;
			} else {
				if (merge.length() == 0) {
					parts.add(String.valueOf(tokens.charAt(i)));
				} else {
					parts.add(merge.toString());
					parts.add(String.valueOf(tokens.charAt(i)));
					merge.setLength(0);
				}
			}
		}

		if (merge.length() != 0) {
			parts.add(merge.toString());
		}
		return parts;
	}

	private Queue<String> shuntingYardAlgo(final List<String> tokens)
			throws WrongExpression {
		final Queue<String> output = new LinkedList<>();
		for (final String token : tokens) {
			if (!token.matches("^[0-9]*$") && !OPERATOR.containsKey(token)
					&& !token.equals(BRACKETS[0]) && !token.equals(BRACKETS[1])
					&& !token.equals(IGNORE_SYMBOL)
					&& !token.equals(CONSTANTS[0])
					&& !token.equals(CONSTANTS[1])) {
				throw new WrongExpression("IllegalExpression");
			}
			if (token.matches("^[0-9]*$")) {
				output.add(token);
			} else if (token.contains(CONSTANTS[1])
					|| token.contains(CONSTANTS[0])) {
				output.add(token);
			} else if (OPERATOR.containsKey(token)) {
				if (postfix.isEmpty()) {
					postfix.add(token);
				} else {
					while (!postfix.isEmpty()) {
						if (OPERATOR.containsKey(postfix.peek())
								&& OPERATOR.get(token).intValue() <= OPERATOR
										.get(postfix.peek()).intValue()) {
							output.add(postfix.pop());
						} else {
							break;
						}
					}
					postfix.add(token);
				}
			} else if (OPERATOR.containsKey(token)) {
				postfix.add(token);
			} else if (token.equals(BRACKETS[0])) {
				postfix.add(token);
			} else if (token.equals(BRACKETS[1])) {
				if (!postfix.isEmpty()) {
					String pop = postfix.pop();
					while (!pop.equals(BRACKETS[0])) {
						output.add(pop);
						pop = postfix.pop();
					}
					while (!postfix.isEmpty()
							&& OPERATOR.containsKey(postfix.peek())
							&& OPERATOR.get(postfix.peek()) > 1) {
						pop = postfix.pop();
						output.add(pop);
					}
				} else
					throw new MismatchedParentheses("Mismatched parentheses");
			}
		}
		while (!postfix.isEmpty()) {
			if (postfix.peek().equals(BRACKETS[0])
					|| postfix.peek().equals(BRACKETS[1])) {
				throw new MismatchedParentheses("Mismatched parentheses");
			}
			output.add(postfix.pop());
		}
		return output;
	}

	private double reversePolishNotation(final Queue<String> queue)
			throws WrongExpression {
		String token;
		double argument1;
		double argument2;
		while (!queue.isEmpty()) {
			token = queue.peek();
			if (token.matches("^[0-9]*$")) {
				result.add(Double.parseDouble(token));
			} else {
				switch (token) {
				case "+":
					argument2 = result.pop();
					argument1 = result.pop();
					result.add(argument1 + argument2);
					break;
				case "-":
					argument2 = result.pop();
					argument1 = result.pop();
					result.add(argument1 - argument2);
					break;
				case "/":
					argument2 = result.pop();
					argument1 = result.pop();
					if (argument2 == 0) {
						throw new IllegalArgumentException(
								"Can't divide by ZERO");
					}
					result.add(argument1 / argument2);
					break;
				case "*":
					result.add(result.pop() * result.pop());
					break;
				case "pow":
					argument2 = result.pop();
					argument1 = result.pop();
					result.add(Math.pow(argument1, argument2));
					break;
				case "sqrt":
					argument1 = result.pop();
					result.add(Math.sqrt(argument1));
					break;
				case "nSqrt":
					argument2 = result.pop();
					argument1 = result.pop();
					result.add(Math.pow(argument1, 1 / argument2));
					break;
				case "sin":
					argument1 = result.pop();
					if (argument1 == Math.PI || argument1 == Math.E) {
						result.add((double) Math.round(Math.sin(argument1)));
					} else {
						result.add(Math.sin(argument1));
					}
					break;
				case "cos":
					argument1 = result.pop();
					if (argument1 == Math.PI || argument1 == Math.E) {
						result.add((double) Math.round(Math.cos(argument1)));
					} else {
						result.add(Math.cos(argument1));
					}
					break;
				case "tan":
					argument1 = result.pop();
					if (argument1 == Math.PI || argument1 == Math.E) {
						result.add((double) Math.round(Math.tan(argument1)));
					} else {
						result.add(Math.tan(argument1));
					}
					break;
				case "cotg":
					argument1 = result.pop();
					if (argument1 == Math.PI || argument1 == Math.E) {
						result.add((double) 1 / Math.round(Math.tan(argument1)));
					} else {
						result.add(1.0 / Math.tan(argument1));
					}
					break;
				case "pi":
					result.add(Math.PI);
					break;
				case "e":
					result.add(Math.E);
					break;
				case "log":
					argument2 = result.pop();
					argument1 = result.pop();
					final double log1 = Math.log(argument1);
					final double log2 = Math.log(argument2);
					result.add(log2 / log1);
					break;
				default:
					throw new WrongExpression("Illegal Expression");
				}
			}
			queue.poll();
		}
		return result.lastElement();
	}
}