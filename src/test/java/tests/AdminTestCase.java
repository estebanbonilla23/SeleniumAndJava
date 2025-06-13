package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CustomSurveyPage;
import pages.CustomerPage;
import pages.HomePage;

import static data.AdminData.*;
import static steps.DownloadAndFillSteps.downloadAndFillSteps;
import static steps.LoginSteps.loginGP;

public class AdminTestCase extends BaseTest{

    HomePage homePage;
    CustomSurveyPage customSurveyPage;
    CustomerPage customerPage;


    @BeforeMethod
    public void setUp() {
        homePage = new HomePage(driver);
        customerPage = new CustomerPage(driver);
        customSurveyPage = new CustomSurveyPage(driver);
    }

    @Test
    public void downloadAndFillForEnvironmentStationaryCombustionAdmin() throws InterruptedException {

        String option = "Stationary Combustion";
        downloadAndFillForCustomerEnvironment(option);
    }

    @Test
    public void downloadAndFillForEnvironmentFugitiveAndProcessedEmissionsAdmin() throws InterruptedException {

        String option = "Fugitive and Processed Emissions";
        downloadAndFillForCustomerEnvironment(option);
    }

    @Test
    public void downloadAndFillForEnvironmentUtilitiesAdmin() throws InterruptedException {

        String option = "Utilities";
        downloadAndFillForCustomerEnvironment(option);
    }

    @Test
    public void downloadAndFillForEnvironmentDownstreamLeasedAssetsAdmin() throws InterruptedException {

        String option = "Downstream leased assets";
        downloadAndFillForCustomerEnvironment(option);
    }

    @Test
    public void downloadAndFillForEnvironmentUpstreamLeasedAssetsAdmin() throws InterruptedException {

        String option = "Upstream leased assets";
        downloadAndFillForCustomerEnvironment(option);
    }

    @Test
    public void downloadAndFillForEnvironmentWasteAdmin() throws InterruptedException {

        String option = "Waste";
        downloadAndFillForCustomerEnvironment(option);
    }

    public void downloadAndFillForCustomerEnvironment(String option) throws InterruptedException {

        loginGP(driver, URL, EMAIL, PASSWORD);
        customSurveyPage.waitForLoaderToDisappear();
        homePage.clickMenuButton("Customers");
        customerPage.searchCustomerByText(CLIENT);
        customerPage.clickOnSearch();
        customerPage.clickOnFirstCustomer();
        customerPage.clickOnEnvironmental();
        customerPage.clickOnEnvironmentalSurvey();
        String filePath = PATH + option + ".csv";
        downloadAndFillSteps(driver, option, filePath, true);
    }
}