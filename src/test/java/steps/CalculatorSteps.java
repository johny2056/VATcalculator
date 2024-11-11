package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CalculatorPage;
import org.testng.Assert;

public class CalculatorSteps { 

    private static final String VAT_URL = "http://www.calkoo.com/?lang=3&page=8";

    WebDriver driver;
    CalculatorPage calculatorPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(VAT_URL);
        calculatorPage = new CalculatorPage(driver);
        calculatorPage.clickConsentButton();
        calculatorPage.clickDismissCookieButton();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @When("I select the country {string}")
    public void selectCountry(String country) {
        calculatorPage.selectCountry(country);
    }

    @And("I select the VAT rate {string}")
    public void selectVatRate(String vatRate) {
        calculatorPage.selectVatRate(vatRate);
    }

    @And("I enter the net amount {string}")
    public void enterNetAmount(String netAmount) {
        calculatorPage.enterNetAmount(netAmount);
    }

    @Then("I should see the gross amount {string} and the VAT amount {string}")
    public void verifyCalculatedAmounts(String grossAmount, String vatAmount) {
        Assert.assertEquals(grossAmount, calculatorPage.getGrossAmount());
        Assert.assertEquals(vatAmount, calculatorPage.getVatAmount());
    }

    @Then("I should see an error message {string}")
    public void verifyErrorMessage(String errorMessage) {
        Assert.assertEquals(errorMessage, calculatorPage.getErrorMessage());
    }
}