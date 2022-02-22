package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

class BasePage {
    WebDriver driver;
    JavascriptExecutor js;

    BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    void waitUntilElementClickable(WebElement webElement) {
        new WebDriverWait(driver, 4).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    void waitUntilListOfElementsVisible(List<WebElement> webElements) {
        new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOfAllElements(webElements));
    }

    void waitUntilElementVisible(WebElement webElement) {
        new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOf(webElement));
    }

    void scrollPageToTheElement(WebElement webElement) {
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", webElement);
    }
}