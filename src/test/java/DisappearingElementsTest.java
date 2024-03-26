import Pages.DisappearingElementsPage;
import Pages.SetUP.SetUpsForTests;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class DisappearingElementsTest extends SetUpsForTests {
    private DisappearingElementsPage disappearingElementsPage;

    @BeforeClass
    public void setUp() {
        driver.get("https://the-internet.herokuapp.com/disappearing_elements");
        disappearingElementsPage = new DisappearingElementsPage(driver);
    }

    @Test
    @Description("Проверка исчезающих элементов")
    public void testDisappearingElements() {
        int attempts = 0;
        boolean found = false;
        while (attempts < 10 && !found) {
            List<WebElement> elements = disappearingElementsPage.getElements();
            for (WebElement element : elements) {
                if (element.getText().equals("Gallery")) {
                    System.out.println("Пятый элемент найден: " + element.getText());
                    found = true;
                    break;
                }
            }
            if (!found) {
                disappearingElementsPage.refreshPage();
                attempts++;
            }
        }
        if (!found) {
            System.out.println("Не удалось найти элемент 'Gallery' за 10 попыток");
        }
    }
}
