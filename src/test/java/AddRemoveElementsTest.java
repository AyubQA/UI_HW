import Pages.AddRemoveElementsPage;
import Pages.SetUP.SetUpsForTests;
import io.qameta.allure.Description;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@ExtendWith(AllureJunit5.class)
public class AddRemoveElementsTest extends SetUpsForTests {
    private AddRemoveElementsPage addRemoveElementsPage;

    @BeforeClass
    public void setUp() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        addRemoveElementsPage = new AddRemoveElementsPage(driver);
    }

    @Test
    @Description("Проверка добавления/удаления элементов")
    public void testAddRemoveElements() {
        // Добавление элементов
        for (int i = 0; i < 5; i++) {
            addRemoveElementsPage.addElement();
            System.out.println("Добавлен элемент: " + addRemoveElementsPage.getTextOfDeleteButton(i));
        }

        // Удаление элементов
        for (int i = 0; i < 3; i++) {
            addRemoveElementsPage.removeElement(0); // Удаляем первую кнопку, так как после удаления индексы сдвигаются
            System.out.println("Оставшееся количество кнопок Delete: " + addRemoveElementsPage.getNumberOfDeleteButtons());
        }
    }
}
