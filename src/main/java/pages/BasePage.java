package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;

public class BasePage {

    protected WebDriverWait waitForLoadingElement;
    protected JavascriptExecutor js;

    @FindBy(xpath = "//button[@aria-label='Consent']")
    private WebElement consentButton;

    @FindBy(xpath = "//*[@aria-label='dismiss cookie message']")
    private WebElement dismissCookieButton;

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected void type(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(WebElement element) {
        return element.getText();
    }

    protected void selectDropdownByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public void clickConsentButton() {
        try {
            click(consentButton);
        } catch (Exception e) {
            System.out.println("Consent button on privacy window not clickable or not visible. Proceeding without clicking.");
        }
    }

    public void clickDismissCookieButton() {
        try {
            click(dismissCookieButton);
        } catch (Exception e) {
            System.out.println("Dismiss cookie button not clickable or not visible. Proceeding without clicking.");
        }
    }
}