package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CustomSurveyPage;
import pages.HomePage;

import java.io.IOException;

import static data.AdminData.PATH;
import static data.CustomerData.*;
import static steps.DownloadAndFillSteps.downloadAndFillSteps;
import static steps.LoginSteps.loginGP;


public class CustomerTestCase extends BaseTest {

    HomePage homePage;
    CustomSurveyPage customSurveyPage;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage(driver);
        customSurveyPage = new CustomSurveyPage(driver);
    }

    @Test
    public void downloadAndFillForEnvironmentStationaryCombustion() throws InterruptedException {

        String option = "Stationary Combustion";
        downloadAndFillForEnvironmentSection(option);
    }

    @Test
    public void downloadAndFillForEnvironmentFugitiveAndProcessedEmissions() throws InterruptedException, IOException {

        String option = "Fugitive and Processed Emissions";
        downloadAndFillForEnvironmentSection(option);
    }

    @Test
    public void downloadAndFillForEnvironmentUtilities() throws InterruptedException, IOException {

        String option = "Utilities";
        downloadAndFillForEnvironmentSection(option);
    }

    @Test
    public void downloadAndFillForEnvironmentDownstreamLeasedAssets() throws InterruptedException, IOException {

        String option = "Downstream leased assets";
        downloadAndFillForEnvironmentSection(option);
    }

    @Test
    public void downloadAndFillForEnvironmentUpstreamLeasedAssets() throws InterruptedException {

        String option = "Upstream leased assets";
        downloadAndFillForEnvironmentSection(option);
    }

    @Test
    public void downloadAndFillForEnvironmentWaste() throws InterruptedException {

        String option = "Waste";
        downloadAndFillForEnvironmentSection(option);
    }

    @Test
    public void addWaste() throws InterruptedException {

        loginGP(driver, URL, EMAIL, PASSWORD);
        customSurveyPage.waitForLoaderToDisappear();
        homePage.clickMenuButton("Environmental");
        customSurveyPage.clickReviewButton();
        customSurveyPage = new CustomSurveyPage(driver);
        customSurveyPage.clickSectionSurvey("Waste");
        customSurveyPage.waitForLoaderToDisappear();
        customSurveyPage.addAnotherResource();
        customSurveyPage.searchFacility("a");
        customSurveyPage.clickOnFacility();
        customSurveyPage.selectResource();
        customSurveyPage.selectDataSource();
        customSurveyPage.addNickName("aut_waste");
        customSurveyPage.clickAcceptButton();
    }

    public void downloadAndFillForEnvironmentSection(String option) throws InterruptedException {

        loginGP(driver, URL, EMAIL, PASSWORD);
        customSurveyPage.waitForLoaderToDisappear();
        homePage.clickMenuButton("Environmental");
        customSurveyPage.clickReviewButton();
        String filePath = PATH + option + ".csv";
        downloadAndFillSteps(driver, option, filePath, false);
    }
}