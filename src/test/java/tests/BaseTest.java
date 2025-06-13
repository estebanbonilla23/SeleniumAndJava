package tests;

import driver.WebDriverHandle;
import extend.ExtentManager;
import extend.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(Method method) {

        driver = WebDriverHandle.getDriver("Firefox");
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().info("Browser opened");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.getTest().fail("Test failed");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentTestManager.getTest().pass("Test passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExtentTestManager.getTest().skip("Test skipped");
        }

        if (driver != null) {
            //driver.quit();
            ExtentTestManager.getTest().info("Browser closed");
        }
    }

    @AfterSuite
    public void tearDownSuite() {
        ExtentManager.getInstance().flush();
    }
}
