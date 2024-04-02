package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {
    private final WebDriver driver;
    private final By figureBox = By.className("figure");
    private final By boxCaption = By.className("figcaption");

    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Наведение на фигуру с индексом {index}")
    public void hoverOverFigure(int index) {
        Actions action = new Actions(driver);
        WebElement figure = driver.findElements(figureBox).get(index - 1);
        action.moveToElement(figure).perform();
    }

    @Step("Получение подписи фигуры с индексом {index}")
    public String getFigureCaption(int index) {
        hoverOverFigure(index);
        return driver.findElements(boxCaption).get(index - 1).getText();
    }
}
