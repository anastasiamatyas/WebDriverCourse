package modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.GoogleCloudPricingCalculatorPage;

public class EmailForm {
    WebDriver driver;

    @FindBy(css = "[ng-model='emailQuote.user.email']")
    private WebElement emailInput;

    @FindBy(css = "button[aria-label='Send Email']")
    private WebElement sendEmailButton;

    public EmailForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public EmailForm enterEmail(String email) {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, '/products/calculator')]")))
                .switchTo().frame("myFrame");
        emailInput.click();
        emailInput.sendKeys(email);
        return this;
    }

    public GoogleCloudPricingCalculatorPage clickSendEmailButton() {
        sendEmailButton.click();
        return new GoogleCloudPricingCalculatorPage(driver);
    }
}