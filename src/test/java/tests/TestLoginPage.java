package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.BrowserUtils;

public class TestLoginPage extends BaseClass {
    @Test
    public void validEmailAndValidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        for (String viewport : new String[]{"desktop", "tablet", "mobile"}) {
        	BrowserUtils.setViewportSize(driver, viewport);

            loginPage.enterEmail("admin@3sdcl.com");
            loginPage.enterPassword("Password@123");
            loginPage.clickSubmit();

            try {
                Thread.sleep(1000);
                loginPage.clickProceed();
                Thread.sleep(2000);

                String expectedText = homePage.getWelcomeMessage();
                String actualText = "Welcome to your e-ADAPP Web Application!";
                Assert.assertEquals(expectedText, actualText);

                driver.manage().deleteAllCookies();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                driver.get("https://eadapp-qa-demo.up.railway.app/login");
            }
        }
    }
}
