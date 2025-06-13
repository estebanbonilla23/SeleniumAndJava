package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By usernameField = By.id("email");
    By passwordField = By.id("password");
    By submitButton = By.id("btn-next-login");
    By btnContinue = By.id("btn-login");

    // Constructor
    public LoginPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    // Page actions (methods)
    public void openLoginPage(String url) {

        driver.get(url);
        wait.until(ExpectedConditions.urlContains("auth.app"));
    }

    public void enterUsername(String email) {

        WebElement usernameInput = wait.until(ExpectedConditions.presenceOfElementLocated(usernameField));
        usernameInput.sendKeys(email);
    }

    public void enterPassword(String password) {

        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordInput.sendKeys(password);
    }

    public void clickSubmit() {

        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitBtn.click();
    }

    public void clickContinue() {

        WebElement continueBtn = wait.until(ExpectedConditions.presenceOfElementLocated(btnContinue));
        continueBtn.click();
    }
}
