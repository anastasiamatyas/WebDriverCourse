package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services.TestDataReader;
import utils.LogUtils;

public class GoogleCloudPage extends BasePage {
    LogUtils logUtils = LogUtils.getInstance();
    private String googleCloudPageUrl = TestDataReader.getTestData("googleCloudPage.url");

    @FindBy(css = "[aria-label='Search']")
    private WebElement searchButton;

    public GoogleCloudPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPage openPage() {
        driver.get(googleCloudPageUrl);
        logUtils.infoLog("Open " + googleCloudPageUrl);
        return this;
    }

    public GoogleCloudPage clickOnSearchButton() {
        logUtils.infoLog("Click on the search button");
        waitUntilElementClickable(searchButton);
        searchButton.click();
        return this;
    }

    public SearchResultsPage inputSearchRequest(String request) {
        logUtils.infoLog("Input search request: " + request + " and press key 'Enter'");
        searchButton.sendKeys(request + Keys.ENTER);
        return new SearchResultsPage(driver);
    }
}