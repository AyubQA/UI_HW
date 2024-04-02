package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NotificationMessagePage {
    private final WebDriver driver;
    private final By linkClickHere = By.linkText("Click here");
    private final By notification = By.id("flash");
    private final By closeButton = By.cssSelector("a.close");

    public NotificationMessagePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по ссылке 'Click here'")
    public void clickLinkClickHere() {
        driver.findElement(linkClickHere).click();
    }

    @Step("Получение текста уведомления")
    public String getNotificationMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(notification));
        return messageElement.getText();
    }

    @Step("Закрытие уведомления")
    public void closeNotification() {
        try {
            driver.findElement(closeButton).click();
        } catch (Exception e) {
            System.out.println("Не удалось закрыть уведомление");
        }
    }
}
