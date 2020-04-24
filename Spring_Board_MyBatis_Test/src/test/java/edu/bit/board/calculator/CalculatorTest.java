package edu.bit.board.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	// assertEquals(a, b, c);
	// 객체 a와 b가 일치함을 확인한다.
	// a : 예상값, b : 결과값, c : 오차범위 
	
	// assertArrayEquals(a, b);
	// 배열 a와 b가 일치함을 확인한다.
	
 	
	@Test
	public void testSum() {
		Calculator cal = new Calculator();
		int result = cal.sum(10, 20);
		assertEquals(20, result, 10);
	}
	
	@Test
	public void testSub() {
		Calculator cal = new Calculator();
		int result = cal.sub(10, 20);
		assertEquals(-10, result, 10);
	}

}
