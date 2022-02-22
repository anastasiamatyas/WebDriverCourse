import models.ComputeEngineCreator;
import org.testng.annotations.Test;
import steps.Steps;

public class GoogleCloudPricingCalculatorTest extends BaseTest {

    @Test(groups = "smoke")
    public void totalEstimatesCostInPricingCalculatorAndInEmailMatchers() {
        Steps i = new Steps(driver);
        i.findSearchQueryOnGoogleCloudPage("Google Cloud Pricing Calculator");
        i.getTotalEstimatedCostInCalculator(ComputeEngineCreator.createBasicComputeEngine());
        i.sendEmailWithPropose();
        i.getTotalEstimatedCostInEmail();
        i.assertThatTotalEstimatesCostInPricingCalculatorAndInEmail();
    }
}