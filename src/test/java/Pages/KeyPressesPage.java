package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class KeyPressesPage {
    private final WebDriver driver;

    private final By resultText = By.id("result");

    public KeyPressesPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие страницы Key Presses")
    public void open() {
        driver.get("https://the-internet.herokuapp.com/key_presses");
    }

    @Step("Нажатие клавиши: {key}")
    public void pressKey(CharSequence key) {
        new Actions(driver).sendKeys(key).perform();
    }

    @Step("Получение текста результата")
    public String getResultText() {
        return driver.findElement(resultText).getText();
    }

    @Step("Генерация случайного латинского символа")
    public char generateRandomLatinCharacter() {
        return (char) ('a' + new Random().nextInt(26));
    }
}
