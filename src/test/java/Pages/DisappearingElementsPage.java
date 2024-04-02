package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DisappearingElementsPage {
    private final WebDriver driver;
    private final By elementsLocator = By.cssSelector("ul li a");

    public DisappearingElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Получение списка элементов")
    public List<WebElement> getElements() {
        return driver.findElements(elementsLocator);
    }

    @Step("Получение элемента с индексом {index}")
    public WebElement getElement(int index) {
        return getElements().get(index);
    }

    @Step("Получение текста элемента с индексом {index}")
    public String getElementText(int index) {
        return getElement(index).getText();
    }

    @Step("Обновление страницы")
    public void refreshPage() {
        driver.navigate().refresh();
    }
}
