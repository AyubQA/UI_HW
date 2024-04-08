import Pages.DisappearingElementsPage;
import Pages.SetUP.SetUpsForTests;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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

        // Используем AssertJ для проверки количества элементов
        assertThat(elements).as("Количество элементов на странице не соответствует ожидаемому")
                .hasSize(5);

        // Используем AssertJ для проверки наличия элемента 'Gallery'
        assertThat(elements.stream().anyMatch(element -> element.getText().equals("Gallery")))
                .as("Элемент 'Gallery' не найден")
                .isTrue();
    }
}
