import Pages.DisappearingElementsPage;
import Pages.SetUP.SetUpsForTests;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisappearingElementsTest extends SetUpsForTests {
    private DisappearingElementsPage disappearingElementsPage;

    @BeforeEach
    public void setUp() {
        driver.get("https://the-internet.herokuapp.com/disappearing_elements");
        disappearingElementsPage = new DisappearingElementsPage(driver);
    }

    @RepeatedTest(10)
    @Description("Проверка исчезающих элементов")
    public void testDisappearingElements(TestInfo testInfo) {
        System.out.println("Попытка номер: " + testInfo.getDisplayName());
        List<WebElement> elements = disappearingElementsPage.getElements();
        // Проверяем, что на странице 5 элементов
        assertEquals(5, elements.size(), "Количество элементов на странице не соответствует ожидаемому");

        boolean found = elements.stream().anyMatch(element -> element.getText().equals("Gallery"));
        assertTrue(found, "Элемент 'Gallery' не найден");

        if (!found) {
            disappearingElementsPage.refreshPage();
        } else {
            System.out.println("Элемент 'Gallery' успешно найден.");
        }
    }
}
