import Pages.InputsPage;
import Pages.SetUP.SetUpsForTests;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class InputsTest extends SetUpsForTests {
    private InputsPage inputsPage;

    @BeforeClass
    public void setUp() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        inputsPage = new InputsPage(driver);
    }

    @Test
    @Description("Проверка ввода числа")
    public void testInputs() {
        Random random = new Random();
        int number = random.nextInt(10000);
        inputsPage.enterNumber(number);
        System.out.println("Введенное число: " + inputsPage.getInputValue());
    }
}
