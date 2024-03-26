package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxesPage {
    private WebDriver driver;
    private By checkboxes = By.cssSelector("input[type='checkbox']");

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckbox(int index) {
        List<WebElement> checkboxesList = driver.findElements(checkboxes);
        checkboxesList.get(index).click();
    }

    public boolean isCheckboxSelected(int index) {
        List<WebElement> checkboxesList = driver.findElements(checkboxes);
        return checkboxesList.get(index).isSelected();
    }
}
