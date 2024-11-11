package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage extends BasePage {

    @FindBy(name = "Country")
    private WebElement countryDropdown;

    @FindBy(id = "NetPrice")
    private WebElement netPriceInput;

    @FindBy(id = "VATsum")
    private WebElement vatSumInput;

    @FindBy(id = "Price")
    private WebElement grossPriceInput;

    @FindBy(name = "clear")
    private WebElement resetButton;

    @FindBy(xpath = "//div[contains(@id, 'google-visualization-errors')]/span")
    private WebElement errorField;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void selectCountry(String countryValue) {
        selectDropdownByValue(countryDropdown, countryValue);
    }

    public void selectVatRate(String vatRate) {
        WebElement vatRateElement = driver.findElement(By.xpath("//label[@for='VAT_"+vatRate+"']"));
        click(vatRateElement);
    }

    public void enterNetAmount(String netAmount) {
        type(netPriceInput, netAmount);
    }

    public void enterVatAmount(String vatAmount) {
        type(vatSumInput, vatAmount);
    }

    public void enterGrossAmount(String grossAmount) {
        type(grossPriceInput, grossAmount);
    }

    public void clickResetButton() {
        click(resetButton);
    }

    public String getGrossAmount() {
        return (String) js.executeScript("return $(arguments[0]).prop('value');", grossPriceInput);
    }

    public String getVatAmount() {
        return (String) js.executeScript("return $(arguments[0]).prop('value');", vatSumInput);
    }

    public String getErrorMessage() {
        return getText(errorField).substring(0, getText(errorField).length() - 1);
    }
}