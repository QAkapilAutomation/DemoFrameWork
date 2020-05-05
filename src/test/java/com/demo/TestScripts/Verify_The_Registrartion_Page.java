package com.demo.TestScripts;

import org.testng.annotations.Test;

import com.guruweb.testBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class Verify_The_Registrartion_Page extends TestBase {
	
	@Test()
	public void testmethod() {
		
		System.out.println("Application launched ");
		test.log(LogStatus.PASS, "Guru Application launched succesfully launched");
	}
	
	
}
