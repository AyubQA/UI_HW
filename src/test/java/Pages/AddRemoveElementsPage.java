package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class AddRemoveElementsPage {

    private WebDriver driver;

    @FindBy(xpath = "//button[text()='Add Element']")
    private WebElement addButton;

    @FindBy(className = "added-manually")
    private List<WebElement> deleteButtons;

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addElement() {
        addButton.click();
    }

    public void removeElement(int index) {
        if (index < deleteButtons.size()) {
            deleteButtons.get(index).click();
        }
    }

    public int getNumberOfDeleteButtons() {
        return deleteButtons.size();
    }

    public String getTextOfDeleteButton(int index) {
        if (index < deleteButtons.size()) {
            return deleteButtons.get(index).getText();
        }
        return "";
    }
}
