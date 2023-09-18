package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BrowserUtils;

public class TestInvalidCredentials extends BaseClass {
	private LoginPage loginPage;

	@BeforeMethod
	public void beforeTest() {
		driver.get("https://eadapp-qa-demo.up.railway.app/login");

	}

	@Test
	public void invalidEmailValidPassword() {
		loginPage = new LoginPage(driver);

		for (String viewport : new String[] { "desktop", "tablet", "mobile" }) {
			BrowserUtils.setViewportSize(driver, viewport);

			loginPage.enterEmail("fakeadmin@3sdcl.com");
			loginPage.enterPassword("Password@123");
			loginPage.clickSubmit();

			try {
				Thread.sleep(1000);
				loginPage.clickProceed();
				Thread.sleep(1000);
				String expectedText = loginPage.getInvalidCredentialsMessage();
				String actualText = "These credentials do not match our records.";
				Assert.assertEquals(expectedText, actualText);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void validEmailInvalidPassword() {
		loginPage = new LoginPage(driver);

		for (String viewport : new String[] { "desktop", "tablet", "mobile" }) {
			BrowserUtils.setViewportSize(driver, viewport);

			loginPage.enterEmail("admin@3sdcl.com");
			loginPage.enterPassword("Password@1234");
			loginPage.clickSubmit();

			try {
				Thread.sleep(1000);
				loginPage.clickProceed();
				Thread.sleep(2000);
				String expectedText = loginPage.getInvalidCredentialsMessage();
				String actualText = "These credentials do not match our records.";
				Assert.assertEquals(expectedText, actualText);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void invalidEmailInvalidPassword() {
		loginPage = new LoginPage(driver);

		for (String viewport : new String[] { "desktop", "tablet", "mobile" }) {
			BrowserUtils.setViewportSize(driver, viewport);

			loginPage.enterEmail("fakeadmin@3sdcl.com");
			loginPage.enterPassword("Password@1234");
			loginPage.clickSubmit();

			try {
				Thread.sleep(1000);
				loginPage.clickProceed();
				Thread.sleep(1000);
				String expectedText = loginPage.getInvalidCredentialsMessage();
				String actualText = "These credentials do not match our records.";
				Assert.assertEquals(expectedText, actualText);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void noEmailNoPassword() {
		loginPage = new LoginPage(driver);

		for (String viewport : new String[] { "desktop", "tablet", "mobile" }) {
			BrowserUtils.setViewportSize(driver, viewport);
			loginPage.clickSubmit();

			try {
				Thread.sleep(1000);
				String pageSource = loginPage.getEmailValidationMessage();
				String expectedText = "Please fill in this field";
				Assert.assertTrue(pageSource.contains(expectedText));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void noEmailValidPassword() {
		loginPage = new LoginPage(driver);

		for (String viewport : new String[] { "desktop", "tablet", "mobile" }) {
			BrowserUtils.setViewportSize(driver, viewport);
			loginPage.enterPassword("Password@123");
			loginPage.clickSubmit();

			try {
				Thread.sleep(1000);
				String pageSource = loginPage.getEmailValidationMessage();
				String expectedText = "Please fill in this field";
				Assert.assertTrue(pageSource.contains(expectedText));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void noPasswordValidEmail() {
		loginPage = new LoginPage(driver);

		for (String viewport : new String[] { "desktop", "tablet", "mobile" }) {
			BrowserUtils.setViewportSize(driver, viewport);
			loginPage.enterEmail("admin@3sdcl.com");
			loginPage.clickSubmit();

			try {
				Thread.sleep(1000);
				String pageSource = loginPage.getPasswordValidationMessage();
				String expectedText = "Please fill in this field";
				Assert.assertTrue(pageSource.contains(expectedText));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
