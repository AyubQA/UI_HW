import Pages.AddRemoveElementsPage;
import Pages.SetUP.SetUpsForTests;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddRemoveElementsTest extends SetUpsForTests {
    private AddRemoveElementsPage addRemoveElementsPage;

    @BeforeEach
    public void setUp() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        addRemoveElementsPage = new AddRemoveElementsPage(driver);
    }


    @TestFactory
    @Description("Динамический тест для проверки добавления и удаления элементов")
    Stream<DynamicTest> testAddRemoveElements() {
        // Сценарии тестов: {количество добавлений, количество удалений}
        int[][] scenarios = new int[][]{{2, 1}, {5, 2}, {1, 3}};


        return Stream.of(scenarios).map(scenario -> {
            int adds = scenario[0];
            int removes = scenario[1];
            int expectedElements = adds - removes + addRemoveElementsPage.getNumberOfDeleteButtons();

            return DynamicTest.dynamicTest("Добавление " + adds + " элементов и удаление " + removes,
                    () -> {
                        // Добавление элементов
                        for (int i = 0; i < adds; i++) {
                            addRemoveElementsPage.addElement();
                        }

                        // Удаление элементов
                        for (int i = 0; i < removes; i++) {
                            addRemoveElementsPage.removeElement(0);
                        }

                        // Проверка общего количества элементов
                        assertAll("Проверка количества элементов после добавления и удаления",
                                () -> assertEquals(expectedElements, addRemoveElementsPage.getNumberOfDeleteButtons(),
                                        "Количество оставшихся элементов после добавления и удаления не соответствует ожидаемому")
                        );
                    });
        });
    }
}
