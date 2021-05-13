package com.app;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ArithmeticOprTest {

	private static ArithmeticOpr arithObj = null;
	
	@Parameter(value=0) //index
	public int x;
	
	@Parameter(value=1)
	public int y;
	
	@Parameters
	public static Collection<Object []> testData() {
		Object data[][] = {
				{50, 10}, {45, 9}, {80, 2}, {35, 5}, {150, 3}, {66, 3}, { 51, 17 }
		};
		return Arrays.asList(data);
	}
	
	@Test
	public void testDivide() {
		assertEquals((x/y), arithObj.divide(x, y), 0.0);
	}

	@BeforeClass
	public static void beforeClass() {
		ArithmeticOprTest.arithObj = new ArithmeticOpr();
		System.out.println("BeforeClass");
	}


	
	
	
	
	
	
	
/*	
	@AfterClass
	public static void afterClass() {
		ArithmeticOprTest.arithObj = null;
		System.out.println("AfterClass");
	}
	
	@Before
	public void before() {
		System.out.println("Before");
	}
	
	@After
	public void after() {
		System.out.println("After");
	}

	@Ignore
	@Test
	public void testDivide3() {
		
	}
*/	

}
