package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.LogUtils;

public class SearchResultsPage extends BasePage {
    LogUtils logUtils = LogUtils.getInstance();

    @FindBy(className = "gsc-expansionArea")
    private WebElement searchResults;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage clickSearchResultByText(String text) {
        waitUntilElementVisible(searchResults);
        searchResults.findElement(By.linkText(text)).click();
        logUtils.infoLog("Click on the " + text + " search result");
        return this;
    }
}