package cc;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class ArithTest {

	@Test
	public void testAddNumber() {
		Number num1 = null;
		Number num2 = null;
		BigDecimal result1 = Arith.addNumber(num1, num2);
		assertNull("'null' add 'null' should be null.", result1);

		BigDecimal big1 = new BigDecimal("9");
		BigDecimal result2 = Arith.addNumber(big1, null);
		assertTrue("* add 'null' should be *.", big1.compareTo(result2)==0);
		
		BigDecimal big2 = new BigDecimal("9");
		BigDecimal result3 = Arith.addNumber(null, big2);
		assertTrue("'null' should be *.", big2.compareTo(result3)==0);

	}

	@Test
	public void testSubNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testMulNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testDivNumberNumberNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testDivNumberNumberNumberInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testDivNumberNumberNumberIntRoundingMode() {
		fail("Not yet implemented");
	}

	@Test
	public void testSumNumberNumberArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testSumNumberListOfQextendsNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testRoundNumberNumberInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testRoundNumberNumberIntRoundingMode() {
		fail("Not yet implemented");
	}

}
