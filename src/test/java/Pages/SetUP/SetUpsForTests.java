package Pages.SetUP;

import Pages.Driver.ChromeDriverSetUP;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SetUpsForTests {
    protected WebDriver driver;

    @BeforeClass
    public void setUpClass() {
        driver = ChromeDriverSetUP.getDriver();
    }

    @AfterClass
    public void tearDownClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}
