import driver.DriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUpChromeBrowser() {
        driver = DriverInstance.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        DriverInstance.closeDriver();
    }
}