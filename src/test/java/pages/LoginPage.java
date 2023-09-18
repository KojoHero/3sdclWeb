package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By submitButton = By.cssSelector("button[type='submit']");
    private By proceedButton = By.id("proceed-button");
    private By invalidCredentialsMessage = By.className("mt-3");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        WebElement emailElement = driver.findElement(emailInput);
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordInput);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public void clickProceed() {
        driver.findElement(proceedButton).click();
    }

    public String getInvalidCredentialsMessage() {
        return driver.findElement(invalidCredentialsMessage).getText();
    }

    public String getEmailValidationMessage() {
        WebElement emailElement = driver.findElement(emailInput);
        return emailElement.getAttribute("validationMessage");
    }

    public String getPasswordValidationMessage() {
        WebElement passwordElement = driver.findElement(passwordInput);
        return passwordElement.getAttribute("validationMessage");
    }
}
