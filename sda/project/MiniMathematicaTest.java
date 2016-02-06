package sda.project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MiniMathematicaTest {
	private MiniMathematica test;

	@Test
	public void testMiniMathematica() throws WrongExpression {
		assertEquals(
				3.0,
				test.calculate("5 + sin(pi) / pow(2, 10) - log(e, pow(e, sqrt(4)))"),
				0.0001);
		assertEquals(
				4.0,
				test.calculate("log(10, pow(10,2))*sqrt(16)-nSqrt(pow(16,2),4)"),
				0.0001);
		assertEquals(2.6817,
				test.calculate("pow(pow(2,3),(1/4))+nSqrt(sin(pi/2),5)"),
				0.0001);
		assertEquals(
				10.76393,
				test.calculate("pow(2,6)+cos(pi/2)/tan(pi/4)-sqrt(log(3,243))-17*3"),
				0.0001);
	}

	@Test(expected = WrongExpression.class)
	public void testIllegalExpressionException() throws WrongExpression {
		test.calculate("POW(20,50)");
	}

	@Test(expected = WrongExpression.class)
	public void testMismatchedParentheses() throws WrongExpression {
		test.calculate("sqrt(pow(2,3)");
	}

	@Before
	public void initialize() {
		test = new MiniMathematica();
	}
}
