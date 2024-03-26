import Pages.HoversPage;
import Pages.SetUP.SetUpsForTests;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HoversTest extends SetUpsForTests {
    private HoversPage hoversPage;

    @BeforeClass
    public void setUp() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        hoversPage = new HoversPage(driver);
    }

    @Test
    @Description("Проверка наведения курсора")
    public void testHovers() {
        for (int i = 1; i <= 3; i++) {
            String caption = hoversPage.getFigureCaption(i);
            System.out.println("Текст при наведении на фигуру " + i + ": " + caption);
        }
    }
}
