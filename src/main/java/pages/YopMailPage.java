package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.LogUtils;

import java.util.ArrayList;

public class YopMailPage extends BasePage {
    LogUtils logUtils = LogUtils.getInstance();

    @FindBy(css = "#cons-dialog #necesary")
    private WebElement acceptNecessaryCookieButton;

    @FindBy(css = "#listeliens [href='email-generator']")
    private WebElement generateEmailLink;

    @FindBy(css = "#egen")
    private WebElement generatedEmail;

    @FindBy(xpath = "//span[text()='Check Inbox']")
    private WebElement checkInboxButton;

    public YopMailPage(WebDriver driver) {
        super(driver);
    }

    public YopMailPage goToTheTabNumber(Integer number) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(number));
        return this;
    }

    public YopMailPage openPageInNewTab() {
        logUtils.infoLog("Open 'https://yopmail.com/' in new tab");
        js.executeScript("window.open('https://yopmail.com/','_blank')");
        goToTheTabNumber(1);
        waitUntilElementClickable(acceptNecessaryCookieButton);
        return this;
    }

    public YopMailPage acceptNecessaryCookies() {
        logUtils.infoLog("Accept necessary cookies on the page");
        acceptNecessaryCookieButton.click();
        return this;
    }

    public YopMailPage clickGenerateEmailLink() {
        logUtils.infoLog("Click on the 'Generate random email'");
        generateEmailLink.click();
        return this;
    }

    public String getGeneratedEmail() {
        String email = generatedEmail.getText();
        goToTheTabNumber(0);
        logUtils.infoLog("Random email address is: " + email);
        return email;
    }

    public YopMailInboxPage clickCheckInboxButton() {
        logUtils.infoLog("Click on the 'Check inbox' button");
        checkInboxButton.click();
        return new YopMailInboxPage(driver);
    }
}