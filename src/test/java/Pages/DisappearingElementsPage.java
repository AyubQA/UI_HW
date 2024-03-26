package Pages;

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

    public List<WebElement> getElements() {
        return driver.findElements(elementsLocator);
    }

    public WebElement getElement(int index) {
        return getElements().get(index);
    }

    public String getElementText(int index) {
        return getElement(index).getText();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }
}
