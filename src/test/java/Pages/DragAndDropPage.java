package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {
    private final WebDriver driver;
    private final By columnA = By.id("column-a");
    private final By columnB = By.id("column-b");

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }

    public void dragAtoB() {
        WebElement from = driver.findElement(columnA);
        WebElement to = driver.findElement(columnB);
        Actions actions = new Actions(driver);
        // Используем более надежный способ для drag-and-drop через offset
        actions.clickAndHold(from)
                .moveToElement(to)
                .release(to)
                .perform();
    }

    public String getColumnAText() {
        return driver.findElement(columnA).getText();
    }

    public String getColumnBText() {
        return driver.findElement(columnB).getText();
    }
}
