package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	static WebDriver driver;
	@BeforeTest
	public void setup() {
		try {
			System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
	        driver = new ChromeDriver();
	        driver.get("https://eadapp-qa-demo.up.railway.app/login");
			Thread.sleep(2000);
			

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}

	@AfterSuite
	public void teardown() {
		driver.close();
	}


}
