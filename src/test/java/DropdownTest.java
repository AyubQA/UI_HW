import Pages.DropdownPage;
import Pages.SetUP.SetUpsForTests;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DropdownTest extends SetUpsForTests {
    private DropdownPage dropdownPage;

    @BeforeEach
    public void setUp() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        dropdownPage = new DropdownPage(driver);
    }

    @Test
    @Description("Проверка выпадающего списка")
    public void testDropdown() {
        dropdownPage.selectOptionByIndex(1);
        String selectedOptionText1 = dropdownPage.getSelectedOptionText();
        System.out.println("Текущий текст элемента dropdown: " + selectedOptionText1);
        // Проверяем, что текст выбранной опции соответствует ожидаемому
        assertThat(selectedOptionText1).as("Выбранная опция не соответствует 'Option 1'").isEqualTo("Option 1");

        dropdownPage.selectOptionByIndex(2);
        String selectedOptionText2 = dropdownPage.getSelectedOptionText();
        System.out.println("Текущий текст элемента dropdown: " + selectedOptionText2);
        // Проверяем, что текст выбранной опции соответствует ожидаемому
        assertThat(selectedOptionText2).as("Выбранная опция не соответствует 'Option 2'").isEqualTo("Option 2");
    }
}
