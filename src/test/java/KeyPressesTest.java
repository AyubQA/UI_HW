import Pages.KeyPressesPage;
import Pages.SetUP.SetUpsForTests;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

public class KeyPressesTest extends SetUpsForTests {

    @Test
    public void testKeyPresses() {
        KeyPressesPage keyPressesPage = new KeyPressesPage(driver);
        keyPressesPage.open();

        // Ввод и проверка 10 случайных латинских символов
        for (int i = 0; i < 10; i++) {
            char randomChar = keyPressesPage.generateRandomLatinCharacter();
            keyPressesPage.pressKey(String.valueOf(randomChar));
            Assertions.assertThat(keyPressesPage.getResultText())
                    .as(String.format("Текст результата должен соответствовать ожидаемому выводу для символа: %s", randomChar))
                    .containsIgnoringCase("You entered: " + randomChar);
        }

        // Ввод и проверка специальных клавиш
        Keys[] specialKeys = {Keys.ENTER, Keys.CONTROL, Keys.ALT, Keys.TAB};
        String[] specialKeyNames = {"ENTER", "CONTROL", "ALT", "TAB"};
        for (int i = 0; i < specialKeys.length; i++) {
            keyPressesPage.pressKey(specialKeys[i]);
            Assertions.assertThat(keyPressesPage.getResultText())
                    .as(String.format("Текст результата должен соответствовать ожидаемому выводу для специальной клавиши: %s", specialKeyNames[i]))
                    .contains("You entered: " + specialKeyNames[i]);
        }
    }
}
