import Pages.CheckboxesPage;
import Pages.SetUP.SetUpsForTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckboxesTest extends SetUpsForTests {
    private CheckboxesPage checkboxesPage;

    @BeforeClass
    public void setUp() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        checkboxesPage = new CheckboxesPage(driver);
    }

    @Test
    public void testCheckboxes() {
        checkboxesPage.clickCheckbox(0);
        System.out.println("Первый чекбокс: " + checkboxesPage.isCheckboxSelected(0));
        checkboxesPage.clickCheckbox(1);
        System.out.println("Второй чекбокс: " + checkboxesPage.isCheckboxSelected(1));
    }
}
