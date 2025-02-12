package com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;


@DisplayName("Testing Arithmetic Operations")
class CalculatorTest {

	static Calculator c1;

	@BeforeAll
	static void createCalculator() {
		System.out.println("-----STARTED-------");
		c1 = new Calculator();

	}

	@AfterAll
	static void removeCalculator() {
		c1 = null;
		System.out.println("-------FINISHED----------");
	}

	@BeforeEach
	void beforeEachTestCase() {
		System.out.println("Before Each Test Case");

	}

	@AfterEach
	void afterEachTestCase() {
		System.out.println("After Each Test Case");

	}

	@Test
	@Disabled
	void test() {
		assertTrue(true);
		System.out.println("from test() method");
	}

	@Test
	@DisplayName("Testing Addition Operation")
	void testAdd() {
		System.out.println("from testAdd() method");
		assertEquals(20, c1.add(10, 10), () -> "Sum result is not right");
		assertEquals(50, c1.add(30, 20), () -> "Sum result is not right");
		assertEquals(-10, c1.add(10, -20), () -> "Sum result is not right");
		
		
	}

	/*
	 * @RepeatedTest(value = 5) void testDivRepeated() { assertEquals(2, c1.div(10,
	 * 5)); assertThrows(ArithmeticException.class, ()->c1.div(90, 0));
	 * 
	 * }
	 */

	@Test
	@DisplayName("Testing Divison Operation")
	void testDiv() {
		System.out.println("from testDiv() method");
		assertEquals(2, c1.div(10, 5));
		assertThrows(ArithmeticException.class, () -> c1.div(90, 0));

	}
	
	@Test
	@DisplayName("Testing Multiply Operation")
	void testMul() {
		System.out.println("From testMul() starting");
		assertAll(
				()->assertEquals(50,c1.mul(10,5)),
				()->assertEquals(100,c1.mul(10,10)),
				()->assertEquals(60,c1.mul(10,6)),
				()->assertEquals(90,c1.mul(10,9)),
				()->assertEquals(100,c1.mul(20,5)),
				()->assertEquals(30,c1.mul(6,5))
			);
		//This will not get executed if any one of the above assertEquals fails!
		System.out.println("From testMul() ending IF ALL TEST CASES PASSED");
	}

}
