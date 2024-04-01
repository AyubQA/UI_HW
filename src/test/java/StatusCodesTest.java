import Pages.SetUP.SetUpsForTests;
import Pages.StatusCodesPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StatusCodesTest extends SetUpsForTests {
    private StatusCodesPage statusCodesPage;

    @BeforeEach
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
            String pageTitle = driver.getTitle();
            assertTrue(pageTitle.contains(statusCode), "Заголовок страницы не содержит ожидаемый статус: " + statusCode);
            System.out.println("Текст после перехода на страницу статуса " + statusCode + ": " + statusCodesPage.getBodyText());
            driver.navigate().back();
        }
    }
}
