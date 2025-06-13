package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.WaitUtils.waitForAction;

public class CustomerPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    private final By  companyDetails = By.xpath("//span[contains(text(),'Details')]");
    private final By  search = By.xpath("//input[@placeholder='Search']");
    private final By  searchIcon = By.xpath("//img[@alt='search_icon']");
    private final By  environmental = By.xpath("//span[contains(text(),'Environmental')]");
    private final By  reviewEnvironmentalSurvey = By.xpath("//span[contains(text(),'Review')]");


    // Constructor
    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10); // Timeout set to 10 seconds
    }

    public void searchCustomerByText(String value) {
        WebElement inputSearch = wait.until(ExpectedConditions.elementToBeClickable(search));
        inputSearch.click();
        inputSearch.sendKeys(value);
    }

    public void clickOnSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchIcon)).click();
    }

    public void clickOnFirstCustomer() {

        wait.until(ExpectedConditions.elementToBeClickable(companyDetails)).click();
    }

    public void clickOnEnvironmental() throws InterruptedException {
        waitForAction(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(environmental)).click();
        });
    }

    public void clickOnEnvironmentalSurvey() throws InterruptedException {
        waitForAction(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(reviewEnvironmentalSurvey)).click();
        });
    }
}
