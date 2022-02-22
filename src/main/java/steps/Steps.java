package steps;

import models.ComputeEngine;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.GoogleCloudPage;
import pages.GoogleCloudPricingCalculatorPage;
import pages.YopMailPage;
import utils.LogUtils;

public class Steps {
    WebDriver driver;
    LogUtils logUtils = LogUtils.getInstance();
    String totalEstimatesCostInEmail;
    String totalEstimatesCostInCalculator;

    public Steps(WebDriver driver) {
        this.driver = driver;
    }

    public void findSearchQueryOnGoogleCloudPage(String query) {
        new GoogleCloudPage(driver).openPage()
                .clickOnSearchButton()
                .inputSearchRequest(query)
                .clickSearchResultByText(query);
    }

    public void getTotalEstimatedCostInCalculator(ComputeEngine computeEngine) {
        totalEstimatesCostInCalculator = new GoogleCloudPricingCalculatorPage(driver)
                .acceptCookie()
                .clickOnComputeEngineTab()
                .enterNumberOfInstances(computeEngine.getNumberOfInstances())
                .chooseOperatingSystem(computeEngine.getOperatingSystem())
                .chooseMachineClass(computeEngine.getMachineClass())
                .chooseSeries(computeEngine.getSeries())
                .chooseMachineType(computeEngine.getMachineType())
                .enableAddGPUCheckbox()
                .chooseGPUType(computeEngine.getGpuType())
                .chooseNumberOfGPU(computeEngine.getNumberOfGPU())
                .chooseLocalSSD(computeEngine.getLocalSSD())
                .chooseDatacenterLocation(computeEngine.getDatacenterLocation())
                .chooseCommittedUsage(computeEngine.getCommittedUsage())
                .clickAddToEstimateButton()
                .getTotalEstimatedCost();
        logUtils.infoLog(totalEstimatesCostInCalculator);
    }

    public void sendEmailWithPropose() {
        new GoogleCloudPricingCalculatorPage(driver).clickEmailEstimateButton()
                .enterEmail(new YopMailPage(driver)
                        .openPageInNewTab()
                        .acceptNecessaryCookies()
                        .clickGenerateEmailLink()
                        .getGeneratedEmail())
                .clickSendEmailButton();
    }

    public void getTotalEstimatedCostInEmail() {
        totalEstimatesCostInEmail = new YopMailPage(driver)
                .goToTheTabNumber(1)
                .clickCheckInboxButton()
                .refreshInbox()
                .chooseLetterByTitle("Google Cloud Price Estimate")
                .getTotalEstimatedMonthlyCost();
        logUtils.infoLog("Total estimated cost in email is " + totalEstimatesCostInEmail);
    }

    public void assertThatTotalEstimatesCostInPricingCalculatorAndInEmail() {
        Assert.assertTrue(totalEstimatesCostInCalculator.contains(totalEstimatesCostInEmail),
                "The total estimated cost in calculator doesn't equal the cost in the email.");
    }
}