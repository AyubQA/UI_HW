import Pages.CheckboxesPage;
import Pages.SetUP.SetUpsForTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckboxesTest extends SetUpsForTests {
    private CheckboxesPage checkboxesPage;

    @BeforeEach
    public void setUp() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        checkboxesPage = new CheckboxesPage(driver);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1}) // Здесь можно изменить порядок индексов для изменения порядка нажатий
    public void testCheckboxes(int index) {
        // Проверяем начальное состояние чекбокса
        boolean initialState = checkboxesPage.isCheckboxSelected(index);

        // Нажимаем на чекбокс
        checkboxesPage.clickCheckbox(index);

        // Проверяем, что состояние чекбокса изменилось
        if (initialState) {
            assertThat(checkboxesPage.isCheckboxSelected(index))
                    .as("Чекбокс с индексом " + index + " должен был быть снят, но остался выбранным.")
                    .isFalse();
        } else {
            assertThat(checkboxesPage.isCheckboxSelected(index))
                    .as("Чекбокс с индексом " + index + " должен был быть выбран, но остался не выбранным.")
                    .isTrue();
        }
    }
}
