package com;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;


@DisplayName("Testing Arithmetic Operations")
@TestInstance(Lifecycle.PER_CLASS) 
//This will ensure that the CalculatorTest Object is created only Once
//By Default it is PER_METHOD, so that every Test Case will have fresh new Object with it's variables
class CalculatorTest {
	
	public CalculatorTest() {
		System.out.println("<<---- CalculatorTest Object Created ---->>");
	}

	static Calculator c1;
	static int x=2;
	static boolean condition = false;

	@BeforeAll			// @BeforeClass -> For JUnit3
	static void createCalculator() {
		System.out.println("-----STARTED-------");
		c1 = new Calculator();
		if(x!=0)
			condition = true;

	}

	@AfterAll			// @AfterClass -> For JUnit3
	static void removeCalculator() {
		c1 = null;
		System.out.println("-------FINISHED----------");
	}

	@BeforeEach			// @Before -> For JUnit3
	void beforeEachTestCase() {
		System.out.println("Before Each Test Case");

	}

	@AfterEach			// @After -> For JUnit3
	void afterEachTestCase() {
		System.out.println("After Each Test Case");

	}

	@Test
	@Disabled			// @Ignore -> For JUnit3
	@Tag("demo")
	void test() {
		assertTrue(true);
		System.out.println("from test() method");
	}

	@Test
	@DisplayName("Testing Addition Operation")
	@Tag("math")
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
	@Tag("math")
	void testDiv() {
		System.out.println("from testDiv() method");
		assertEquals(2, c1.div(10, 5));
		assertThrows(ArithmeticException.class, () -> c1.div(90, 0));

	}
	
	@Test
	@DisplayName("Testing Multiply Operation")
	@Tag("math")
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

	
	/*
	 * In, TDD(Test Driven Development), the Test Cases are written first 
	 * then the development of the logic is done. 
	 * This is done so that the developer can start writing the code, 
	 * in accordance with the test cases.
	 * */
	@Test
	@Tag("math")
	void testMod() {
		assertAll(
				()->assertEquals(0, c1.mod(10,5)),
				()->assertEquals(2, c1.mod(14,6)),
				()->assertEquals(1, c1.mod(11,5)),
				()->assertEquals(0, c1.mod(100,4)),
				()->assertEquals(2, c1.mod(210,4)),
				()->assertEquals(10, c1.mod(22,12))
				);
	}
	
	//Useful for Older Versions of Java
	@Test
	@EnabledForJreRange(min=JRE.JAVA_10,max=JRE.JAVA_15)
	@Tag("lambda")
	void testLambda() {
		System.out.println("Testing for lambda");
	}
	
	//To be used for Specific OS (Eg:- DLL is only for Windows)
	@Test
	@EnabledOnOs(OS.WINDOWS)
	@Tag("os")
	void testDll() {
		System.out.println("Testing DLL Files");
		
	}
	
	//Used for LINUX or MACOS
	//Like this there are many OS available	
	@Test
	@EnabledOnOs(value = {OS.LINUX,OS.MAC})
	@Tag("os")
	void testShellScripts() {
		System.out.println("Testing Shell Scripts");
	}
	
	@Test
	@Tag("math")
	void testDynamically() {
		System.out.println("Testing Dynamically Started");
		assertEquals(5,c1.div(10,x));
		assertEquals(15,c1.div(30,x));
		//Partial execution using Assumption
		assumeTrue(condition);
		assertEquals(20,c1.div(40,x));
		System.out.println("Testing Dynamically Finished");
		
	}
	
	@Test
	@Tag("db")
	void testInsertEmp() {
		System.out.println("Testing emp record insertion logic");
	}
	
	@Test
	@Tag("db")
	void testUpdateEmp() {
		System.out.println("Testing emp record updation logic");
	}
	
	@Test
	@Tag("db")
	void testDeleteEmp() {
		System.out.println("Testing emp record deletion logic");
	}
	
	@Test
	@Tag("db")
	void testSelectEmp() {
		System.out.println("Testing emp record selection logic");
	}
	
	
	
	
	
	
	
	
}
