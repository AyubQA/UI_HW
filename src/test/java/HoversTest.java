import Pages.HoversPage;
import Pages.SetUP.SetUpsForTests;
import io.qameta.allure.Description;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

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

        assertThat(actualCaption).as("Текст при наведении на фигуру " + figureIndex + " не соответствует ожидаемому. Ожидаемый текст: " + expectedCaption)
                .contains(expectedCaption);
    }
}
