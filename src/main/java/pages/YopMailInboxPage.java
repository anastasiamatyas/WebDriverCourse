package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.LogUtils;

import java.util.List;

public class YopMailInboxPage extends BasePage {
    LogUtils logUtils = LogUtils.getInstance();

    @FindBy(xpath = "//div[@class='m']//div[@class='lms']/..")
    private List<WebElement> listOfMessages;

    @FindBy(xpath = "//*[text() = 'Total Estimated Monthly Cost']/../following-sibling::td/h3")
    private WebElement totalEstimatedMonthlyCost;

    @FindBy(css = "#refresh")
    private WebElement refreshInboxButton;

    @FindBy(css = "#nbmail")
    private WebElement numberOfMessage;

    public YopMailInboxPage(WebDriver driver) {
        super(driver);
    }

    public YopMailInboxPage refreshInbox() {
        int i = 0;
        while (numberOfMessage.getText().equals("0 mail") && i <= 50) {
            refreshInboxButton.click();
            i++;
        }
        logUtils.infoLog("Click on the 'Refresh' button");
        return this;
    }

    public YopMailInboxPage chooseLetterByTitle(String letterTitle) {
        driver.switchTo().frame("ifinbox");
        waitUntilListOfElementsVisible(listOfMessages);
        listOfMessages.stream().map(x -> x.findElement(By.xpath("//div[text() = '" + letterTitle + "'][@class = 'lms']"))).findFirst().get().click();
        driver.switchTo().defaultContent();
        logUtils.infoLog("Choose letter with letterTitle: " + letterTitle);
        return this;
    }

    public String getTotalEstimatedMonthlyCost() {
        driver.switchTo().frame("ifmail");
        logUtils.infoLog("Get total estimate monthly cost from letter");
        return totalEstimatedMonthlyCost.getText();
    }
}