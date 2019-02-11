package com.rm;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
@RunWith(Parameterized.class)
public class TestApp {
	private static Calculater cal=null;
	float inputnumber1;
	static float inputnumber2;
	static float result;
	
	public TestApp(float inputnumber1,float inputnumber2,float result) {
		this.inputnumber1=inputnumber1;
		this.inputnumber2=inputnumber2;
		this.result=result;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cal=new Calculater();
	}
	 @Parameterized.Parameters
	   public static Collection input() {
	      return Arrays.asList(new Object[][] {
	         { 5,6,11 },
	         { -5,6,1},
	         { -5,-5, 10 },
	         { 0,0, 0 },
	      });
	   }
	 @Ignore
	@Test
	public void add() {
		assertEquals(result, cal.add(inputnumber1, inputnumber2));
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		cal=null;
		inputnumber2=0;
		inputnumber2=0;
		result=0;
		
	}

	

}
