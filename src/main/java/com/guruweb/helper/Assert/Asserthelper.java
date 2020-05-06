package com.guruweb.helper.Assert;

import org.testng.asserts.SoftAssert;

import com.guruweb.testBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class Asserthelper extends TestBase {

	public static void verifyActaulAndExpectedData(String actual, String expected) {
		SoftAssert sf = new SoftAssert();
		
		try {
			sf.assertEquals(actual, expected);
			//Assert.assertEquals(actual, expected);
			test.log(LogStatus.PASS, "actual data and expected are same");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "actual data and expected are not same");
			sf.assertAll();
		}
	}

}
