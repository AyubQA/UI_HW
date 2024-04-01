package Pages.SetUP;

import Pages.Driver.ChromeDriverSetUP;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Это позволяет использовать нестатические методы @BeforeAll и @AfterAll
public class SetUpsForTests {
    protected WebDriver driver;

    @BeforeAll
    public void setUpClass() {
        driver = ChromeDriverSetUP.getDriver();
    }

    @AfterAll
    public void tearDownClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}
