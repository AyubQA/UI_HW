package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputsPage {
    private final WebDriver driver;
    private final By inputField = By.cssSelector("input[type='number']");

    public InputsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввод числа {number} в поле ввода")
    public void enterNumber(int number) {
        WebElement input = driver.findElement(inputField);
        input.clear();
        input.sendKeys(String.valueOf(number));
    }

    @Step("Получение значения из поля ввода")
    public String getInputValue() {
        return driver.findElement(inputField).getAttribute("value");
    }
}
