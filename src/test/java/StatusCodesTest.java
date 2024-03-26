import Pages.SetUP.SetUpsForTests;
import Pages.StatusCodesPage;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StatusCodesTest extends SetUpsForTests {
    private StatusCodesPage statusCodesPage;

    @BeforeClass
    public void setUp() {
        driver.get("https://the-internet.herokuapp.com/status_codes");
        statusCodesPage = new StatusCodesPage(driver);
    }

    @Test
    @Description("Проверка статусных кодов")
    public void testStatusCodes() {
        String[] statusCodes = {"200", "301", "404", "500"};
        for (String statusCode : statusCodes) {
            statusCodesPage.clickStatusCodeLink(statusCode);
            System.out.println("Текст после перехода на страницу статуса " + statusCode + ": " + statusCodesPage.getBodyText());
            driver.navigate().back();
        }
    }
}
