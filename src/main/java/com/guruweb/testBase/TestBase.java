package com.guruweb.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.guruweb.helper.Wait.WaitHelper;
import com.relevantcodes.extentreports.ExtentReports;

public class TestBase {

	public static ExtentReports extent;
	public static WebDriver driver;
	public static Properties OR;
	public File f1;
	public FileInputStream file;

	static {

		Calendar calender = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports(System.getProperty("user.dir") + "/src/main/java/com/guruweb/Reports/guruweb_"
				+ formater.format(calender.getTime()) + ".html", false);

	}

	public void setup() {
			
			try {
				loadPropertiesFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				Config config = new Config(OR);
				config.getBrowser();
				WaitHelper WaitHelper= new WaitHelper(driver);
				WaitHelper.setImplicitWait(config.getExplicitWait(), TimeUnit.SECONDS);
				WaitHelper.setPageLoadTimeout(config.getPageLoadTimeOut(), TimeUnit.SECONDS);
		}
		catch (Exception e) {
			System.out.println("No Browser Launched");
		}
			
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("User.dir")+"/Drivers");
			ChromeOptions option = new ChromeOptions();
				
	}
	
	public void loadPropertiesFile() throws IOException {
		String log4jConfPath = System.getProperty("user.dir") + "\\src\\main\\resources\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		OR = new Properties();
		f1 = new File(System.getProperty("user.dir") + "/src/main/java/com/hybridFramework/config/config.properties");
		file = new FileInputStream(f1);
		OR.load(file);
		//logger.info("loading config.properties");
	}
}
