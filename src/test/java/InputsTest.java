import Pages.InputsPage;
import Pages.SetUP.SetUpsForTests;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputsTest extends SetUpsForTests {
    private InputsPage inputsPage;

    @BeforeEach
    public void setUp() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        inputsPage = new InputsPage(driver);
    }

    @TestFactory
    @Description("Проверка ввода числа")
    public Stream<DynamicTest> testInputs() {
        Random random = new Random();
        return Stream.generate(() -> random.nextInt(10000))
                .limit(3)
                .map(number -> DynamicTest.dynamicTest("Проверка ввода числа: " + number, () -> {
                    inputsPage.enterNumber(number);
                    assertThat(inputsPage.getInputValue()).as("Введенное число не совпадает с отображаемым").isEqualTo(String.valueOf(number));
                }));
    }

    @TestFactory
    @Description("Проверка негативных кейсов ввода")
    public Stream<DynamicTest> testNegativeCases() {
        List<String> invalidInputs = Arrays.asList("abc", "123abc", " abc", "abc ", " 123 ", "!@#$%^&*()");

        return invalidInputs.stream().map(input -> DynamicTest.dynamicTest("Проверка негативного кейса: " + input, () -> {
            inputsPage.enterText(input);
            assertThat(inputsPage.getInputValue()).as("Ввод не должен быть принят").doesNotContain(input);
        }));
    }
}
