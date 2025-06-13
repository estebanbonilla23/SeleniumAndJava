package steps;

import com.aventstack.extentreports.Status;
import extend.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import tests.BaseTest;

public class LoginSteps extends BaseTest {

    static LoginPage loginPage;
    static HomePage homePage;

    public static void loginGP(WebDriver driver, String url, String user, String password) {

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Opened login page");

        // Step 1: Open login page
        loginPage.openLoginPage(url);

        // Step 2: Enter username and submit
        loginPage.enterUsername(user);
        loginPage.clickSubmit();

        // Step 3: Enter password and submit
        loginPage.enterPassword(password);
        loginPage.clickContinue();

        // Step 4: Validate the title and wait for homepage to load
        homePage.waitForPageLoad();
        homePage.verifyTitle("Green Project");

        ExtentTestManager.getTest().log(Status.INFO, "Login completed");
    }
}