package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverInstance {

    private static WebDriver driver;

    private DriverInstance() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            if (System.getProperty("browser") != null) {
                switch (System.getProperty("browser")) {
                    case "edge": {
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        break;
                    }
                    case "firefox": {
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    }
                    case "chrome": {
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                    }
                }
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
    }
}