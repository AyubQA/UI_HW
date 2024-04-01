import Pages.DropdownPage;
import Pages.SetUP.SetUpsForTests;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals("Option 1", selectedOptionText1, "Выбранная опция не соответствует 'Option 1'");


        dropdownPage.selectOptionByIndex(2);
        String selectedOptionText2 = dropdownPage.getSelectedOptionText();
        System.out.println("Текущий текст элемента dropdown: " + selectedOptionText2);
        // Проверяем, что текст выбранной опции соответствует ожидаемому
        assertEquals("Option 2", selectedOptionText2, "Выбранная опция не соответствует 'Option 2'");
    }
}
