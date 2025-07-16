package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.WaitUtils.waitForAction;

public class CustomSurveyPage {
    private WebDriver driver;
    private WebDriverWait wait;


    private By reviewButton = By.xpath("//span[@class = 'c-pointer']");
    private String surveySection = "//span[contains(text(),'%s')]";
    private By massiveActionsBtn = By.id("rc_select_9");
    private By massiveActionsAdminBtn = By.id("rc_select_6");
    private By facilityInput = By.id("rc_select_15");
    private By facilityOption = By.xpath("//div[@class = 'ant-select-item-option-content']");
    private By resourceDetailInput = By.id("fuel_detail");
    private By dataSourceInput = By.id("data_source");
    private By nicknameInput = By.id("nickname");
    private By directEntryOption = By.xpath("//div[contains(text(), 'Direct Entry')]");
    private By resouceParent = By.xpath("//li[@role='menuitemcheckbox']");
    private By resouceChild = By.xpath("//li[@class='ant-cascader-menu-item']//div[@class='ant-cascader-menu-item-content']");
    private By downloadAndFillButton = By.xpath("//span[contains(text(), 'Download')]");
    private By addAnotherButton = By.xpath("//span[contains(text(), 'Add another')]");
    private By getTemplateButton = By.xpath("//span[@class = 'ant-btn-icon']/span[contains(@class,'anticon-download')]");
    private By chooseFileInput = By.xpath("//input[@type = 'file']");
    private By previewButton = By.xpath("//span[contains(text(),'Preview Data')]/..");
    private By acceptButton = By.xpath("//div[@class='ant-modal-content']//button[contains(@class,'ant-btn-primary')]");
    private By loader = By.xpath("//div[@class='loader'] or //div[contains(@class, 'ant-spin-spinning')]");
    private By warningMessage = By.xpath("//span[contains(@class,'ant-typography-danger')]");
    private By collapseArrow = By.xpath("//span[contains(@class,'ant-collapse-arrow')]");
    private By warningIcon = By.xpath("//span[contains(@class,'anticon-warning')]");

    // Constructor
    public CustomSurveyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void clickReviewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(reviewButton)).click();
    }

    public void clickSectionSurvey(String option) throws InterruptedException {
        waitForAction(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(surveySection, option)))).click();
        });
    }

    public void clickMassiveActions() {

        wait.until(ExpectedConditions.presenceOfElementLocated(massiveActionsBtn)).click();
    }

    public void clickMassiveActionsAdmin() throws InterruptedException {
        waitForAction(() -> {
            wait.until(ExpectedConditions.presenceOfElementLocated(massiveActionsAdminBtn)).click();
        });
    }

    public void clickDownloadAndFillButton() {

        wait.until(ExpectedConditions.presenceOfElementLocated(downloadAndFillButton)).click();
    }

    public void clickGetTemplateButton() {

        wait.until(ExpectedConditions.elementToBeClickable(getTemplateButton)).click();
    }

    public void uploadFile(String filePath) throws InterruptedException {
        waitForAction(() -> {
            WebElement fileInput = driver.findElement(chooseFileInput);
            ((JavascriptExecutor) driver).executeScript("arguments[0].style = 'display: block;';", fileInput);
            fileInput.sendKeys(filePath);
        });
    }

    public void clickPreviewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(previewButton)).click();
    }

    public void clickAcceptButton() throws InterruptedException {
        waitForAction(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(acceptButton)).click();
        });
    }

    public void waitForLoaderToDisappear() throws InterruptedException {
        waitForAction(() -> {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        });
    }

    public void waitForWarningsAreNotPresent() {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(warningMessage));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(collapseArrow));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(warningIcon));
    }

    public void addAnotherResource() {

        wait.until(ExpectedConditions.elementToBeClickable(addAnotherButton)).click();
    }

    public void searchFacility(String keyWord) throws InterruptedException {
        waitForAction(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(facilityInput)).click();
            wait.until(ExpectedConditions.elementToBeClickable(facilityInput)).sendKeys(keyWord);
        });
    }

    public void clickOnFacility() throws InterruptedException {
        waitForAction(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(facilityOption)).click();
        });
    }

    public void selectResource() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(resourceDetailInput)).click();
        waitForAction(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(resouceParent)).click();
        });
        waitForAction(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(resouceChild)).click();
        });
    }

    public void selectDataSource() throws InterruptedException {

        waitForAction(() -> {
            wait.until(ExpectedConditions.elementToBeClickable(dataSourceInput)).click();
            wait.until(ExpectedConditions.elementToBeClickable(directEntryOption)).click();
        });
    }

    public void addNickName(String nickname) {
        wait.until(ExpectedConditions.elementToBeClickable(nicknameInput)).sendKeys(nickname);
    }


}
