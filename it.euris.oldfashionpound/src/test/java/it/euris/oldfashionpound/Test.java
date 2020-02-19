package it.euris.oldfashionpound;

import static org.junit.Assert.assertEquals;

public class Test {
	
	@org.junit.Test
	public void testSum() {
		PoundValue a = new PoundValue(5, 17, 8);
		PoundValue b = new PoundValue(3, 4, 10);
		PoundValue result = PoundValue.sum(a, b);
		PoundValue test = new PoundValue(9, 2, 6);
		assertEquals(result, test);
	}
	
	@org.junit.Test
	public void testSubtraction() {
		PoundValue a = new PoundValue(5, 17, 8);
		PoundValue b = new PoundValue(3, 4, 10);
		PoundValue result = PoundValue.subtract(a, b);
		PoundValue test = new PoundValue(2, 12, 10);
		assertEquals(result, test);
	}
	
	@org.junit.Test
	public void testMultiplication() {
		PoundValue a = new PoundValue(5, 17, 8);
		int m = 2;
		PoundValue result = PoundValue.multiply(a, m);
		PoundValue test = new PoundValue(11, 15, 4);
		assertEquals(result, test);
	}
	
	@org.junit.Test
	public void testDivision() {
		PoundValue a = new PoundValue(5, 17, 8);
		int d = 3;
		DivisionResult result = PoundValue.divide(a, d);
		PoundValue testResult = new PoundValue(1, 19, 2);
		PoundValue testRemainder = new PoundValue(0, 0, 2);
		assertEquals(result.getResult(), testResult);
		assertEquals(result.getRemainder(), testRemainder);
	}
	
	@org.junit.Test
	public void testDivision2() {
		PoundValue a = new PoundValue(18, 16, 1);
		int d = 15;
		DivisionResult result = PoundValue.divide(a, d);
		PoundValue testResult = new PoundValue(1, 5, 0);
		PoundValue testRemainder = new PoundValue(0, 1, 1);
		assertEquals(result.getResult(), testResult);
		assertEquals(result.getRemainder(), testRemainder);
	}

}
