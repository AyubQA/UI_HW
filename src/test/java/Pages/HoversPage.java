package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {
    private WebDriver driver;
    private By figureBox = By.className("figure");
    private By boxCaption = By.className("figcaption");

    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    public void hoverOverFigure(int index) {
        Actions action = new Actions(driver);
        WebElement figure = driver.findElements(figureBox).get(index - 1);
        action.moveToElement(figure).perform();
    }

    public String getFigureCaption(int index) {
        hoverOverFigure(index);
        return driver.findElements(boxCaption).get(index - 1).getText();
    }
}
