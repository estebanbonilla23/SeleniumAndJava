package steps;

import com.aventstack.extentreports.Status;
import extend.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import pages.CustomSurveyPage;
import tests.BaseTest;

import java.io.IOException;

import static utils.CsvModifierUtils.updateNicknameAndUsage;
import static utils.FileUtils.deleteFileIfExists;

public class DownloadAndFillSteps extends BaseTest {

    static CustomSurveyPage customSurveyPage;

    public static void downloadAndFillSteps(WebDriver driver, String option, String filePath, boolean admin) throws InterruptedException {

        deleteFileIfExists(filePath);
        customSurveyPage = new CustomSurveyPage(driver);
        customSurveyPage.clickSectionSurvey(option);
        customSurveyPage.waitForLoaderToDisappear();
        if (admin) {
            customSurveyPage.clickMassiveActionsAdmin();
        }else{
            customSurveyPage.clickMassiveActions();
        }
        customSurveyPage.clickDownloadAndFillButton();
        customSurveyPage.waitForLoaderToDisappear();
        customSurveyPage.clickGetTemplateButton();
        customSurveyPage.waitForLoaderToDisappear();
        updateNicknameAndUsage(filePath);
        customSurveyPage.uploadFile(filePath);
        customSurveyPage.waitForLoaderToDisappear();
        customSurveyPage.clickPreviewButton();
        customSurveyPage.waitForLoaderToDisappear();
        customSurveyPage.waitForWarningsAreNotPresent();
        customSurveyPage.clickAcceptButton();
        customSurveyPage.waitForLoaderToDisappear();
        ExtentTestManager.getTest().log(Status.PASS, "Test executed successfully");
    }
}