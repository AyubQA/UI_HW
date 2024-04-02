package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StatusCodesPage {
    private final WebDriver driver;
    private final By link200 = By.linkText("200");
    private final By link301 = By.linkText("301");
    private final By link404 = By.linkText("404");
    private final By link500 = By.linkText("500");
    private final By bodyText = By.cssSelector("body");

    public StatusCodesPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по ссылке статусного кода {statusCode}")
    public void clickStatusCodeLink(String statusCode) {
        switch (statusCode) {
            case "200":
                driver.findElement(link200).click();
                break;
            case "301":
                driver.findElement(link301).click();
                break;
            case "404":
                driver.findElement(link404).click();
                break;
            case "500":
                driver.findElement(link500).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid status code: " + statusCode);
        }
    }

    @Step("Получение текста тела страницы")
    public String getBodyText() {
        return driver.findElement(bodyText).getText();
    }
}
