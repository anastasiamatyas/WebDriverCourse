package pages;

import modals.EmailForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.LogUtils;

import java.util.List;

public class GoogleCloudPricingCalculatorPage extends BasePage {
    LogUtils logUtils = LogUtils.getInstance();
    String calculatorPage;

    @FindBy(css = "[type = 'cookie-notification'] button")
    private WebElement acceptCookieButton;

    @FindBy(css = "md-pagination-wrapper .tab-holder.compute[title='Compute Engine']")
    private WebElement computeEngineTab;

    @FindBy(xpath = "//*[contains(text(), 'Number of instances')]/following-sibling::input")
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = "//*[contains(text(), 'What are these instances for?')]/following-sibling::input")
    private WebElement whatAreTheseInstancesForInput;

    @FindBy(xpath = "//*[contains(text(), 'Operating System / Software')]/following-sibling::md-select")
    private WebElement operatingSystemDropdown;

    @FindBy(xpath = "//*[@id='select_container_92']//md-option")
    private List<WebElement> operatingSystemList;

    @FindBy(xpath = "//*[contains(text(), 'Machine Class')]/following-sibling::md-select")
    private WebElement machineClassDropdown;

    @FindBy(xpath = "//*[@id='select_container_96']//md-option")
    private List<WebElement> machineClassList;

    @FindBy(xpath = "//*[contains(text(), 'Series')]/following-sibling::md-select")
    private WebElement seriesDropdown;

    @FindBy(xpath = "//*[@id='select_container_104']//md-option")
    private List<WebElement> seriesList;

    @FindBy(xpath = "//*[contains(text(), 'Machine type')]/following-sibling::md-select")
    private WebElement machineTypeDropdown;

    @FindBy(xpath = "//*[@id='select_container_106']//md-option")
    private List<WebElement> machineTypeList;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGPUCheckbox;

    @FindBy(css = "[ng-model='listingCtrl.computeServer.gpuType']")
    private WebElement gpuTypeDropdown;

    @FindBy(xpath = "//div[@id='select_container_455']//md-option")
    private List<WebElement> gpuTypeList;

    @FindBy(css = "[ng-model='listingCtrl.computeServer.gpuCount']")
    private WebElement numbersOfGPUDropdown;

    @FindBy(xpath = "//div[@id='select_container_457']//md-option")
    private List<WebElement> numbersOfGPUList;

    @FindBy(css = "[ng-model='listingCtrl.computeServer.ssd']")
    private WebElement localSSDDropdown;

    @FindBy(xpath = "//div[@id='select_container_417']//md-option")
    private List<WebElement> localSSDList;

    @FindBy(css = "[ng-model='listingCtrl.computeServer.location']")
    private WebElement datacenterLocationDropdown;

    @FindBy(xpath = "//div[@id='select_container_112']//md-option")
    private List<WebElement> datacenterLocationList;

    @FindBy(css = "[ng-model='listingCtrl.computeServer.cud']")
    private WebElement committedUsageDropdown;

    @FindBy(xpath = "//div[@id='select_container_119']//md-option")
    private List<WebElement> committedUsageList;

    @FindBy(css = "[ng-if='listingCtrl.showComputeEngine'] [aria-label='Add to Estimate']")
    private WebElement addToEstimateButton;

    @FindBy(css = "[aria-label='Email Estimate']")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//b[contains(.,'Total Estimated Cost')]")
    private WebElement totalEstimatedCost;

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
        calculatorPage = driver.getWindowHandle();
    }

    public GoogleCloudPricingCalculatorPage acceptCookie() {
        logUtils.infoLog("Accept cookie on the page");
        waitUntilElementClickable(acceptCookieButton);
        acceptCookieButton.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage clickOnComputeEngineTab() {
        logUtils.infoLog("Click on the compute engine tab");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, '/products/calculator')]")))
                .switchTo().frame("myFrame");
        computeEngineTab.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage enterNumberOfInstances(String numberOfInstances) {
        logUtils.infoLog("Input number of instances: " + numberOfInstances);
        numberOfInstancesInput.sendKeys(numberOfInstances);
        return this;
    }

    public GoogleCloudPricingCalculatorPage enterWhatAreTheseInstancesFor(String description) {
        logUtils.infoLog("Input description: " + description);
        numberOfInstancesInput.sendKeys(description);
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseOperatingSystem(String operatingSystem) {
        logUtils.infoLog("Choose operating system: " + operatingSystem);
        scrollPageToTheElement(operatingSystemDropdown);
        operatingSystemDropdown.click();
        waitUntilListOfElementsVisible(operatingSystemList);
        operatingSystemList.stream().map(x -> x.findElement(By.xpath("//div[@id='select_container_92']//div[contains(.,'" + operatingSystem + "')]"))).findFirst().get().click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseMachineClass(String machineClass) {
        logUtils.infoLog("Choose machine class: " + machineClass);
        scrollPageToTheElement(machineClassDropdown);
        machineClassDropdown.click();
        waitUntilListOfElementsVisible(machineClassList);
        machineClassList.stream().map(x -> x.findElement(By.xpath("//div[@id='select_container_96']//div[contains(.,'" + machineClass + "')]"))).findFirst().get().click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseSeries(String series) {
        logUtils.infoLog("Choose series: " + series);
        scrollPageToTheElement(seriesDropdown);
        seriesDropdown.click();
        waitUntilListOfElementsVisible(seriesList);
        seriesList.stream().map(x -> x.findElement(By.xpath("//*[@id='select_container_104']//div[contains(.,'" + series + "')]"))).findFirst().get().click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseMachineType(String machineType) {
        logUtils.infoLog("Choose machine type: " + machineType);
        scrollPageToTheElement(machineTypeDropdown);
        machineTypeDropdown.click();
        waitUntilListOfElementsVisible(machineTypeList);
        machineTypeList.stream().map(x -> x.findElement(By.xpath("//*[@id='select_container_106']//div[contains(.,'" + machineType + "')]"))).findFirst().get().click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage enableAddGPUCheckbox() {
        logUtils.infoLog("Enable 'Add GPU' checkbox");
        scrollPageToTheElement(addGPUCheckbox);
        addGPUCheckbox.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseGPUType(String gpuType) {
        logUtils.infoLog("Choose GPU type: " + gpuType);
        scrollPageToTheElement(gpuTypeDropdown);
        gpuTypeDropdown.click();
        waitUntilListOfElementsVisible(gpuTypeList);
        gpuTypeList.stream().map(x -> x.findElement(By.xpath("//div[@id='select_container_455']//md-option[contains(.,'" + gpuType + "')]"))).findFirst().get().click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseNumberOfGPU(String numberOfGPU) {
        logUtils.infoLog("Choose number of GPU: " + numberOfGPU);
        scrollPageToTheElement(numbersOfGPUDropdown);
        numbersOfGPUDropdown.click();
        waitUntilListOfElementsVisible(numbersOfGPUList);
        numbersOfGPUList.stream().map(x -> x.findElement(By.xpath("//div[@id='select_container_457']//md-option[contains(.,'" + numberOfGPU + "')]"))).findFirst().get().click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseLocalSSD(String ssdName) {
        logUtils.infoLog("Choose local SSD: " + ssdName);
        scrollPageToTheElement(localSSDDropdown);
        localSSDDropdown.click();
        waitUntilListOfElementsVisible(localSSDList);
        localSSDList.stream().map(x -> x.findElement(By.xpath("//div[@id='select_container_417']//md-option[contains(.,'" + ssdName + "')]"))).findFirst().get().click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseDatacenterLocation(String datacenterLocation) {
        logUtils.infoLog("Choose datacenter location: " + datacenterLocation);
        scrollPageToTheElement(datacenterLocationDropdown);
        datacenterLocationDropdown.click();
        waitUntilListOfElementsVisible(datacenterLocationList);
        datacenterLocationList.stream().map(x -> x.findElement(By.xpath("//div[@id='select_container_112']//md-option[contains(.,'" + datacenterLocation + "')]"))).findFirst().get().click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseCommittedUsage(String committedUsage) {
        logUtils.infoLog("Choose committed usage: " + committedUsage);
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", committedUsageDropdown);
        committedUsageDropdown.click();
        waitUntilListOfElementsVisible(committedUsageList);
        committedUsageList.stream().map(x -> x.findElement(By.xpath("//div[@id='select_container_119']//md-option[contains(.,'" + committedUsage + "')]"))).findFirst().get().click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage clickAddToEstimateButton() {
        logUtils.infoLog("Click 'Add to estimate' button");
        addToEstimateButton.click();
        return this;
    }

    public EmailForm clickEmailEstimateButton() {
        logUtils.infoLog("Click 'Email Estimate' button");
        scrollPageToTheElement(emailEstimateButton);
        emailEstimateButton.click();
        return new EmailForm(driver);
    }

    public String getTotalEstimatedCost() {
        return totalEstimatedCost.getText();
    }
}