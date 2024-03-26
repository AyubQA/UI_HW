package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputsPage {
    private WebDriver driver;
    private By inputField = By.cssSelector("input[type='number']");

    public InputsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterNumber(int number) {
        WebElement input = driver.findElement(inputField);
        input.clear();
        input.sendKeys(String.valueOf(number));
    }

    public String getInputValue() {
        return driver.findElement(inputField).getAttribute("value");
    }
}
