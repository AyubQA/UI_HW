package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InfiniteScrollPage {
    private final WebDriver driver;

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Прокрутка страницы до текста: {text}")
    public void scrollToText(String text) {
        // Прокрутка страницы до появления текста
        boolean found = false;
        while (!found) {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            try {
                WebElement element = driver.findElement(By.xpath("//div[contains(text(), '" + text + "')]"));
                if (element.isDisplayed()) {
                    found = true;
                }
            } catch (Exception e) {
                // Продолжаем прокрутку, если элемент не найден
            }
        }
    }

    @Step("Проверка видимости текста: {text}")
    public boolean isTextVisible(String text) {
        try {
            WebElement element = driver.findElement(By.xpath("//div[contains(text(), '" + text + "')]"));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
