package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxesPage {
    private final WebDriver driver;
    private final By checkboxes = By.cssSelector("input[type='checkbox']");

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по чекбоксу с индексом {index}")
    public void clickCheckbox(int index) {
        List<WebElement> checkboxesList = driver.findElements(checkboxes);
        checkboxesList.get(index).click();
    }

    @Step("Проверка, выбран ли чекбокс с индексом {index}")
    public boolean isCheckboxSelected(int index) {
        List<WebElement> checkboxesList = driver.findElements(checkboxes);
        return checkboxesList.get(index).isSelected();
    }
}
