import Pages.DropdownPage;
import Pages.SetUP.SetUpsForTests;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropdownTest extends SetUpsForTests {
    private DropdownPage dropdownPage;

    @BeforeClass
    public void setUp() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        dropdownPage = new DropdownPage(driver);
    }

    @Test
    @Description("Проверка выпадающего списка")
    public void testDropdown() {
        dropdownPage.selectOptionByIndex(1); // Выбираем первую опцию
        System.out.println("Текущий текст элемента dropdown: " + dropdownPage.getSelectedOptionText());

        dropdownPage.selectOptionByIndex(2); // Выбираем вторую опцию
        System.out.println("Текущий текст элемента dropdown: " + dropdownPage.getSelectedOptionText());
    }
}
