package com.demo.TestScripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.guruweb.testBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class Verify_The_Registrartion_Page extends TestBase {
	
	@Test()
	public void LoginToTheApplication() {
		
		test.log(LogStatus.PASS, "Guru Application launched succesfully launched");
		
		
			try {
				driver.findElement(By.name("firstName")).sendKeys("Kapil");
				test.log(LogStatus.PASS, "FirstName entered");
				driver.findElement(By.name("lastName")).sendKeys("Singh");
				test.log(LogStatus.PASS, "lastname entered");
				driver.findElement(By.name("phone")).sendKeys("857515427");
				test.log(LogStatus.PASS, "phone number entered");
				driver.findElement(By.name("submit")).click();
				test.log(LogStatus.PASS, "clicked on the submit button");
			} catch (Exception e) {
				
				test.log(LogStatus.FAIL, "unable to click on the submit button");
			}
	
		
		
		
			
		}
	}
	
	

