package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddRemoveElementsPage {
    private final WebDriver driver;
    private By addButton = By.xpath("//button[text()='Add Element']");
    private By deleteButtons = By.className("added-manually");

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addElement() {
        driver.findElement(addButton).click();
    }

    public void removeElement(int index) {
        List<WebElement> buttons = driver.findElements(deleteButtons);
        if (index < buttons.size()) {
            buttons.get(index).click();
        }
    }

    public int getNumberOfDeleteButtons() {
        return driver.findElements(deleteButtons).size();
    }

    public String getTextOfDeleteButton(int index) {
        List<WebElement> buttons = driver.findElements(deleteButtons);
        if (index < buttons.size()) {
            return buttons.get(index).getText();
        }
        return "";
    }
}
