import Pages.HoversPage;
import Pages.SetUP.SetUpsForTests;
import io.qameta.allure.Description;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions;

@ExtendWith(AllureJunit5.class)
public class HoversTest extends SetUpsForTests {
    private HoversPage hoversPage;

    @BeforeEach
    public void setUp() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        hoversPage = new HoversPage(driver);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @Description("Проверка наведения курсора на разные элементы")
    public void testHovers(int figureIndex) {
        String expectedCaption = "name: user" + figureIndex;
        hoversPage.hoverOverFigure(figureIndex);
        String actualCaption = hoversPage.getFigureCaption(figureIndex);
        Assertions.assertTrue(actualCaption.contains(expectedCaption),
                "Текст при наведении на фигуру " + figureIndex + " не соответствует ожидаемому. Ожидаемый текст: " + expectedCaption + ". Фактический текст: " + actualCaption);
    }
}
