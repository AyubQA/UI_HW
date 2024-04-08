package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
    private final WebDriver driver;
    private final By contextBox = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Правый клик по элементу контекстного меню")
    public void rightClickOnBox() {
        WebElement box = driver.findElement(contextBox);
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
    }

    @Step("Получение текста из всплывающего окна")
    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    @Step("Потверждение всплывающего окна")
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
}
