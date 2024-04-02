package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class AddRemoveElementsPage {

    @FindBy(xpath = "//button[text()='Add Element']")
    private WebElement addButton;

    @FindBy(className = "added-manually")
    private List<WebElement> deleteButtons;

    public AddRemoveElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Step("Добавление элемента")
    public void addElement() {
        addButton.click();
    }

    @Step("Удаление элемента с индексом {index}")
    public void removeElement(int index) {
        if (index >= 0 && index < deleteButtons.size()) {
            deleteButtons.get(index).click();
        } else {
            throw new IllegalArgumentException("Index out of bounds for delete buttons list: " + index);
        }
    }

    @Step("Получение количества кнопок удаления")
    public int getNumberOfDeleteButtons() {
        return deleteButtons.size();
    }
}
