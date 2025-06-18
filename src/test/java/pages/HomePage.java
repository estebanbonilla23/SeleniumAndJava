package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static utils.WaitUtils.waitForAction;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    private final By menu = By.className("ant-menu");
    private final String leftMenuOption = "//span[contains(text(),'%s')]/../..";

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10); // Timeout set to 10 seconds
    }

    public void clickMenuButton(String option) throws InterruptedException {
        waitForAction(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(leftMenuOption, option)))).click();
        });
    }

    public void waitForPageLoad() {

        wait.until(ExpectedConditions.presenceOfElementLocated(menu));
    }
}
