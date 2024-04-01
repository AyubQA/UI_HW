import Pages.AddRemoveElementsPage;
import Pages.SetUP.SetUpsForTests;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddRemoveElementsTest extends SetUpsForTests {
    private AddRemoveElementsPage addRemoveElementsPage;

    @BeforeEach
    public void setUp() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        addRemoveElementsPage = new AddRemoveElementsPage(driver);
    }

    @TestFactory
    @Description("Динамические тесты для проверки добавления/удаления элементов")
    Stream<DynamicTest> testAddRemoveElements() {
        List<DynamicTest> dynamicTests = new ArrayList<>();

        // Сценарии тестов
        int[][] scenarios = new int[][]{{2, 1}, {5, 2}, {1, 3}};

        for (int[] scenario : scenarios) {
            int adds = scenario[0];
            int removes = scenario[1];

            String displayName = String.format("Добавление %d элементов и удаление %d элементов", adds, removes);
            Executable exec = () -> {
                for (int i = 0; i < adds; i++) {
                    addRemoveElementsPage.addElement();
                }
                assertEquals(adds, addRemoveElementsPage.getNumberOfDeleteButtons(),
                        "Количество добавленных элементов не соответствует ожидаемому");

                for (int i = 0; i < removes; i++) {
                    addRemoveElementsPage.removeElement(0);
                }
                assertEquals(Math.max(adds - removes, 0), addRemoveElementsPage.getNumberOfDeleteButtons(),
                        "Количество оставшихся элементов после удаления не соответствует ожидаемому");
            };

            dynamicTests.add(DynamicTest.dynamicTest(displayName, exec));
        }

        return dynamicTests.stream();
    }
}
